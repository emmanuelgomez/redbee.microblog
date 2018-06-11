package com.redbee.microblog.controller;

import com.redbee.microblog.entity.TravelerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TravelerRepository extends CrudRepository<TravelerEntity, Integer> {

    TravelerEntity findFirstByName(String name);
}
