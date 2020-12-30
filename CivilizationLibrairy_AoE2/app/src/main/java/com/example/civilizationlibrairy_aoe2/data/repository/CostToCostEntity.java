package com.example.civilizationlibrairy_aoe2.data.repository;

import com.example.civilizationlibrairy_aoe2.data.api.object.Cost;
import com.example.civilizationlibrairy_aoe2.data.entity.CostEntity;

public class CostToCostEntity {
    /**
     * Map a Cost object to a CostEntity
     * @param cost : the cost to map
     * @return : result of mapping
     */
    public CostEntity map(Cost cost){
        CostEntity costEntity = new CostEntity();
        costEntity.setFood(cost.getFood());
        costEntity.setGold(cost.getGold());
        costEntity.setStone(cost.getStone());
        costEntity.setWood(cost.getWood());
        return costEntity;
    }
}
