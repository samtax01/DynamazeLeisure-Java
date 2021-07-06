package com.dynamaze.leisure.models;

import java.util.Date;

/**
 * Customer Request.
 * When Customer request for a LeisureActivity
 */
public class CustomerRequest {
    private int id;

    private int leisureActivityId;

    private LeisureActivity leisureActivity;

    private Date requestedDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getLeisureActivityId() {
        return leisureActivityId;
    }

    public void setLeisureActivityId(int leisureActivityId) {
        this.leisureActivityId = leisureActivityId;
    }

    public Date getRequestedDate() {
        return requestedDate;
    }

    public void setRequestedDate(Date requestedDate) {
        this.requestedDate = requestedDate;
    }

    public LeisureActivity getLeisureActivity() {
        return leisureActivity;
    }

    public void setLeisureActivity(LeisureActivity leisureActivity) {
        this.leisureActivity = leisureActivity;
    }
}

