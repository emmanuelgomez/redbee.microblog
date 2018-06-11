package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_no_existing_user_mentions", schema = "microblog")
@IdClass(PostNoExistingUserMentionsEntityPK.class)
public class PostNoExistingUserMentionsEntity {
    private int postIdpost;
    private int noExistingUserIdnoExistingUser;
    private PostEntity postByPostIdpost;
    private NoExistingUserEntity noExistingUserByNoExistingUserIdnoExistingUser;

    @Id
    @Column(name = "post_idpost", nullable = false)
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Id
    @Column(name = "no_existing_user_idno_existing_user", nullable = false)
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
        PostNoExistingUserMentionsEntity that = (PostNoExistingUserMentionsEntity) o;
        return postIdpost == that.postIdpost &&
                noExistingUserIdnoExistingUser == that.noExistingUserIdnoExistingUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, noExistingUserIdnoExistingUser);
    }

    @ManyToOne
    @JoinColumn(name = "post_idpost", referencedColumnName = "idpost", nullable = false, insertable = false, updatable = false)
    public PostEntity getPostByPostIdpost() {
        return postByPostIdpost;
    }

    public void setPostByPostIdpost(PostEntity postByPostIdpost) {
        this.postByPostIdpost = postByPostIdpost;
    }

    @ManyToOne
    @JoinColumn(name = "no_existing_user_idno_existing_user", referencedColumnName = "idno_existing_user", nullable = false, insertable = false, updatable = false)
    public NoExistingUserEntity getNoExistingUserByNoExistingUserIdnoExistingUser() {
        return noExistingUserByNoExistingUserIdnoExistingUser;
    }

    public void setNoExistingUserByNoExistingUserIdnoExistingUser(NoExistingUserEntity noExistingUserByNoExistingUserIdnoExistingUser) {
        this.noExistingUserByNoExistingUserIdnoExistingUser = noExistingUserByNoExistingUserIdnoExistingUser;
    }
}
