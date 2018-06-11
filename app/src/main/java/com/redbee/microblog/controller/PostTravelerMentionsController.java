package com.redbee.microblog.controller;

import com.redbee.microblog.entity.PostTravelerMentionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PostTravelerMentionsController {

    @Autowired
    private PostTravelerMentionsRepository postRepository;

    @GetMapping("/postmentions")
    public Iterable<PostTravelerMentionsEntity> retrieveAllPosts() {
        return postRepository.findAll();
    }
}