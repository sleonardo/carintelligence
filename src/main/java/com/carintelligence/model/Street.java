package com.carintelligence.model;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "streets")
@NamedQueries({ @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s") })
public class Street {
    @Id
    @GeneratedValue
    private Long streetId;
    private String name;
    private Integer statusDefault;
    @ManyToOne
    @JoinColumn(name="user")
    private User user;

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

    public Integer getStatusDefault() {
        return statusDefault;
    }

    public void setStatusDefault(Integer statusDefault) {
        this.statusDefault = statusDefault;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
