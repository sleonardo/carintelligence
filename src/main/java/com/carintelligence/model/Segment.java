package com.carintelligence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Set;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "segments")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Segment extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long segmentId;
    @Expose
    private String name;
    @Expose
    private Integer sense;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="street")
    private Street street;

    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy="segment", orphanRemoval = true)
    @Expose
    private Set<Coordinate> coordinates;

    public Segment() {
    }

    public Segment(Long segmentId) {
        this.segmentId = segmentId;
    }

    public Segment(String name, Integer sense, Street street, Set<Coordinate> coordinates) {
        this.name = name;
        this.sense = sense;
        this.street = street;
        this.coordinates = coordinates;
    }

    public Long getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(Long segmentId) {
        this.segmentId = segmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSense() {
        return sense;
    }

    public void setSense(Integer sense) {
        this.sense = sense;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public Set<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Set<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }
}
