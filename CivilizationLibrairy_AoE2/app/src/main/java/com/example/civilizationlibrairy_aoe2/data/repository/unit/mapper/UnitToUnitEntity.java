package com.example.civilizationlibrairy_aoe2.data.repository.unit.mapper;

import android.text.TextUtils;

import com.example.civilizationlibrairy_aoe2.data.api.object.Unit;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;
import com.example.civilizationlibrairy_aoe2.data.repository.CostToCostEntity;

import java.util.List;

public class UnitToUnitEntity {
    private final List<String> urls;
    private final CostToCostEntity costToCostEntity;

    public UnitToUnitEntity(List<String> u){
        this.urls = u;
        this.costToCostEntity = new CostToCostEntity();
    }

    /**
     * map a unit remote with api to a unit entity
     * @param unit : the unit to map
     * @return : a new unit entity
     */
    public UnitEntity map(Unit unit,String url){
        UnitEntity unitEntity = new UnitEntity();
        unitEntity.setId(String.valueOf(unit.getId()));
        unitEntity.setName(unit.getName());
        unitEntity.setUrl_api(url);
        unitEntity.setDescription(unit.getDescription());
        unitEntity.setExpansion(unit.getExpansion());
        unitEntity.setAge(unit.getAge());
        unitEntity.setCreated_in(unit.getCreated_in());
        unitEntity.setCost(costToCostEntity.map(unit.getCost()));
        unitEntity.setBuild_time(String.valueOf(unit.getBuild_time()));
        unitEntity.setReload_time(String.valueOf(unit.getReload_time()));
        unitEntity.setAttack_delay(String.valueOf(unit.getAttack_delay()));
        unitEntity.setMovement_rate(String.valueOf(unit.getMovement_rate()));
        unitEntity.setLine_of_sight(String.valueOf(unit.getLine_of_sight()));
        unitEntity.setHit_points(String.valueOf(unit.getHit_points()));
        unitEntity.setRange(String.valueOf(unit.getRange()));
        unitEntity.setAttack(String.valueOf(unit.getAttack()));
        if (unit.getAttack_bonus() == null) {
            unitEntity.setAttack_bonus("N.C.");
        } else {
            unitEntity.setAttack_bonus(TextUtils.join(", ", unit.getAttack_bonus()));
        }
        unitEntity.setArmor(unit.getArmor());
        unitEntity.setAccuracy(unit.getAccuracy());
        boolean urlOk = false;
        if(urls!=null){
            for(String u : urls){
                String temp_name = unit.getName().toLowerCase();
                String temp_u = u.toLowerCase();
                if(temp_u.contains(temp_name)){
                    unitEntity.setUrl_picture(u);
                    urlOk = true;
                }
            }
        }
        if(!urlOk){
            unitEntity.setUrl_picture("");
        }
        return unitEntity;
    }
}
