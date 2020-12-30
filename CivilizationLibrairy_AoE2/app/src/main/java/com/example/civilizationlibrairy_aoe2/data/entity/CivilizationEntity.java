package com.example.civilizationlibrairy_aoe2.data.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * the civilization entity
 */
@Entity
public class CivilizationEntity implements Parcelable {
    @NonNull
    @PrimaryKey
    private String id;
    private String name;
    private String expansion;
    private String army_type;
    private String unique_unit;
    private String unique_tech;
    private String team_bonus;
    private String civilization_bonus;
    private String url_picture;

    public CivilizationEntity() {
        id = "";
    }

    protected CivilizationEntity(Parcel in) {
        id = Objects.requireNonNull(in.readString());
        name = in.readString();
        expansion = in.readString();
        army_type = in.readString();
        unique_unit = in.readString();
        unique_tech = in.readString();
        team_bonus = in.readString();
        civilization_bonus = in.readString();
        url_picture = in.readString();
    }

    public static final Creator<CivilizationEntity> CREATOR = new Creator<CivilizationEntity>() {
        @Override
        public CivilizationEntity createFromParcel(Parcel in) {
            return new CivilizationEntity(in);
        }

        @Override
        public CivilizationEntity[] newArray(int size) {
            return new CivilizationEntity[size];
        }
    };

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

    public String getExpansion() {
        return expansion;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public String getArmy_type() {
        return army_type;
    }

    public void setArmy_type(String army_type) {
        this.army_type = army_type;
    }

    public String getUnique_unit() {
        return unique_unit;
    }

    public void setUnique_unit(String unique_unit) {
        this.unique_unit = unique_unit;
    }

    public String getUnique_tech() {
        return unique_tech;
    }

    public void setUnique_tech(String unique_tech) {
        this.unique_tech = unique_tech;
    }

    public String getTeam_bonus() {
        return team_bonus;
    }

    public void setTeam_bonus(String team_bonus) {
        this.team_bonus = team_bonus;
    }

    public String getCivilization_bonus() {
        return civilization_bonus;
    }

    public void setCivilization_bonus(String civilization_bonus) { this.civilization_bonus = civilization_bonus; }

    public String getUrl_picture(){ return url_picture; }

    public void setUrl_picture(String url_picture){ this.url_picture = url_picture; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(expansion);
        parcel.writeString(army_type);
        parcel.writeString(unique_unit);
        parcel.writeString(unique_tech);
        parcel.writeString(team_bonus);
        parcel.writeString(civilization_bonus);
        parcel.writeString(url_picture);
    }
}
