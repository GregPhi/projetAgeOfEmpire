package com.example.civilizationlibrairy_aoe2.data.api.list;

import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * object representing civilizations retrieved by the API
 */
public class CivilizationsList {
    @SerializedName("civilizations")
    List<Civilization> civilizationList;

    public List<Civilization> getCivilizationList(){ return civilizationList; }
}
