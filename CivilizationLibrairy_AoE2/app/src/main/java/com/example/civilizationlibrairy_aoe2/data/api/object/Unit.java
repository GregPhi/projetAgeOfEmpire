package com.example.civilizationlibrairy_aoe2.data.api.object;

import java.util.List;

/**
 * object representing unit retrieved by the API
 */
public class Unit {
    private int id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String created_in;
    private Cost cost;
    private int build_time;
    private int reload_time;
    private int attack_delay;
    private int movement_rate;
    private int line_of_sight;
    private int hit_points;
    private int range;
    private int attack;
    private String armor;
    private List<String> attack_bonus;
    private String accuracy;

    public Unit() {
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

    public String getCreated_in() {
        return created_in;
    }

    public void setCreated_in(String created_in) {
        this.created_in = created_in;
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

    public int getReload_time() {
        return reload_time;
    }

    public void setReload_time(int reload_time) {
        this.reload_time = reload_time;
    }

    public int getAttack_delay() {
        return attack_delay;
    }

    public void setAttack_delay(int attack_delay) {
        this.attack_delay = attack_delay;
    }

    public int getMovement_rate() {
        return movement_rate;
    }

    public void setMovement_rate(int movement_rate) {
        this.movement_rate = movement_rate;
    }

    public int getLine_of_sight() {
        return line_of_sight;
    }

    public void setLine_of_sight(int line_of_sight) {
        this.line_of_sight = line_of_sight;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public List<String> getAttack_bonus() {
        return attack_bonus;
    }

    public void setAttack_bonus(List<String> attack_bonus) {
        this.attack_bonus = attack_bonus;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }
}
