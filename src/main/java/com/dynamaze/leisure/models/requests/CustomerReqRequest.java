package com.dynamaze.leisure.models.requests;

import java.util.Date;

/**
 * Customer Request.
 * When Customer request for a LeisureActivity
 */
public class CustomerReqRequest {
    private int leisureActivityId;

    private Date requestedDate;

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
}

