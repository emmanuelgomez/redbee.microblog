package com.redbee.microblog.controller;

import com.redbee.microblog.entity.PostNoExistingUserMentionsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostNoExistingUserMentionsRepository extends JpaRepository<PostNoExistingUserMentionsEntity, Integer> {

  //  NoExistingUserEntity findFirstByName(String name);
}