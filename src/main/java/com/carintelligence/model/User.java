package com.carintelligence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;

/**
 * @author leonardo
 * @project carintelligence
 * @date 09/3/17
 */

@XmlRootElement
@Entity
@Table(name = "users")
//@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") })
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long userId;
    @Expose
    private String name;
    @Expose
    private String email;
/*
    @ElementCollection
    @OneToMany(fetch = FetchType.LAZY, mappedBy="assignee")
    private Set<Task> tasks;

    @ElementCollection
    @OneToMany(fetch = FetchType.LAZY, mappedBy="owner")
    private Set<Project> owningProject;*/

    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User EntityfromJson(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, User.class);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
