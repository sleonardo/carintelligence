package com.carintelligence.model;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Project: carintelligence
 * Created by Leonardo Simoza on 16/3/17.
 **/
public class ApiResponse implements Serializable {
    private Integer code;
    private String message;
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
        Gson gson = new Gson();
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
