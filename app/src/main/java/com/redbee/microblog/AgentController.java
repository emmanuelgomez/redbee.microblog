package com.redbee.microblog;

import com.redbee.microblog.entity.AgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
interface AgentRepository extends CrudRepository<AgentEntity, Integer> {

}


@RestController
public class AgentController {

    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/agent")
    public Iterable<AgentEntity> retrieveAllAgents() {
        return agentRepository.findAll();
    }
}