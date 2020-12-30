package com.example.civilizationlibrairy_aoe2.data.api.object;

/**
 * object representing technology retrieved by the API
 */
public class Technology {
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String develops_in;
    private Cost cost;
    private int build_time;
    private String applies_to;

    public Technology() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public int getBuild_time() {
        return build_time;
    }

    public void setBuild_time(int build_time) {
        this.build_time = build_time;
    }

    public String getApplies_to() {
        return applies_to;
    }

    public void setApplies_to(String applies_to) {
        this.applies_to = applies_to;
    }
}
