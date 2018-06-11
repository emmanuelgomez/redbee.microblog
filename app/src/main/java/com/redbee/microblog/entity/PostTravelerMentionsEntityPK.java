package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostTravelerMentionsEntityPK implements Serializable {
    private int postIdpost;
    private int travelerIdtraveler;

    @Column(name = "post_idpost", nullable = false)
    @Id
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Column(name = "traveler_idtraveler", nullable = false)
    @Id
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
        PostTravelerMentionsEntityPK that = (PostTravelerMentionsEntityPK) o;
        return postIdpost == that.postIdpost &&
                travelerIdtraveler == that.travelerIdtraveler;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, travelerIdtraveler);
    }
}
