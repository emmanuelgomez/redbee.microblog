package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Post_No_Existing_User", schema = "microblog", catalog = "")
@IdClass(PostNoExistingUserEntityPK.class)
public class PostNoExistingUserEntity {
    private int postIdPost;
    private int noExistingUserIdnoExitingUser;
    private PostEntity postByPostIdPost;
    private NoExistingUserEntity noExistingUserByNoExistingUserIdnoExitingUser;

    @Id
    @Column(name = "Post_idPost")
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Id
    @Column(name = "No_Existing_User_idno_exiting_user")
    public int getNoExistingUserIdnoExitingUser() {
        return noExistingUserIdnoExitingUser;
    }

    public void setNoExistingUserIdnoExitingUser(int noExistingUserIdnoExitingUser) {
        this.noExistingUserIdnoExitingUser = noExistingUserIdnoExitingUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostNoExistingUserEntity that = (PostNoExistingUserEntity) o;
        return postIdPost == that.postIdPost &&
                noExistingUserIdnoExitingUser == that.noExistingUserIdnoExitingUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, noExistingUserIdnoExitingUser);
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
    @JoinColumn(name = "No_Existing_User_idno_exiting_user", referencedColumnName = "idno_exiting_user", nullable = false, insertable = false, updatable = false)
    public NoExistingUserEntity getNoExistingUserByNoExistingUserIdnoExitingUser() {
        return noExistingUserByNoExistingUserIdnoExitingUser;
    }

    public void setNoExistingUserByNoExistingUserIdnoExitingUser(NoExistingUserEntity noExistingUserByNoExistingUserIdnoExitingUser) {
        this.noExistingUserByNoExistingUserIdnoExitingUser = noExistingUserByNoExistingUserIdnoExitingUser;
    }
}
