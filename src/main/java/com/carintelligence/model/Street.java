package com.carintelligence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Set;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "streets")
@NamedQueries({ @NamedQuery(name = "Street.findAll", query = "SELECT s FROM Street s") })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Street extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long streetId;
    @Expose
    private String name;
    @Expose
    private Integer statusDefault;
    @ManyToOne
    @JoinColumn(name="user")
    @Expose
    private User user;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="street", orphanRemoval = true)
    @Expose
    private Set<Segment> segments;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="street", orphanRemoval = true)
    @Expose
    private Set<Rule> rules;

    public Street() {
    }

    public Street(Long streetId) {
        this.streetId = streetId;
    }

    public Street(String name, Integer statusDefault, User user, Set<Segment> segments, Set<Rule> rules) {
        this.name = name;
        this.statusDefault = statusDefault;
        this.user = user;
        this.segments = segments;
        this.rules = rules;
    }

    public Street EntityfromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Street.class);
    }

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

    public Set<Segment> getSegments() {
        return segments;
    }

    public void setSegments(Set<Segment> segments) {
        this.segments = segments;
    }

    public Set<Rule> getRules() {
        return rules;
    }

    public void setRules(Set<Rule> rules) {
        this.rules = rules;
    }
}
