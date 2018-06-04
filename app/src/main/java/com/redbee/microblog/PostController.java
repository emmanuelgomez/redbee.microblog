package com.redbee.microblog;

import com.redbee.microblog.entity.PostEntity;
import com.redbee.microblog.entity.TravelerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
interface PostRepository extends CrudRepository<PostEntity, Integer> {

}


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/post")
    public Iterable<PostEntity> retrieveAllPosts() {
        return postRepository.findAll();
    }
}