package com.example.civilizationlibrairy_aoe2.data.repository.civilization.mapper;

import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class CivilizationToCivilizationEntityMapper {
    private final List<String> url_civilizations;

    public CivilizationToCivilizationEntityMapper(List<String> url){
        this.url_civilizations = url;
    }

    /**
     * map a civilization remote with api to a civilization entity
     * @param civilization : the civilization to map
     * @return : a new civilization entity
     */
    public CivilizationEntity map(Civilization civilization){
        CivilizationEntity civilizationEntity = new CivilizationEntity();
        boolean urlOk = false;
        if(url_civilizations!=null){
            for(String u : url_civilizations){
                String temp_name = civilization.getName().toLowerCase();
                String temp_u = u.toLowerCase();
                if(temp_u.contains(temp_name)){
                    civilizationEntity.setUrl_picture(u);
                    urlOk = true;
                }
            }
        }
        if(!urlOk){
            civilizationEntity.setUrl_picture("");
        }
        civilizationEntity.setId(String.valueOf(civilization.getId()));
        civilizationEntity.setName(civilization.getName());
        civilizationEntity.setExpansion(civilization.getExpansion());
        civilizationEntity.setArmy_type(civilization.getArmy_type());
        String unique_unit;
        if(civilization.getUnique_unit()==null || civilization.getUnique_unit().size()<1){
            unique_unit = "N.C";
        }else{
            unique_unit = civilization.getUnique_unit().get(0);
        }
        civilizationEntity.setUnique_unit(unique_unit);
        String unique_tech;
        if(civilization.getUnique_tech()==null || civilization.getUnique_tech().size()<1){
            unique_tech = "N.C";
        }else{
            unique_tech = civilization.getUnique_tech().get(0);
        }
        civilizationEntity.setUnique_tech(unique_tech);
        civilizationEntity.setTeam_bonus(civilization.getTeam_bonus());
        String unique_bonus;
        if(civilization.getCivilization_bonus()==null || civilization.getCivilization_bonus().size()<1){
            unique_bonus = "N.C";
        }else{
            unique_bonus = StringUtils.join(civilization.getCivilization_bonus(),"\n");
        }
        civilizationEntity.setCivilization_bonus(unique_bonus);
        return civilizationEntity;
    }
}
