package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Post", schema = "microblog", catalog = "")
public class PostEntity {
    private int idPost;
    private String text;
    private int travelerIdUser;
    private int agentIdAgent;
    private String flag;
    private TravelerEntity travelerByTravelerIdUser;
    private AgentEntity agentByAgentIdAgent;
    private Collection<PostExperienceEntity> postExperiencesByIdPost;
    private Collection<PostMetaTagEntity> postMetaTagsByIdPost;
    private Collection<PostNoExistingUserEntity> postNoExistingUsersByIdPost;
    private Collection<PostTravelerEntity> postTravelersByIdPost;

    @Id
    @Column(name = "idPost")
    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
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
    @Column(name = "Traveler_idUser")
    public int getTravelerIdUser() {
        return travelerIdUser;
    }

    public void setTravelerIdUser(int travelerIdUser) {
        this.travelerIdUser = travelerIdUser;
    }

    @Basic
    @Column(name = "Agent_idAgent")
    public int getAgentIdAgent() {
        return agentIdAgent;
    }

    public void setAgentIdAgent(int agentIdAgent) {
        this.agentIdAgent = agentIdAgent;
    }

    @Basic
    @Column(name = "Flag")
    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return idPost == that.idPost &&
                travelerIdUser == that.travelerIdUser &&
                agentIdAgent == that.agentIdAgent &&
                Objects.equals(text, that.text) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idPost, text, travelerIdUser, agentIdAgent, flag);
    }

    @ManyToOne
    @JoinColumn(name = "Traveler_idUser", referencedColumnName = "idUser", nullable = false, insertable = false, updatable = false)
    public TravelerEntity getTravelerByTravelerIdUser() {
        return travelerByTravelerIdUser;
    }

    public void setTravelerByTravelerIdUser(TravelerEntity travelerByTravelerIdUser) {
        this.travelerByTravelerIdUser = travelerByTravelerIdUser;
    }

    @ManyToOne
    @JoinColumn(name = "Agent_idAgent", referencedColumnName = "idAgent", nullable = false, insertable = false, updatable = false)
    public AgentEntity getAgentByAgentIdAgent() {
        return agentByAgentIdAgent;
    }

    public void setAgentByAgentIdAgent(AgentEntity agentByAgentIdAgent) {
        this.agentByAgentIdAgent = agentByAgentIdAgent;
    }

    @OneToMany(mappedBy = "postByPostIdPost")
    public Collection<PostExperienceEntity> getPostExperiencesByIdPost() {
        return postExperiencesByIdPost;
    }

    public void setPostExperiencesByIdPost(Collection<PostExperienceEntity> postExperiencesByIdPost) {
        this.postExperiencesByIdPost = postExperiencesByIdPost;
    }

    @OneToMany(mappedBy = "postByPostIdPost")
    public Collection<PostMetaTagEntity> getPostMetaTagsByIdPost() {
        return postMetaTagsByIdPost;
    }

    public void setPostMetaTagsByIdPost(Collection<PostMetaTagEntity> postMetaTagsByIdPost) {
        this.postMetaTagsByIdPost = postMetaTagsByIdPost;
    }

    @OneToMany(mappedBy = "postByPostIdPost")
    public Collection<PostNoExistingUserEntity> getPostNoExistingUsersByIdPost() {
        return postNoExistingUsersByIdPost;
    }

    public void setPostNoExistingUsersByIdPost(Collection<PostNoExistingUserEntity> postNoExistingUsersByIdPost) {
        this.postNoExistingUsersByIdPost = postNoExistingUsersByIdPost;
    }

    @OneToMany(mappedBy = "postByPostIdPost")
    public Collection<PostTravelerEntity> getPostTravelersByIdPost() {
        return postTravelersByIdPost;
    }

    public void setPostTravelersByIdPost(Collection<PostTravelerEntity> postTravelersByIdPost) {
        this.postTravelersByIdPost = postTravelersByIdPost;
    }
}
