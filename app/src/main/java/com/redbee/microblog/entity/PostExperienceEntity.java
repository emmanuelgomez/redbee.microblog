package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Post_Experience", schema = "microblog", catalog = "")
@IdClass(PostExperienceEntityPK.class)
public class PostExperienceEntity {
    private int postIdPost;
    private int experienceIdExperience;
    private PostEntity postByPostIdPost;
    private ExperienceEntity experienceByExperienceIdExperience;

    @Id
    @Column(name = "Post_idPost")
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Id
    @Column(name = "Experience_idExperience")
    public int getExperienceIdExperience() {
        return experienceIdExperience;
    }

    public void setExperienceIdExperience(int experienceIdExperience) {
        this.experienceIdExperience = experienceIdExperience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostExperienceEntity that = (PostExperienceEntity) o;
        return postIdPost == that.postIdPost &&
                experienceIdExperience == that.experienceIdExperience;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, experienceIdExperience);
    }

    @ManyToOne
    @JoinColumn(name = "Post_idPost", referencedColumnName = "idPost", nullable = false, insertable = false, updatable = false)
    public PostEntity getPostByPostIdPost() {
        return postByPostIdPost;
    }

    public void setPostByPostIdPost(PostEntity postByPostIdPost) {
        this.postByPostIdPost = postByPostIdPost;
    }

    @ManyToOne
    @JoinColumn(name = "Experience_idExperience", referencedColumnName = "idExperience", nullable = false, insertable = false, updatable = false)
    public ExperienceEntity getExperienceByExperienceIdExperience() {
        return experienceByExperienceIdExperience;
    }

    public void setExperienceByExperienceIdExperience(ExperienceEntity experienceByExperienceIdExperience) {
        this.experienceByExperienceIdExperience = experienceByExperienceIdExperience;
    }
}
