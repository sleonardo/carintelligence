package com.carintelligence.model;

import javax.persistence.*;
import java.util.Set;

/**
 * @author leonardo
 * @project carintelligence
 * @date 17/3/17
 */

@Entity
@Table(name = "coordinate_type")
public class CoordinateType {
    @Id
    @GeneratedValue
    private Long coordinateTypeId;
    private String name;
    private String description;

    @ElementCollection
    @OneToMany(fetch = FetchType.LAZY, mappedBy="coordinateType")
    private Set<Coordinate> coordinates;

    public Long getCoordinateTypeId() {
        return coordinateTypeId;
    }

    public void setCoordinateTypeId(Long coordinateTypeId) {
        this.coordinateTypeId = coordinateTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
