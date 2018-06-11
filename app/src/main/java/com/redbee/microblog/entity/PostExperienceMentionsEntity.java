package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_experience_mentions", schema = "microblog")
@IdClass(PostExperienceMentionsEntityPK.class)
public class PostExperienceMentionsEntity {
    private int postIdpost;
    private int experienceIdexperience;
    private PostEntity postByPostIdpost;
    private ExperienceEntity experienceByExperienceIdexperience;

    @Id
    @Column(name = "post_idpost", nullable = false)
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Id
    @Column(name = "experience_idexperience", nullable = false)
    public int getExperienceIdexperience() {
        return experienceIdexperience;
    }

    public void setExperienceIdexperience(int experienceIdexperience) {
        this.experienceIdexperience = experienceIdexperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostExperienceMentionsEntity that = (PostExperienceMentionsEntity) o;
        return postIdpost == that.postIdpost &&
                experienceIdexperience == that.experienceIdexperience;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, experienceIdexperience);
    }

    @ManyToOne
    @JoinColumn(name = "post_idpost", referencedColumnName = "idpost", nullable = false, insertable = false, updatable = false)
    public PostEntity getPostByPostIdpost() {
        return postByPostIdpost;
    }

    public void setPostByPostIdpost(PostEntity postByPostIdpost) {
        this.postByPostIdpost = postByPostIdpost;
    }

    @ManyToOne
    @JoinColumn(name = "experience_idexperience", referencedColumnName = "idexperience", nullable = false, insertable = false, updatable = false)
    public ExperienceEntity getExperienceByExperienceIdexperience() {
        return experienceByExperienceIdexperience;
    }

    public void setExperienceByExperienceIdexperience(ExperienceEntity experienceByExperienceIdexperience) {
        this.experienceByExperienceIdexperience = experienceByExperienceIdexperience;
    }
}
