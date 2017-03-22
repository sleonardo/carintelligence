package com.carintelligence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.math.BigDecimal;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "coordinates")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Coordinate extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long coordinateId;
    @Expose
    private Integer position;
    @Expose
    @Digits(integer=2, fraction=14)
    private BigDecimal latitude;
    @Expose
    @Digits(integer=2, fraction=14)
    private BigDecimal longitude;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="segment")
    @Expose
    private Segment segment;
    @ManyToOne
    @JoinColumn(name="coordinateType")
    @Expose
    private CoordinateType coordinateType;

    public Coordinate() {
    }

    public Coordinate(Integer position, BigDecimal latitude, BigDecimal longitude, Segment segment, CoordinateType coordinateType) {
        this.position = position;
        this.latitude = latitude;
        this.longitude = longitude;
        this.segment = segment;
        this.coordinateType = coordinateType;
    }

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

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
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
