package com.example.civilizationlibrairy_aoe2.data.entity;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * the technology entity
 */
@Entity
public class TechnologyEntity {
    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String develops_in;
    @Embedded
    private CostEntity cost;
    private String build_time;
    private String applies_to;
    private String url_picture;
    private String url_api;

    public TechnologyEntity() {
        id = "";
    }

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
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

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDevelops_in() {
        return develops_in;
    }

    public void setDevelops_in(String develops_in) {
        this.develops_in = develops_in;
    }

    public CostEntity getCost() {
        return cost;
    }

    public void setCost(CostEntity cost) {
        this.cost = cost;
    }

    public String getBuild_time() {
        return build_time;
    }

    public void setBuild_time(String build_time) {
        this.build_time = build_time;
    }

    public String getApplies_to() {
        return applies_to;
    }

    public void setApplies_to(String applies_to) {
        this.applies_to = applies_to;
    }

    public String getUrl_picture(){ return url_picture; }

    public void setUrl_picture(String url_picture){ this.url_picture = url_picture; }

    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(String url_api) {
        this.url_api = url_api;
    }
}
