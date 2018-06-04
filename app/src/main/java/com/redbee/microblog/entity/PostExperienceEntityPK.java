package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostExperienceEntityPK implements Serializable {
    private int postIdPost;
    private int experienceIdExperience;

    @Column(name = "Post_idPost")
    @Id
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Column(name = "Experience_idExperience")
    @Id
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
        PostExperienceEntityPK that = (PostExperienceEntityPK) o;
        return postIdPost == that.postIdPost &&
                experienceIdExperience == that.experienceIdExperience;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, experienceIdExperience);
    }
}
