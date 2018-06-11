package com.redbee.microblog.controller;

import com.redbee.microblog.entity.PostTravelerMentionsEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostTravelerMentionsRepository extends CrudRepository<PostTravelerMentionsEntity, Integer> {

}
