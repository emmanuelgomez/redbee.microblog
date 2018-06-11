package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "meta_tag", schema = "microblog")
public class MetaTagEntity {
    private int idmetaTag;
    private String text;
    private String flag;
    private int agentModeratorIdagent;
    private AgentEntity agentByAgentModeratorIdagent;
    private Collection<PostMetaTagMentionsEntity> postMetaTagMentionsByIdmetaTag;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idmeta_tag", nullable = false)
    public int getIdmetaTag() {
        return idmetaTag;
    }

    public void setIdmetaTag(int idmetaTag) {
        this.idmetaTag = idmetaTag;
    }

    @Basic
    @Column(name = "text", length = 64)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "flag", length = 45)
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "agent_moderator_idagent", nullable = false)
    public int getAgentModeratorIdagent() {
        return agentModeratorIdagent;
    }

    public void setAgentModeratorIdagent(int agentModeratorIdagent) {
        this.agentModeratorIdagent = agentModeratorIdagent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetaTagEntity that = (MetaTagEntity) o;
        return idmetaTag == that.idmetaTag &&
                agentModeratorIdagent == that.agentModeratorIdagent &&
                Objects.equals(text, that.text) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idmetaTag, text, flag, agentModeratorIdagent);
    }

    @ManyToOne
    @JoinColumn(name = "agent_moderator_idagent", referencedColumnName = "idagent", nullable = false, insertable = false, updatable = false)
    public AgentEntity getAgentByAgentModeratorIdagent() {
        return agentByAgentModeratorIdagent;
    }

    public void setAgentByAgentModeratorIdagent(AgentEntity agentByAgentModeratorIdagent) {
        this.agentByAgentModeratorIdagent = agentByAgentModeratorIdagent;
    }

    @OneToMany(mappedBy = "metaTagByMetaTagIdmetaTag")
    public Collection<PostMetaTagMentionsEntity> getPostMetaTagMentionsByIdmetaTag() {
        return postMetaTagMentionsByIdmetaTag;
    }

    public void setPostMetaTagMentionsByIdmetaTag(Collection<PostMetaTagMentionsEntity> postMetaTagMentionsByIdmetaTag) {
        this.postMetaTagMentionsByIdmetaTag = postMetaTagMentionsByIdmetaTag;
    }
}
