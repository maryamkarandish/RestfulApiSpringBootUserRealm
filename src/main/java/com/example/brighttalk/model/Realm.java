package com.example.brighttalk.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import javax.persistence.*;

/**
 * Created by m.karandish on 6/13/2019.
 */
@Entity
@Table(name = "USER_REALM", uniqueConstraints = {@UniqueConstraint(columnNames = "name", name = "uniqueNameConstraint")})
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
