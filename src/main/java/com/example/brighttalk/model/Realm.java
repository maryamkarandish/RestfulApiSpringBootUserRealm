package com.example.brighttalk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;

/**
 * Created by m.karandish on 6/13/2019.
 * This is our Ream Entity
 */
@Entity
@Table(name = "REALM", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "uniqueNameConstraint")})
@JacksonXmlRootElement
public class Realm {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name" , unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "key", length = 32)
    private String key;

    public Realm() {
    }

    public Realm(String name, String description, String key) {
        this.name = name;
        this.description = description;
        this.key = key;
    }

    /**
     * get the Id
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     * Set the Id
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * set the Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the Description
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the Description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * get he Key
     * @return
     */
    public String getKey() {
        return key;
    }

    /**
     * Set the Key
     * @param key
     */
    public void setKey(String key) {
        this.key = key;
    }
}
