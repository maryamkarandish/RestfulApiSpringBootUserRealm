package com.example.brighttalk.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by m.karandish on 6/13/2019.
 */
public class RealmDto {


    @Min(0)
    @Max(255)
    private String name;

    @Min(0)
    @Max(255)
    private String description;

    public RealmDto() {
    }

    public RealmDto(String name, String description) {
        this.name = name;
        this.description = description;
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
