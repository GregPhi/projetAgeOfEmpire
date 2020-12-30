package com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * civilization use to display information on InfoCivilizationActivity when you come from CivilizationFavoriteAdapter
 */
public class CivilizationFavoriteItemViewModel implements Parcelable {
    private String civilization_id;
    private String img_civilization;
    private String civilization_name;
    private String civilization_expansion;
    private String civilization_army_type;
    private String civilization_unique_unit;
    private String civilization_unique_tech;
    private String civilization_tem_bonus;
    private String civilization_bonus;

    public CivilizationFavoriteItemViewModel() {
    }

    protected CivilizationFavoriteItemViewModel(Parcel in) {
        civilization_id = in.readString();
        img_civilization = in.readString();
        civilization_name = in.readString();
        civilization_expansion = in.readString();
        civilization_army_type = in.readString();
        civilization_unique_unit = in.readString();
        civilization_unique_tech = in.readString();
        civilization_tem_bonus = in.readString();
        civilization_bonus = in.readString();
    }

    public static final Creator<CivilizationFavoriteItemViewModel> CREATOR = new Creator<CivilizationFavoriteItemViewModel>() {
        @Override
        public CivilizationFavoriteItemViewModel createFromParcel(Parcel in) {
            return new CivilizationFavoriteItemViewModel(in);
        }

        @Override
        public CivilizationFavoriteItemViewModel[] newArray(int size) {
            return new CivilizationFavoriteItemViewModel[size];
        }
    };

    public String getCivilization_army_type() {
        return civilization_army_type;
    }

    public void setCivilization_army_type(String civilization_army_type) {
        this.civilization_army_type = civilization_army_type;
    }

    public String getCivilization_unique_unit() {
        return civilization_unique_unit;
    }

    public void setCivilization_unique_unit(String civilization_unique_unit) {
        this.civilization_unique_unit = civilization_unique_unit;
    }

    public String getCivilization_unique_tech() {
        return civilization_unique_tech;
    }

    public void setCivilization_unique_tech(String civilization_unique_tech) {
        this.civilization_unique_tech = civilization_unique_tech;
    }

    public String getCivilization_tem_bonus() {
        return civilization_tem_bonus;
    }

    public void setCivilization_tem_bonus(String civilization_tem_bonus) {
        this.civilization_tem_bonus = civilization_tem_bonus;
    }

    public String getCivilization_id() {
        return civilization_id;
    }

    public void setCivilization_id(String civilization_id) {
        this.civilization_id = civilization_id;
    }

    public String getImg_civilization() {
        return img_civilization;
    }

    public void setImg_civilization(String img_civilization) {
        this.img_civilization = img_civilization;
    }

    public String getCivilization_name() {
        return civilization_name;
    }

    public void setCivilization_name(String civilization_name) {
        this.civilization_name = civilization_name;
    }

    public String getCivilization_expansion() {
        return civilization_expansion;
    }

    public void setCivilization_expansion(String civilization_expansion) {
        this.civilization_expansion = civilization_expansion;
    }

    public String getCivilization_bonus() {
        return civilization_bonus;
    }

    public void setCivilization_bonus(String civilization_bonus) {
        this.civilization_bonus = civilization_bonus;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(civilization_id);
        parcel.writeString(img_civilization);
        parcel.writeString(civilization_name);
        parcel.writeString(civilization_expansion);
        parcel.writeString(civilization_army_type);
        parcel.writeString(civilization_unique_unit);
        parcel.writeString(civilization_unique_tech);
        parcel.writeString(civilization_tem_bonus);
        parcel.writeString(civilization_bonus);
    }
}
