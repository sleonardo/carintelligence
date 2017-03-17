package com.carintelligence.model;

import com.google.gson.Gson;

/**
 * Project: carintelligence
 * Created by leonardo on 16/3/17.
 **/
public class AppEntities {
    public String toJSON(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
