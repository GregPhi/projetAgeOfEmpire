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
    /* URL of APi */
    String URL = "https://age-of-empires-2-api.herokuapp.com/api/v1/";

    /**
     * Method GET -> remote all civilizations
     * @return : List of Civilization
     */
    @GET("civilizations")
    Single<CivilizationsList> getAllCivilizations();

    /**
     * Method GET -> remote a specific civilization with <code>id</code> (can be id or name)
     * @param id : id or name of one civilization
     * @return : a specific civilization
     */
    @GET("civilization/{id}")
    Single<Civilization> getACivilization(@Path("id") String id);
}
