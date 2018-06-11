package com.redbee.microblog.controller;

import com.redbee.microblog.entity.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@Api(value="PostControllerValue", description="Traverlers can post and hashtag content.")
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private TravelerRepository travelerRepository;
    @Autowired
    private PostTravelerMentionsRepository postTravelerMentionsRepository;
    @Autowired
    private NoExistingUserRepository noExistingUserRepository;
    @Autowired
    private PostNoExistingUserMentionsRepository postNoExistingUserMentionsRepository;


    @GetMapping("/post")
    @ApiOperation(value = "View a list of created posts", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public Iterable<PostEntity> retrieveAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping("/post")
    @ApiOperation(value = "Insert a new post and the traveler who posted it.", response = Iterable.class)
    public String createPost(@RequestBody PostJson postJson) {

        if(postJson.getText().length()<3 || postJson.getText().length()>1024 )
            return "Length error";

        PostEntity postEntity = new PostEntity();
        postEntity.setText(postJson.getText());
        postEntity.setFlagWaiting();

        TravelerEntity travelerEntity;
        travelerEntity = travelerRepository.findFirstByName(postJson.getTravelerByTravelerOwnerName());
        if(travelerEntity == null) {
            travelerEntity = new TravelerEntity();
            travelerEntity.setName(postJson.getTravelerByTravelerOwnerName());
            travelerRepository.save(travelerEntity);
        }
        postEntity.setTravelerByTravelerOwnerIdtraveler(travelerEntity);
        postRepository.save(postEntity);


        String pattern = "@([a-z0-9_-]{3,64})";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(postJson.getText());
            while (m.find()) {
                InsertUserMention(m.group().substring(1),postEntity);
        }

            //postEntity.setPostTravelerMentionsByIdpost(travelerEntityMention);
            //postRepository.save(postEntity);


        //  Student savedStudent = studentRepository.save(student);
       /* URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();
        return ResponseEntity.created(location).build();*/
       return "ok";

    }

    private void InsertUserMention(String name, PostEntity postEntity){
        TravelerEntity travelerEntityMention = travelerRepository.findFirstByName(name);
        if(travelerEntityMention == null) {
            NoExistingUserEntity noExistingUserEntity = noExistingUserRepository.findFirstByName(name);
            if(noExistingUserEntity == null){
                noExistingUserEntity = new NoExistingUserEntity();
                noExistingUserEntity.setName(name);
                noExistingUserRepository.save(noExistingUserEntity);
            }
            PostNoExistingUserMentionsEntity postNoExistingUserMentionsEntity = new PostNoExistingUserMentionsEntity();
            postNoExistingUserMentionsEntity.setNoExistingUserIdnoExistingUser(noExistingUserEntity.getIdnoExistingUser());
            postNoExistingUserMentionsEntity.setPostIdpost(postEntity.getIdpost());
            postNoExistingUserMentionsRepository.save(postNoExistingUserMentionsEntity);
        }
        else {
            PostTravelerMentionsEntity postTravelerMentionsEntity = new PostTravelerMentionsEntity();
            postTravelerMentionsEntity.setTravelerIdtraveler(travelerEntityMention.getIdtraveler());
            postTravelerMentionsEntity.setPostIdpost(postEntity.getIdpost());
            postTravelerMentionsRepository.save(postTravelerMentionsEntity);
        }
    }
}

class PostJson{
    private String text;
    private String travelerByTravelerOwnerName;

    public PostJson(String text, String travelerByTravelerOwnerName) {
        this.text = text;
        this.travelerByTravelerOwnerName = travelerByTravelerOwnerName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTravelerByTravelerOwnerName() {
        return travelerByTravelerOwnerName;
    }

    public void setTravelerByTravelerOwnerName(String travelerByTravelerOwnerName) {
        this.travelerByTravelerOwnerName = travelerByTravelerOwnerName;
    }
}