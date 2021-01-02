package com.example.civilizationlibrairy_aoe2.data.api.service;


import com.example.civilizationlibrairy_aoe2.data.api.list.CivilizationsList;
import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * use to retrieve information
 * -> allCivilizations
 * -> a specific civilization with id or name (in database of API)
 */
public interface AoE2Service {
    String URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/";

    @GET("civilizations")
    Single<CivilizationsList> getAllCivilizations();

    @GET("civilization/{id}")
    Single<Civilization> getACivilization(@Path("id") String id);
}
