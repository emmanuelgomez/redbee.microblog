package com.redbee.microblog.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Experience", schema = "microblog", catalog = "")
public class ExperienceEntity {
    private int idExperience;
    private String text;
    private Collection<PostExperienceEntity> postExperiencesByIdExperience;

    @Id
    @Column(name = "idExperience")
    public int getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    @Basic
    @Column(name = "Text")
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
        return idExperience == that.idExperience &&
                Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idExperience, text);
    }

    @OneToMany(mappedBy = "experienceByExperienceIdExperience")
    public Collection<PostExperienceEntity> getPostExperiencesByIdExperience() {
        return postExperiencesByIdExperience;
    }

    public void setPostExperiencesByIdExperience(Collection<PostExperienceEntity> postExperiencesByIdExperience) {
        this.postExperiencesByIdExperience = postExperiencesByIdExperience;
    }
}
