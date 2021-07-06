package com.dynamaze.leisure.models.requests;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * Leisure Activity
 *
 */
public class LeisureActivityRequest {

    private int provideId;

    private String headline;

    private String description;

    private List<String> hints;

    private Date date;

    public int getProvideId() {
        return provideId;
    }

    public void setProvideId(int provideId) {
        this.provideId = provideId;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getHints() {
        return hints;
    }

    public void setHints(List<String> hints) {
        this.hints = hints;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
