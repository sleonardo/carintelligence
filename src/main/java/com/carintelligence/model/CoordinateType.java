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
@Table(name = "coordinate_type")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CoordinateType extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long coordinateTypeId;
    @Expose
    private String name;
    private String description;

    public CoordinateType() {
    }

    public CoordinateType(String name, String description) {
        this.name = name;
        this.description = description;
    }

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
