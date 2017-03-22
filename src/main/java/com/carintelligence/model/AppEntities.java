package com.carintelligence.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.Serializable;

/**
 * Project: carintelligence
 * Created by leonardo on 16/3/17.
 **/
public class AppEntities implements Serializable {
    public String toJSON(){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(this);
    }
}
