package com.example.civilizationlibrairy_aoe2.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * the unit entity
 */
@Entity
public class UnitEntity implements Parcelable {
    @NonNull
    @PrimaryKey
    private String url_api;
    private String id;
    private String name;
    private String description;
    private String expansion;
    private String age;
    private String created_in;
    @Embedded
    private CostEntity cost;
    private String build_time;
    private String reload_time;
    private String attack_delay;
    private String movement_rate;
    private String line_of_sight;
    private String hit_points;
    private String range;
    private String attack;
    private String armor;
    private String attack_bonus;
    private String accuracy;
    private String url_picture;

    public UnitEntity() {
        url_api = "";
    }

    protected UnitEntity(Parcel in) {
        url_api = Objects.requireNonNull(in.readString());
        id = in.readString();
        name = in.readString();
        description = in.readString();
        expansion = in.readString();
        age = in.readString();
        created_in = in.readString();
        build_time = in.readString();
        reload_time = in.readString();
        attack_delay = in.readString();
        movement_rate = in.readString();
        line_of_sight = in.readString();
        hit_points = in.readString();
        range = in.readString();
        attack = in.readString();
        armor = in.readString();
        attack_bonus = in.readString();
        accuracy = in.readString();
        url_picture = in.readString();
    }

    public static final Creator<UnitEntity> CREATOR = new Creator<UnitEntity>() {
        @Override
        public UnitEntity createFromParcel(Parcel in) {
            return new UnitEntity(in);
        }

        @Override
        public UnitEntity[] newArray(int size) {
            return new UnitEntity[size];
        }
    };

    @NonNull
    public String getUrl_api() {
        return url_api;
    }

    public void setUrl_api(@NonNull String url_api) {
        this.url_api = url_api;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getReload_time() {
        return reload_time;
    }

    public void setReload_time(String reload_time) {
        this.reload_time = reload_time;
    }

    public String getAttack_delay() {
        return attack_delay;
    }

    public void setAttack_delay(String attack_delay) {
        this.attack_delay = attack_delay;
    }

    public String getMovement_rate() {
        return movement_rate;
    }

    public void setMovement_rate(String movement_rate) {
        this.movement_rate = movement_rate;
    }

    public String getLine_of_sight() {
        return line_of_sight;
    }

    public void setLine_of_sight(String line_of_sight) {
        this.line_of_sight = line_of_sight;
    }

    public String getHit_points() {
        return hit_points;
    }

    public void setHit_points(String hit_points) {
        this.hit_points = hit_points;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getAttack() {
        return attack;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public String getArmor() {
        return armor;
    }

    public void setArmor(String armor) {
        this.armor = armor;
    }

    public String getAttack_bonus() {
        return attack_bonus;
    }

    public void setAttack_bonus(String attack_bonus) {
        this.attack_bonus = attack_bonus;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getUrl_picture(){ return url_picture; }

    public void setUrl_picture(String url_picture){ this.url_picture = url_picture; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(url_api);
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(description);
        parcel.writeString(expansion);
        parcel.writeString(age);
        parcel.writeString(created_in);
        parcel.writeString(build_time);
        parcel.writeString(reload_time);
        parcel.writeString(attack_delay);
        parcel.writeString(movement_rate);
        parcel.writeString(line_of_sight);
        parcel.writeString(hit_points);
        parcel.writeString(range);
        parcel.writeString(attack);
        parcel.writeString(armor);
        parcel.writeString(attack_bonus);
        parcel.writeString(accuracy);
        parcel.writeString(url_picture);
    }
}
