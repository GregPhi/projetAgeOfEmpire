package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter;

/**
 * civilization use to display information on InfoCivilizationActivity when you come from CivilizationHomeGrillAdapter or CivilizationHomeListAdapter
 */
public class CivilizationHomeItemViewModel {
    private String civilization_id;
    private String img_civilization;
    private String civilization_name;
    private String civilization_expansion;
    private String civilization_bonus;
    private String civilization_army_type;
    private String civilization_unique_unit;
    private String civilization_unique_tech;
    private String civilization_team_bonus;
    private boolean isFavorite;

    public CivilizationHomeItemViewModel() {
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

    public String getCivilization_team_bonus() {
        return civilization_team_bonus;
    }

    public void setCivilization_team_bonus(String civilization_team_bonus) {
        this.civilization_team_bonus = civilization_team_bonus;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
