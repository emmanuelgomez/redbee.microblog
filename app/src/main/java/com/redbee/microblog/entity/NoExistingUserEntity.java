package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "No_Existing_User", schema = "microblog", catalog = "")
public class NoExistingUserEntity {
    private int idnoExitingUser;
    private String name;
    private Collection<PostNoExistingUserEntity> postNoExistingUsersByIdnoExitingUser;

    @Id
    @Column(name = "idno_exiting_user")
    public int getIdnoExitingUser() {
        return idnoExitingUser;
    }

    public void setIdnoExitingUser(int idnoExitingUser) {
        this.idnoExitingUser = idnoExitingUser;
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
        NoExistingUserEntity that = (NoExistingUserEntity) o;
        return idnoExitingUser == that.idnoExitingUser &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idnoExitingUser, name);
    }

    @OneToMany(mappedBy = "noExistingUserByNoExistingUserIdnoExitingUser")
    public Collection<PostNoExistingUserEntity> getPostNoExistingUsersByIdnoExitingUser() {
        return postNoExistingUsersByIdnoExitingUser;
    }

    public void setPostNoExistingUsersByIdnoExitingUser(Collection<PostNoExistingUserEntity> postNoExistingUsersByIdnoExitingUser) {
        this.postNoExistingUsersByIdnoExitingUser = postNoExistingUsersByIdnoExitingUser;
    }
}
