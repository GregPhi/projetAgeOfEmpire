package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.mapper;

import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;

public class CivilizationHomeItemViewModelToCivilizationEntity {
    /**
     * Map a <code>civilizationHomeItemViewModel</code> to a CivilizationEntity
     * @param civilizationHomeItemViewModel : the CivilizationHomeItemViewModel to transform
     * @return : a new CivilizationEntity
     */
    public CivilizationEntity map(CivilizationHomeItemViewModel civilizationHomeItemViewModel){
        CivilizationEntity civilizationEntity = new CivilizationEntity();
        civilizationEntity.setId(civilizationHomeItemViewModel.getCivilization_id());
        civilizationEntity.setName(civilizationHomeItemViewModel.getCivilization_name());
        civilizationEntity.setExpansion(civilizationHomeItemViewModel.getCivilization_expansion());
        civilizationEntity.setArmy_type(civilizationHomeItemViewModel.getCivilization_army_type());
        civilizationEntity.setUnique_unit(civilizationHomeItemViewModel.getCivilization_unique_unit());
        civilizationEntity.setUnique_tech(civilizationHomeItemViewModel.getCivilization_unique_tech());
        civilizationEntity.setTeam_bonus(civilizationHomeItemViewModel.getCivilization_team_bonus());
        civilizationEntity.setCivilization_bonus(civilizationHomeItemViewModel.getCivilization_bonus());
        civilizationEntity.setUrl_picture(civilizationHomeItemViewModel.getImg_civilization());
        return civilizationEntity;
    }
}
