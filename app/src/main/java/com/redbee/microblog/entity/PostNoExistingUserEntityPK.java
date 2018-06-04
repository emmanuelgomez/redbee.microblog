package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostNoExistingUserEntityPK implements Serializable {
    private int postIdPost;
    private int noExistingUserIdnoExitingUser;

    @Column(name = "Post_idPost")
    @Id
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Column(name = "No_Existing_User_idno_exiting_user")
    @Id
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
        PostNoExistingUserEntityPK that = (PostNoExistingUserEntityPK) o;
        return postIdPost == that.postIdPost &&
                noExistingUserIdnoExitingUser == that.noExistingUserIdnoExitingUser;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, noExistingUserIdnoExitingUser);
    }
}
