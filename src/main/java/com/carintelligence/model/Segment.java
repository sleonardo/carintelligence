package com.carintelligence.model;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "segments")
public class Segment extends AppEntities {
    @Id
    @GeneratedValue
    private Long segmentId;
    private String name;
    private Integer sense;
    @ManyToOne
    @JoinColumn(name="street")
    private Street street;

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
}
