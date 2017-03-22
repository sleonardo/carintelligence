package com.carintelligence.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 16/3/17.
 **/
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ApiResponse implements Serializable {
    @Expose
    private Integer code;
    @Expose
    private String message;
    @Expose
    private List<AppEntities> entities;

    public ApiResponse() {
    }

    public ApiResponse(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiResponse(Integer code, String message, List<AppEntities> entities) {
        this.code = code;
        this.message = message;
        this.entities = entities;
    }

    public String toJSON(){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AppEntities> getEntities() {
        if(entities == null){
            entities = new ArrayList<AppEntities>();
        }
        return entities;
    }

    public void setEntities(List<AppEntities> entities) {
        this.entities = entities;
    }

}
