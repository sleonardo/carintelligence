package com.carintelligence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */

@Entity
@Table(name = "rules")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Rule extends AppEntities {
    @Id
    @GeneratedValue
    @Expose
    private Long ruleId;
    @Expose
    private Integer status;
    @Expose
    private Integer day;
    @Expose
    private String description;
    @Expose
    private String hoursToParking;
    @Expose
    private String beginHour;
    @Expose
    private String endHour;
    @Expose
    private String label;
    @Expose
    private Integer frecuency;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="street")
    private Street street;

    public Rule() {
    }

    public Rule(Integer status, Integer day, String description, String hoursToParking, String beginHour, String endHour, String label, Integer frecuency, Street street) {
        this.status = status;
        this.day = day;
        this.description = description;
        this.hoursToParking = hoursToParking;
        this.beginHour = beginHour;
        this.endHour = endHour;
        this.label = label;
        this.frecuency = frecuency;
        this.street = street;
    }


    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHoursToParking() {
        return hoursToParking;
    }

    public void setHoursToParking(String hoursToParking) {
        this.hoursToParking = hoursToParking;
    }

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(Integer frecuency) {
        this.frecuency = frecuency;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
