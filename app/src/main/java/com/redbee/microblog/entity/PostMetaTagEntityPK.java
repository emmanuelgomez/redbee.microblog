package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostMetaTagEntityPK implements Serializable {
    private int postIdPost;
    private int metaTagIdMetaTag;

    @Column(name = "Post_idPost")
    @Id
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Column(name = "Meta_Tag_idMeta_Tag")
    @Id
    public int getMetaTagIdMetaTag() {
        return metaTagIdMetaTag;
    }

    public void setMetaTagIdMetaTag(int metaTagIdMetaTag) {
        this.metaTagIdMetaTag = metaTagIdMetaTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostMetaTagEntityPK that = (PostMetaTagEntityPK) o;
        return postIdPost == that.postIdPost &&
                metaTagIdMetaTag == that.metaTagIdMetaTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, metaTagIdMetaTag);
    }
}
