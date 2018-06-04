package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Traveler", schema = "microblog", catalog = "")
public class TravelerEntity {
    private int idUser;
    private String name;
    private Collection<PostEntity> postsByIdUser;
    private Collection<PostTravelerEntity> postTravelersByIdUser;

    @Id
    @Column(name = "idUser")
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "Name")
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
        return idUser == that.idUser &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idUser, name);
    }

    @OneToMany(mappedBy = "travelerByTravelerIdUser")
    public Collection<PostEntity> getPostsByIdUser() {
        return postsByIdUser;
    }

    public void setPostsByIdUser(Collection<PostEntity> postsByIdUser) {
        this.postsByIdUser = postsByIdUser;
    }

    @OneToMany(mappedBy = "travelerByTravelerIdUser")
    public Collection<PostTravelerEntity> getPostTravelersByIdUser() {
        return postTravelersByIdUser;
    }

    public void setPostTravelersByIdUser(Collection<PostTravelerEntity> postTravelersByIdUser) {
        this.postTravelersByIdUser = postTravelersByIdUser;
    }
}
