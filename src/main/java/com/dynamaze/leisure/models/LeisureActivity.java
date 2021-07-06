package com.dynamaze.leisure.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Leisure Activity
 *
 */
public class LeisureActivity {
    private int id;

    private int provideId;

    private String providerName;

    private String providerAddress;

    private String providerWebsite;

    private String headline;

    private String description;

    private List<String> hints = new ArrayList<>();

    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvideId() {
        return provideId;
    }

    public void setProvideId(int provideId) {
        this.provideId = provideId;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
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

    public String getProviderWebsite() {
        return providerWebsite;
    }

    public void setProviderWebsite(String providerWebsite) {
        this.providerWebsite = providerWebsite;
    }
}
