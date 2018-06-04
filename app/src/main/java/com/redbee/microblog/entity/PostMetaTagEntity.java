package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Post_Meta_Tag", schema = "microblog", catalog = "")
@IdClass(PostMetaTagEntityPK.class)
public class PostMetaTagEntity {
    private int postIdPost;
    private int metaTagIdMetaTag;
    private PostEntity postByPostIdPost;
    private MetaTagEntity metaTagByMetaTagIdMetaTag;

    @Id
    @Column(name = "Post_idPost")
    public int getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(int postIdPost) {
        this.postIdPost = postIdPost;
    }

    @Id
    @Column(name = "Meta_Tag_idMeta_Tag")
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
        PostMetaTagEntity that = (PostMetaTagEntity) o;
        return postIdPost == that.postIdPost &&
                metaTagIdMetaTag == that.metaTagIdMetaTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdPost, metaTagIdMetaTag);
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
    @JoinColumn(name = "Meta_Tag_idMeta_Tag", referencedColumnName = "idMeta_Tag", nullable = false, insertable = false, updatable = false)
    public MetaTagEntity getMetaTagByMetaTagIdMetaTag() {
        return metaTagByMetaTagIdMetaTag;
    }

    public void setMetaTagByMetaTagIdMetaTag(MetaTagEntity metaTagByMetaTagIdMetaTag) {
        this.metaTagByMetaTagIdMetaTag = metaTagByMetaTagIdMetaTag;
    }
}
