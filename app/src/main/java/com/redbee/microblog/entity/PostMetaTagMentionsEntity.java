package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "post_meta_tag_mentions", schema = "microblog")
@IdClass(PostMetaTagMentionsEntityPK.class)
public class PostMetaTagMentionsEntity {
    private int postIdpost;
    private int metaTagIdmetaTag;
    private PostEntity postByPostIdpost;
    private MetaTagEntity metaTagByMetaTagIdmetaTag;

    @Id
    @Column(name = "post_idpost", nullable = false)
    public int getPostIdpost() {
        return postIdpost;
    }

    public void setPostIdpost(int postIdpost) {
        this.postIdpost = postIdpost;
    }

    @Id
    @Column(name = "meta_tag_idmeta_tag", nullable = false)
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
        PostMetaTagMentionsEntity that = (PostMetaTagMentionsEntity) o;
        return postIdpost == that.postIdpost &&
                metaTagIdmetaTag == that.metaTagIdmetaTag;
    }

    @Override
    public int hashCode() {

        return Objects.hash(postIdpost, metaTagIdmetaTag);
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
    @JoinColumn(name = "meta_tag_idmeta_tag", referencedColumnName = "idmeta_tag", nullable = false, insertable = false, updatable = false)
    public MetaTagEntity getMetaTagByMetaTagIdmetaTag() {
        return metaTagByMetaTagIdmetaTag;
    }

    public void setMetaTagByMetaTagIdmetaTag(MetaTagEntity metaTagByMetaTagIdmetaTag) {
        this.metaTagByMetaTagIdmetaTag = metaTagByMetaTagIdmetaTag;
    }
}
