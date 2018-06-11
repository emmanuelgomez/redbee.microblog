package com.redbee.microblog.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "traveler", schema = "microblog")
public class TravelerEntity {
    private int idtraveler;
    private String name;
    private Collection<PostEntity> postsByIdtraveler;
    private Collection<PostTravelerMentionsEntity> postTravelerMentionsByIdtraveler;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idtraveler", nullable = false)
    public int getIdtraveler() {
        return idtraveler;
    }

    public void setIdtraveler(int idtraveler) {
        this.idtraveler = idtraveler;
    }

    @Basic
    @Column(name = "name", length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TravelerEntity that = (TravelerEntity) o;
        return idtraveler == that.idtraveler &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idtraveler, name);
    }

    @OneToMany(mappedBy = "travelerByTravelerOwnerIdtraveler", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public Collection<PostEntity> getPostsByIdtraveler() {
        return postsByIdtraveler;
    }

    public void setPostsByIdtraveler(Collection<PostEntity> postsByIdtraveler) {
        this.postsByIdtraveler = postsByIdtraveler;
    }

    @OneToMany(mappedBy = "travelerByTravelerIdtraveler")
    @JsonManagedReference
    public Collection<PostTravelerMentionsEntity> getPostTravelerMentionsByIdtraveler() {
        return postTravelerMentionsByIdtraveler;
    }

    public void setPostTravelerMentionsByIdtraveler(Collection<PostTravelerMentionsEntity> postTravelerMentionsByIdtraveler) {
        this.postTravelerMentionsByIdtraveler = postTravelerMentionsByIdtraveler;
    }
}
