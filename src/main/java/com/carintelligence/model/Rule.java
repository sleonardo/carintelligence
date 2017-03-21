package com.carintelligence.model;

import javax.persistence.*;

/**
 * @author leonardo
 * @project carintelligence
 * @date 20/3/17
 */

@Entity
@Table(name = "rules")
public class Rule {
    @Id
    @GeneratedValue
    private Long ruleId;
    private Boolean status;
    private Integer day;
    private String description;
    private String hoursToParking;
    private String beginHour;
    private String endHour;
    private String label;
    private Integer frecuency;
    @ManyToOne
    @JoinColumn(name="street")
    private Street street;

    public Long getRuleId() {
        return ruleId;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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
