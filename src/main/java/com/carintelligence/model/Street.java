package com.carintelligence.model;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "street")
public class Street {
    @Id
    @GeneratedValue
    private Long streetId;
    private String name;
    private boolean statusDefault;

    @ManyToOne
    private User userId;

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatusDefault() {
        return statusDefault;
    }

    public void setStatusDefault(boolean statusDefault) {
        this.statusDefault = statusDefault;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
