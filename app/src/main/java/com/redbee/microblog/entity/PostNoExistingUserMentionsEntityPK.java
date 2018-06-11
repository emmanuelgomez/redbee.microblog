package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostNoExistingUserMentionsEntityPK implements Serializable {
    private int postIdpost;
    private int noExistingUserIdnoExistingUser;

    @Column(name = "post_idpost", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Column(name = "no_existing_user_idno_existing_user", nullable = false)
    @Id
    public int getNoExistingUserIdnoExistingUser() {
        return noExistingUserIdnoExistingUser;
    }

    public void setNoExistingUserIdnoExistingUser(int noExistingUserIdnoExistingUser) {
        this.noExistingUserIdnoExistingUser = noExistingUserIdnoExistingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostNoExistingUserMentionsEntityPK that = (PostNoExistingUserMentionsEntityPK) o;
        return postIdpost == that.postIdpost &&
                noExistingUserIdnoExistingUser == that.noExistingUserIdnoExistingUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, noExistingUserIdnoExistingUser);
    }
}
