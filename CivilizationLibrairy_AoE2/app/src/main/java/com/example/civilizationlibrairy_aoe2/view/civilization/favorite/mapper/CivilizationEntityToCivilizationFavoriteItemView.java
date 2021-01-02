package com.example.civilizationlibrairy_aoe2.view.civilization.favorite.mapper;

import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter.CivilizationFavoriteItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class CivilizationEntityToCivilizationFavoriteItemView {
    /**
     * Map a <code>civilizationEntity</code> to a CivilizationFavoriteItemViewModel
     * @param civilizationEntity : the civilization to transform
     * @return : a new CivilizationFavoriteItemViewModel
     */
    public CivilizationFavoriteItemViewModel map(CivilizationEntity civilizationEntity){
        CivilizationFavoriteItemViewModel civilizationFavoriteItemViewModel = new CivilizationFavoriteItemViewModel();
        civilizationFavoriteItemViewModel.setImg_civilization(civilizationEntity.getUrl_picture());
        civilizationFavoriteItemViewModel.setCivilization_id(civilizationEntity.getId());
        civilizationFavoriteItemViewModel.setCivilization_name(civilizationEntity.getName());
        civilizationFavoriteItemViewModel.setCivilization_expansion(civilizationEntity.getExpansion());
        civilizationFavoriteItemViewModel.setCivilization_army_type(civilizationEntity.getArmy_type());
        civilizationFavoriteItemViewModel.setCivilization_unique_unit(civilizationEntity.getUnique_unit());
        civilizationFavoriteItemViewModel.setCivilization_unique_tech(civilizationEntity.getUnique_tech());
        civilizationFavoriteItemViewModel.setCivilization_tem_bonus(civilizationEntity.getTeam_bonus());
        civilizationFavoriteItemViewModel.setCivilization_bonus(civilizationEntity.getCivilization_bonus());
        return civilizationFavoriteItemViewModel;
    }

    /**
     * Map a list of CivilizationEntity to a list of CivilizationFavoriteItemViewModel
     * @param civilizationEntities : the list to transform
     * @return : a new CivilizationFavoriteItemViewModel list
     */
    public List<CivilizationFavoriteItemViewModel> map(List<CivilizationEntity> civilizationEntities){
        List<CivilizationFavoriteItemViewModel> civilizationFavoriteItemViewModels = new ArrayList<>();
        for(CivilizationEntity civilizationEntity : civilizationEntities){
            civilizationFavoriteItemViewModels.add(map(civilizationEntity));
        }
        return civilizationFavoriteItemViewModels;
    }

    /**
     * Map a <code>civilizationFavoriteItemViewModel</code> to a CivilizationEntity
     * @param civilizationFavoriteItemViewModel : the civilization to transform
     * @return : a new CivilizationEntity
     */
    public CivilizationEntity reverseMap(CivilizationFavoriteItemViewModel civilizationFavoriteItemViewModel){
        CivilizationEntity civilizationEntity = new CivilizationEntity();
        civilizationEntity.setUrl_picture(civilizationFavoriteItemViewModel.getImg_civilization());
        civilizationEntity.setId(civilizationFavoriteItemViewModel.getCivilization_id());
        civilizationEntity.setName(civilizationFavoriteItemViewModel.getCivilization_name());
        civilizationEntity.setExpansion(civilizationFavoriteItemViewModel.getCivilization_expansion());
        civilizationEntity.setArmy_type(civilizationFavoriteItemViewModel.getCivilization_army_type());
        civilizationEntity.setUnique_unit(civilizationFavoriteItemViewModel.getCivilization_unique_unit());
        civilizationEntity.setUnique_tech(civilizationFavoriteItemViewModel.getCivilization_unique_tech());
        civilizationEntity.setTeam_bonus(civilizationFavoriteItemViewModel.getCivilization_tem_bonus());
        civilizationEntity.setCivilization_bonus(civilizationFavoriteItemViewModel.getCivilization_bonus());
        return civilizationEntity;
    }
}
