package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostTravelerEntityPK implements Serializable {
    private int postIdPost;
    private int travelerIdUser;

    @Column(name = "Post_idPost")
    @Id
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Column(name = "Traveler_idUser")
    @Id
    public int getTravelerIdUser() {
        return travelerIdUser;
    }

    public void setTravelerIdUser(int travelerIdUser) {
        this.travelerIdUser = travelerIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTravelerEntityPK that = (PostTravelerEntityPK) o;
        return postIdPost == that.postIdPost &&
                travelerIdUser == that.travelerIdUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, travelerIdUser);
    }
}
