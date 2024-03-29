package io.github.alanaafsc.persistence.dto;

import java.util.Date;

public class LatestArticlesDTO {

    public LatestArticlesDTO() {
    }

    public LatestArticlesDTO(String title, Date publicationDate) {
        this.title = title;
        this.publicationDate = publicationDate;
    }

    private String title;

    private java.util.Date publicationDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
}
