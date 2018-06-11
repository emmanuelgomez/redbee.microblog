package com.redbee.microblog.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_traveler_mentions", schema = "microblog")
@IdClass(PostTravelerMentionsEntityPK.class)
public class PostTravelerMentionsEntity {
    private int postIdpost;
    private int travelerIdtraveler;
    private PostEntity postByPostIdpost;
    private TravelerEntity travelerByTravelerIdtraveler;

    @Id
    @Column(name = "post_idpost", nullable = false)
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Id
    @Column(name = "traveler_idtraveler", nullable = false)
    public int getTravelerIdtraveler() {
        return travelerIdtraveler;
    }

    public void setTravelerIdtraveler(int travelerIdtraveler) {
        this.travelerIdtraveler = travelerIdtraveler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostTravelerMentionsEntity that = (PostTravelerMentionsEntity) o;
        return postIdpost == that.postIdpost &&
                travelerIdtraveler == that.travelerIdtraveler;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, travelerIdtraveler);
    }

    @ManyToOne
    @JoinColumn(name = "post_idpost", referencedColumnName = "idpost", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public PostEntity getPostByPostIdpost() {
        return postByPostIdpost;
    }

    public void setPostByPostIdpost(PostEntity postByPostIdpost) {
        this.postByPostIdpost = postByPostIdpost;
    }

    @ManyToOne
    @JoinColumn(name = "traveler_idtraveler", referencedColumnName = "idtraveler", nullable = false, insertable = false, updatable = false)
    @JsonBackReference
    public TravelerEntity getTravelerByTravelerIdtraveler() {
        return travelerByTravelerIdtraveler;
    }

    public void setTravelerByTravelerIdtraveler(TravelerEntity travelerByTravelerIdtraveler) {
        this.travelerByTravelerIdtraveler = travelerByTravelerIdtraveler;
    }
}
