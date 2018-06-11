package com.redbee.microblog.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PostMetaTagMentionsEntityPK implements Serializable {
    private int postIdpost;
    private int metaTagIdmetaTag;

    @Column(name = "post_idpost", nullable = false)
    @Id
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Column(name = "meta_tag_idmeta_tag", nullable = false)
    @Id
    public int getMetaTagIdmetaTag() {
        return metaTagIdmetaTag;
    }

    public void setMetaTagIdmetaTag(int metaTagIdmetaTag) {
        this.metaTagIdmetaTag = metaTagIdmetaTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostMetaTagMentionsEntityPK that = (PostMetaTagMentionsEntityPK) o;
        return postIdpost == that.postIdpost &&
                metaTagIdmetaTag == that.metaTagIdmetaTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, metaTagIdmetaTag);
    }
}
