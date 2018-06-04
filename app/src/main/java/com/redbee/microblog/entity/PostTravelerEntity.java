package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Post_Traveler", schema = "microblog", catalog = "")
@IdClass(PostTravelerEntityPK.class)
public class PostTravelerEntity {
    private int postIdPost;
    private int travelerIdUser;
    private PostEntity postByPostIdPost;
    private TravelerEntity travelerByTravelerIdUser;

    @Id
    @Column(name = "Post_idPost")
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Id
    @Column(name = "Traveler_idUser")
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
        PostTravelerEntity that = (PostTravelerEntity) o;
        return postIdPost == that.postIdPost &&
                travelerIdUser == that.travelerIdUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, travelerIdUser);
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
    @JoinColumn(name = "Traveler_idUser", referencedColumnName = "idUser", nullable = false, insertable = false, updatable = false)
    public TravelerEntity getTravelerByTravelerIdUser() {
        return travelerByTravelerIdUser;
    }

    public void setTravelerByTravelerIdUser(TravelerEntity travelerByTravelerIdUser) {
        this.travelerByTravelerIdUser = travelerByTravelerIdUser;
    }
}
