package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostExperienceMentionsEntityPK implements Serializable {
    private int postIdpost;
    private int experienceIdexperience;

    @Column(name = "post_idpost", nullable = false)
    @Id
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Column(name = "experience_idexperience", nullable = false)
    @Id
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
        PostExperienceMentionsEntityPK that = (PostExperienceMentionsEntityPK) o;
        return postIdpost == that.postIdpost &&
                experienceIdexperience == that.experienceIdexperience;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, experienceIdexperience);
    }
}
