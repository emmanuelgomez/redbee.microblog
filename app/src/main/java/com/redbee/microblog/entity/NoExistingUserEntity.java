package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "no_existing_user", schema = "microblog")
public class NoExistingUserEntity {
    private int idnoExistingUser;
    private String name;
    private Collection<PostNoExistingUserMentionsEntity> postNoExistingUserMentionsByIdnoExistingUser;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idno_existing_user", nullable = false)
    public int getIdnoExistingUser() {
        return idnoExistingUser;
    }

    public void setIdnoExistingUser(int idnoExistingUser) {
        this.idnoExistingUser = idnoExistingUser;
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
        NoExistingUserEntity that = (NoExistingUserEntity) o;
        return idnoExistingUser == that.idnoExistingUser &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idnoExistingUser, name);
    }

    @OneToMany(mappedBy = "noExistingUserByNoExistingUserIdnoExistingUser")
    public Collection<PostNoExistingUserMentionsEntity> getPostNoExistingUserMentionsByIdnoExistingUser() {
        return postNoExistingUserMentionsByIdnoExistingUser;
    }

    public void setPostNoExistingUserMentionsByIdnoExistingUser(Collection<PostNoExistingUserMentionsEntity> postNoExistingUserMentionsByIdnoExistingUser) {
        this.postNoExistingUserMentionsByIdnoExistingUser = postNoExistingUserMentionsByIdnoExistingUser;
    }
}
