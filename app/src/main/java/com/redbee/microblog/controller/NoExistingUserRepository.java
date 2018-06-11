package com.redbee.microblog.controller;

import com.redbee.microblog.entity.NoExistingUserEntity;
import com.redbee.microblog.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoExistingUserRepository extends JpaRepository<NoExistingUserEntity, Integer> {

    NoExistingUserEntity findFirstByName(String name);
}

