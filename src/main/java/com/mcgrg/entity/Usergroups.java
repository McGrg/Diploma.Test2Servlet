package com.mcgrg.entity;

/**
 * Created by MSI GT70 on 17.02.2017.
 */
public class Usergroups {
    public int getUsergroupId() {
        return usergroupId;
    }

    public void setUsergroupId(int usergroupId) {
        this.usergroupId = usergroupId;
    }

    public String getUsergroupName() {
        return usergroupName;
    }

    public void setUsergroupName(String usergroupName) {
        this.usergroupName = usergroupName;
    }

    private int usergroupId;
    private String usergroupName;
}
