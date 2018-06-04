package com.redbee.microblog;

import com.redbee.microblog.entity.AgentEntity;
import com.redbee.microblog.entity.PostEntity;
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
    private AgentRepository agentRepository;

    @RequestMapping("/")
    public String home() {
        TravelerEntity p = this.repository.findAll().iterator().next();
        return "Hello plus mas " + p.getName() + "!";
    }

    @RequestMapping("/filldb")
    public String fillDB() {
        try {
            TravelerEntity t1=new TravelerEntity();
            t1.setIdUser(1);
            t1.setName("test");
            this.repository.save(t1);
        }
        catch (Exception ex){
            return "Traveler error"+ex.getMessage();
        }
        try {
            AgentEntity agentEntity = new AgentEntity();
            agentEntity.setName("agentSmith");
            this.agentRepository.save(agentEntity);
        }
        catch (Exception ex){
            return "Agent Error"+ex.getMessage();
    }
        try {
            PostEntity postEntity =new PostEntity();
            postEntity.setText("@newuser #some $dolar");
            postEntity.setFlag("waiting");
            this.postRepository.save(postEntity);
            postEntity.setTravelerIdUser(1);
            this.postRepository.save(postEntity);
}
        catch (Exception ex){
            return "Post error"+ex.getMessage();
                }
        return "Database filled";
    }
    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class, args);
    }
}

@Repository
interface TravelRepository extends CrudRepository<Travel, Long> {

}

@Entity
class Travel {
    @Id
    @GeneratedValue
    private String Name;

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    @Override
    public String toString() {
        return "Person [firstName=" + this.Name + "]";
    }
    

}

