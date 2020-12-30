package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter;

import java.util.concurrent.ExecutionException;

public interface ActionOnHome {
    /**
     * Add a civilization to favorite
     * @param item : civilization to add
     */
    void onFavorite(CivilizationHomeItemViewModel item);

    /**
     * Display civilization's information
     * @param item : civilization to display
     * @throws ExecutionException :
     * @throws InterruptedException :
     */
    void displayInformation(CivilizationHomeItemViewModel item) throws ExecutionException, InterruptedException;
}
