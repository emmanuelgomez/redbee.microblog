package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Agent", schema = "microblog", catalog = "")
public class AgentEntity {
    private int idAgent;
    private String name;
    private Collection<MetaTagEntity> metaTagsByIdAgent;
    private Collection<PostEntity> postsByIdAgent;

    @Id
    @Column(name = "idAgent")
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentEntity that = (AgentEntity) o;
        return idAgent == that.idAgent &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idAgent, name);
    }

    @OneToMany(mappedBy = "agentByAgentIdAgent")
    public Collection<MetaTagEntity> getMetaTagsByIdAgent() {
        return metaTagsByIdAgent;
    }

    public void setMetaTagsByIdAgent(Collection<MetaTagEntity> metaTagsByIdAgent) {
        this.metaTagsByIdAgent = metaTagsByIdAgent;
    }

    @OneToMany(mappedBy = "agentByAgentIdAgent")
    public Collection<PostEntity> getPostsByIdAgent() {
        return postsByIdAgent;
    }

    public void setPostsByIdAgent(Collection<PostEntity> postsByIdAgent) {
        this.postsByIdAgent = postsByIdAgent;
    }
}
