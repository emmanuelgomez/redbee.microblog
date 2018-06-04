package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Meta_Tag", schema = "microblog", catalog = "")
public class MetaTagEntity {
    private int idMetaTag;
    private String text;
    private String flag;
    private int agentIdAgent;
    private AgentEntity agentByAgentIdAgent;
    private Collection<PostMetaTagEntity> postMetaTagsByIdMetaTag;

    @Id
    @Column(name = "idMeta_Tag")
    public int getIdMetaTag() {
        return idMetaTag;
    }

    public void setIdMetaTag(int idMetaTag) {
        this.idMetaTag = idMetaTag;
    }

    @Basic
    @Column(name = "Text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "Flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "Agent_idAgent")
    public int getAgentIdAgent() {
        return agentIdAgent;
    }

    public void setAgentIdAgent(int agentIdAgent) {
        this.agentIdAgent = agentIdAgent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaTagEntity that = (MetaTagEntity) o;
        return idMetaTag == that.idMetaTag &&
                agentIdAgent == that.agentIdAgent &&
                Objects.equals(text, that.text) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idMetaTag, text, flag, agentIdAgent);
    }

    @ManyToOne
    @JoinColumn(name = "Agent_idAgent", referencedColumnName = "idAgent", nullable = false, insertable = false, updatable = false)
    public AgentEntity getAgentByAgentIdAgent() {
        return agentByAgentIdAgent;
    }

    public void setAgentByAgentIdAgent(AgentEntity agentByAgentIdAgent) {
        this.agentByAgentIdAgent = agentByAgentIdAgent;
    }

    @OneToMany(mappedBy = "metaTagByMetaTagIdMetaTag")
    public Collection<PostMetaTagEntity> getPostMetaTagsByIdMetaTag() {
        return postMetaTagsByIdMetaTag;
    }

    public void setPostMetaTagsByIdMetaTag(Collection<PostMetaTagEntity> postMetaTagsByIdMetaTag) {
        this.postMetaTagsByIdMetaTag = postMetaTagsByIdMetaTag;
    }
}
