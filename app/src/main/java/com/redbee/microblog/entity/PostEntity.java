package com.redbee.microblog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

enum PostFlag{waiting,appropriate,inappropriate}

@Entity
@Table(name = "post", schema = "microblog")
public class PostEntity {
    private int idpost;
    private String text;
    private PostFlag flag;
   // private int travelerOwnerIdtraveler;
   // private int agentModeratorIdagent;
    private TravelerEntity travelerByTravelerOwnerIdtraveler;
    private AgentEntity agentByAgentModeratorIdagent;
    private Collection<PostExperienceMentionsEntity> postExperienceMentionsByIdpost;
    private Collection<PostMetaTagMentionsEntity> postMetaTagMentionsByIdpost;
    private Collection<PostNoExistingUserMentionsEntity> postNoExistingUserMentionsByIdpost;
    private Collection<PostTravelerMentionsEntity> postTravelerMentionsByIdpost;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idpost", nullable = false)
    @ApiModelProperty(notes = "The database generated post ID")
    public int getIdpost() {
        return idpost;
    }

    public void setIdpost(int idpost) {
        this.idpost = idpost;
    }

    @Basic
    @Column(name = "text", length = 1024)
    @ApiModelProperty(notes = "Content of the post")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "flag", length = 50)
    @ApiModelProperty(notes = "Agents most flag post as appropiate or innapropiate. By default is set to waiting")
    public PostFlag getFlag() {
        return flag;
    }

    public void setFlag(PostFlag flag) {
        this.flag = flag;
    }

   /* @Basic
    @Column(name = "traveler_owner_idtraveler")
    public int getTravelerOwnerIdtraveler() {
        return travelerOwnerIdtraveler;
    }

    public void setTravelerOwnerIdtraveler(int travelerOwnerIdtraveler) {
        this.travelerOwnerIdtraveler = travelerOwnerIdtraveler;
    }

    @Basic
    @Column(name = "agent_moderator_idagent")
    public int getAgentModeratorIdagent() {
        return agentModeratorIdagent;
    }

    public void setAgentModeratorIdagent(int agentModeratorIdagent) {
        this.agentModeratorIdagent = agentModeratorIdagent;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostEntity that = (PostEntity) o;
        return idpost == that.idpost &&
                //travelerOwnerIdtraveler == that.travelerOwnerIdtraveler &&
                //agentModeratorIdagent == that.agentModeratorIdagent &&
                Objects.equals(text, that.text) &&
                Objects.equals(flag, that.flag);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idpost, text, flag
               // , travelerOwnerIdtraveler, agentModeratorIdagent
        );
    }

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "traveler_owner_idtraveler", referencedColumnName = "idtraveler")
    public TravelerEntity getTravelerByTravelerOwnerIdtraveler() {
        return travelerByTravelerOwnerIdtraveler;
    }

    public void setTravelerByTravelerOwnerIdtraveler(TravelerEntity travelerByTravelerOwnerIdtraveler) {
        this.travelerByTravelerOwnerIdtraveler = travelerByTravelerOwnerIdtraveler;
    }

    @ManyToOne
    @JoinColumn(name = "agent_moderator_idagent", referencedColumnName = "idagent")
    @JsonBackReference
    public AgentEntity getAgentByAgentModeratorIdagent() {
        return agentByAgentModeratorIdagent;
    }

    public void setAgentByAgentModeratorIdagent(AgentEntity agentByAgentModeratorIdagent) {
        this.agentByAgentModeratorIdagent = agentByAgentModeratorIdagent;
    }

    @OneToMany(mappedBy = "postByPostIdpost")
    @ApiModelProperty(notes = "Travelers can hashtag experiences in their posts.")
    @JsonManagedReference
    public Collection<PostExperienceMentionsEntity> getPostExperienceMentionsByIdpost() {
        return postExperienceMentionsByIdpost;
    }

    public void setPostExperienceMentionsByIdpost(Collection<PostExperienceMentionsEntity> postExperienceMentionsByIdpost) {
        this.postExperienceMentionsByIdpost = postExperienceMentionsByIdpost;
    }

    @OneToMany(mappedBy = "postByPostIdpost")
    @ApiModelProperty(notes = "Travelers can hashtag metatags en their posts")
    @JsonManagedReference
    public Collection<PostMetaTagMentionsEntity> getPostMetaTagMentionsByIdpost() {
        return postMetaTagMentionsByIdpost;
    }

    public void setPostMetaTagMentionsByIdpost(Collection<PostMetaTagMentionsEntity> postMetaTagMentionsByIdpost) {
        this.postMetaTagMentionsByIdpost = postMetaTagMentionsByIdpost;
    }

    @OneToMany(mappedBy = "postByPostIdpost")
    @ApiModelProperty(notes = "Travelers can mentions non existing users.")
    @JsonManagedReference
    public Collection<PostNoExistingUserMentionsEntity> getPostNoExistingUserMentionsByIdpost() {
        return postNoExistingUserMentionsByIdpost;
    }

    public void setPostNoExistingUserMentionsByIdpost(Collection<PostNoExistingUserMentionsEntity> postNoExistingUserMentionsByIdpost) {
        this.postNoExistingUserMentionsByIdpost = postNoExistingUserMentionsByIdpost;
    }

    @OneToMany(mappedBy = "postByPostIdpost")
    @JsonManagedReference
    @ApiModelProperty(notes = "Travelers can mentions existing users.")
    public Collection<PostTravelerMentionsEntity> getPostTravelerMentionsByIdpost() {
        return postTravelerMentionsByIdpost;
    }

    public void setPostTravelerMentionsByIdpost(Collection<PostTravelerMentionsEntity> postTravelerMentionsByIdpost) {
        this.postTravelerMentionsByIdpost = postTravelerMentionsByIdpost;
    }

    public void setFlagWaiting(){
        this.flag = PostFlag.waiting;
    }

    public void setFlagAppropriate(){
        this.flag = PostFlag.appropriate;
    }

    public void setFlagInappropriate(){
        this.flag = PostFlag.inappropriate;
    }
}
