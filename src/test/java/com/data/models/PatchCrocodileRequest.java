package com.data.models;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatchCrocodileRequest implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    private final static long serialVersionUID = 5436858967799797539L;


    public PatchCrocodileRequest() {
    }

    public PatchCrocodileRequest(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}