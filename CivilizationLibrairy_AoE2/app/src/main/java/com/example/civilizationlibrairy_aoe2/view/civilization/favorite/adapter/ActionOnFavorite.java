package com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter;

public interface ActionOnFavorite {
    /**
     * Remove a civilization to the database
     * @param id : a specific id
     */
    void onRemoveFavorite(String id);

    /**
     * Use to send a item to InfoCivilizationActivity when implements
     * @param item : a item to display
     */
    void displayInformation(CivilizationFavoriteItemViewModel item);
}
