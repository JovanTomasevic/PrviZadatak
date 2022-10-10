package com.data.models;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatchCrocodileRequest implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}