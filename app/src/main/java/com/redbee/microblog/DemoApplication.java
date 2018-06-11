package com.redbee.microblog;

import com.redbee.microblog.controller.PostRepository;
import com.redbee.microblog.controller.PostTravelerMentionsRepository;
import com.redbee.microblog.controller.TravelerRepository;
import com.redbee.microblog.entity.PostEntity;
import com.redbee.microblog.entity.PostTravelerMentionsEntity;
import com.redbee.microblog.entity.TravelerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SpringBootApplication
@RestController
public class DemoApplication {
    @Autowired
    private TravelerRepository repository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostTravelerMentionsRepository postTravelerMentionsRepository;

    /*@RequestMapping("/")
    public String home() {
        //TravelerEntity p = this.repository.findAll().iterator().next();
        return swagger-ui.html;
    }*/

    @RequestMapping("/filldb")
    public String fillDB() {
        TravelerEntity travelerEntity = new TravelerEntity();
        travelerEntity.setName("Paolo");
        repository.save(travelerEntity);
        TravelerEntity travelerMention = new TravelerEntity();
        travelerMention.setName("Jose");
        repository.save(travelerMention);
        TravelerEntity travelerMention2 = new TravelerEntity();
        travelerMention2.setName("Juan");
        repository.save(travelerMention2);
        PostEntity postEntity = new PostEntity();
        postEntity.setText("Hola Mundo");
        postEntity.setFlagWaiting();
        postEntity.setTravelerByTravelerOwnerIdtraveler(travelerEntity);

        postRepository.save(postEntity);
        PostTravelerMentionsEntity postTravelerMentionsEntity = new PostTravelerMentionsEntity();
        postTravelerMentionsEntity.setPostIdpost(postEntity.getIdpost());
        postTravelerMentionsEntity.setTravelerIdtraveler(travelerMention.getIdtraveler());
        postTravelerMentionsRepository.save(postTravelerMentionsEntity);
        PostTravelerMentionsEntity postTravelerMentionsEntity1 = new PostTravelerMentionsEntity();
        postTravelerMentionsEntity1.setPostIdpost(postEntity.getIdpost());
        postTravelerMentionsEntity1.setTravelerIdtraveler(travelerMention2.getIdtraveler());
        postTravelerMentionsRepository.save(postTravelerMentionsEntity1);
        return "Database filled";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}




