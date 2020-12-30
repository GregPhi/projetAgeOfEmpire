package com.example.civilizationlibrairy_aoe2.data.repository.civilization.remote;

import com.example.civilizationlibrairy_aoe2.data.api.list.CivilizationsList;
import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.data.api.service.AoE2Service;

import io.reactivex.Single;
import retrofit2.http.Path;

public class CivilizationRemoteDataSource {
    private final AoE2Service aoE2Service;

    public CivilizationRemoteDataSource(AoE2Service service) {
        this.aoE2Service = service;
    }

    /**
     * Get all civilizations from the API
     * @return : all civilizations
     */
    public Single<CivilizationsList> getAllCivilizations() {
        return this.aoE2Service.getAllCivilizations();
    }

    /**
     * Get a specific civilization using this <code>id</code>
     * @param id : the id of the civilization to remote
     * @return : one specific civilization
     */
    public Single<Civilization> getACivilization(@Path("id") String id) {
        return this.aoE2Service.getACivilization(id);
    }
}
