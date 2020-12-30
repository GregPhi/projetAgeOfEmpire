package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.mapper;

import android.text.TextUtils;

import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class CivilizationToCivilizationHomeItemViewModel {
    /**
     * Map a <code>civilization</code> to a CivilizationHomeItemViewModel
     * @param civilization : the Civilization to transform
     * @param url : the url come from R.array.url_civilizations (it's url to get a specific picture)
     * @return : a new CivilizationHomeItemViewModel
     */
    public CivilizationHomeItemViewModel map(Civilization civilization, List<String> url){
        CivilizationHomeItemViewModel civilizationHomeItemViewModel = new CivilizationHomeItemViewModel();
        String url_img = "";
        for(String u : url){
            String temp_name = civilization.getName().toLowerCase();
            String temp_u = u.toLowerCase();
            if(temp_u.contains(temp_name)){
                url_img = u;
            }
        }
        civilizationHomeItemViewModel.setImg_civilization(url_img);
        civilizationHomeItemViewModel.setCivilization_id(String.valueOf(civilization.getId()));
        civilizationHomeItemViewModel.setCivilization_name(civilization.getName());
        civilizationHomeItemViewModel.setCivilization_expansion(civilization.getExpansion());
        civilizationHomeItemViewModel.setCivilization_army_type(civilization.getArmy_type());
        String unique_unit;
        if(civilization.getUnique_unit()==null || civilization.getUnique_unit().size()<1){
            unique_unit = "N.C";
        }else{
            unique_unit = civilization.getUnique_unit().get(0);
        }
        civilizationHomeItemViewModel.setCivilization_unique_unit(unique_unit);
        String unique_tech;
        if(civilization.getUnique_tech()==null || civilization.getUnique_tech().size()<1){
            unique_tech = "N.C";
        }else{
            unique_tech = civilization.getUnique_tech().get(0);
        }
        civilizationHomeItemViewModel.setCivilization_unique_tech(unique_tech);
        civilizationHomeItemViewModel.setCivilization_team_bonus(civilization.getTeam_bonus());
        String unique_bonus;
        if(civilization.getCivilization_bonus()==null){
            unique_bonus = "N.C";
        }else{
            unique_bonus = TextUtils.join("\n", civilization.getCivilization_bonus());
        }
        civilizationHomeItemViewModel.setCivilization_bonus(unique_bonus);
        civilizationHomeItemViewModel.setFavorite(civilization.isFavorite());
        return civilizationHomeItemViewModel;
    }

    /**
     * Map a list of Civilization to a list of CivilizationHomeItemViewModel
     * @param civilizations : the list to transform
     * @param url : the url come from R.array.url_civilizations (it's url to get a specific picture)
     * @return : a new CivilizationHomeItemViewModel list
     */
    public List<CivilizationHomeItemViewModel> map(final List<Civilization> civilizations, final List<String> url){
        List<CivilizationHomeItemViewModel> civilizationHomeItemViewModels = new ArrayList<>();
        for(Civilization civilization : civilizations){
            civilizationHomeItemViewModels.add(map(civilization, url));
        }
        return civilizationHomeItemViewModels;
    }
}
