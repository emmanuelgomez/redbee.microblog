package com.redbee.microblog;

import com.redbee.microblog.entity.TravelerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
interface TravelerRepository extends CrudRepository<TravelerEntity, Integer> {

}


@RestController
public class TravelerController {

    @Autowired
    private TravelerRepository travelerRepository;

    @GetMapping("/traveler")
    public Iterable<TravelerEntity> retrieveAllTravelers() {
        return travelerRepository.findAll();
    }
}
