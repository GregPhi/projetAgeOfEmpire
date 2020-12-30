package com.example.civilizationlibrairy_aoe2.data.repository.unit.remote;

import com.example.civilizationlibrairy_aoe2.data.api.object.Unit;
import com.example.civilizationlibrairy_aoe2.data.api.service.AoE2Service;

import io.reactivex.Single;

public class UnitRemoteDataSource {
    private final AoE2Service aoE2Service;

    public UnitRemoteDataSource(AoE2Service service) {
        this.aoE2Service = service;
    }

    /**
     * Get a specific unit using this <code>id</code> on id or name
     * @param id : the id of the unit to remote
     * @return : one specific unit
     */
    public Single<Unit> searchAnUnit(String id){
        return aoE2Service.searchAnUnit(id);
    }
}
