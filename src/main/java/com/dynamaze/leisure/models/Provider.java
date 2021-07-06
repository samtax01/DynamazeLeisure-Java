package com.dynamaze.leisure.models;

import java.util.HashMap;
import java.util.Map;

/**
 * Activity provider
 */
public class Provider {
    private int id;
    private String name;
    private String address;
    private final Map<Integer, LeisureActivity> leisureActivities = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Integer, LeisureActivity> getLeisureActivities(){
        return leisureActivities;
    }

    public void addLeisureActivity(LeisureActivity activity){
        leisureActivities.put(activity.getId(), activity);
    }

    public void removeLeisureActivity(int id){
        leisureActivities.remove(id);
    }


}
