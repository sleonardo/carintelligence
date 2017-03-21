package com.carintelligence.model;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "coordinates")
public class Coordinate extends AppEntities {
    @Id
    @GeneratedValue
    private Long coordinateId;
    private Integer position;
    private Float latitude;
    private Float longitude;
    @ManyToOne
    @JoinColumn(name="segment")
    private Segment segment;
    @ManyToOne
    @JoinColumn(name="coordinateType")
    private CoordinateType coordinateType;

    public Long getCoordinateId() {
        return coordinateId;
    }

    public void setCoordinateId(Long coordinateId) {
        this.coordinateId = coordinateId;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Segment getSegment() {
        return segment;
    }

    public void setSegment(Segment segment) {
        this.segment = segment;
    }

    public CoordinateType getCoordinateType() {
        return coordinateType;
    }

    public void setCoordinateType(CoordinateType coordinateType) {
        this.coordinateType = coordinateType;
    }
}
