package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "agent", schema = "microblog")
public class AgentEntity {
    private int idagent;
    private String name;
    private Collection<MetaTagEntity> metaTagsByIdagent;
    private Collection<PostEntity> postsByIdagent;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idagent", nullable = false)
    public int getIdagent() {
        return idagent;
    }

    public void setIdagent(int idagent) {
        this.idagent = idagent;
    }

    @Basic
    @Column(name = "name", length = 64)
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
        return idagent == that.idagent &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idagent, name);
    }

    @OneToMany(mappedBy = "agentByAgentModeratorIdagent")
    public Collection<MetaTagEntity> getMetaTagsByIdagent() {
        return metaTagsByIdagent;
    }

    public void setMetaTagsByIdagent(Collection<MetaTagEntity> metaTagsByIdagent) {
        this.metaTagsByIdagent = metaTagsByIdagent;
    }

    @OneToMany(mappedBy = "agentByAgentModeratorIdagent")
    public Collection<PostEntity> getPostsByIdagent() {
        return postsByIdagent;
    }

    public void setPostsByIdagent(Collection<PostEntity> postsByIdagent) {
        this.postsByIdagent = postsByIdagent;
    }
}
