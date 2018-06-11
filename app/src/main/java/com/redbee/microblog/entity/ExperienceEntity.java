package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "experience", schema = "microblog")
public class ExperienceEntity {
    private int idexperience;
    private String text;
    private Collection<PostExperienceMentionsEntity> postExperienceMentionsByIdexperience;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idexperience", nullable = false)
    public int getIdexperience() {
        return idexperience;
    }

    public void setIdexperience(int idexperience) {
        this.idexperience = idexperience;
    }

    @Basic
    @Column(name = "text", length = 64)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceEntity that = (ExperienceEntity) o;
        return idexperience == that.idexperience &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idexperience, text);
    }

    @OneToMany(mappedBy = "experienceByExperienceIdexperience")
    public Collection<PostExperienceMentionsEntity> getPostExperienceMentionsByIdexperience() {
        return postExperienceMentionsByIdexperience;
    }

    public void setPostExperienceMentionsByIdexperience(Collection<PostExperienceMentionsEntity> postExperienceMentionsByIdexperience) {
        this.postExperienceMentionsByIdexperience = postExperienceMentionsByIdexperience;
    }
}
