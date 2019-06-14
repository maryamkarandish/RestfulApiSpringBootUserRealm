package com.example.brighttalk.web;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by m.karandish on 6/13/2019.
 */
public class RealmDto {


    @NotNull
    @Size(max = 255)
    private String name;

    @NotEmpty
    @Size(max = 255)
    private String description;

    public RealmDto() {
    }

    public RealmDto(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
