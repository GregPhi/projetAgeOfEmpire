package com.example.civilizationlibrairy_aoe2.data.db.dao;

import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UnitDao {
    /**
     * Add a <code>unitEntity</code> to the database
     * @param unitEntity : a specific unit to add
     */
    @Insert
    void addUnitToDatabase(UnitEntity unitEntity);

    /**
     * Remove a UnitEntity to the database
     * @param url_api : a specific unit to remove
     */
    @Query("DELETE FROM unitEntity WHERE url_api = :url_api")
    void deleteUnitToDatabaseWithId(String url_api);

    /**
     * Get all units in database
     * @return : all units
     */
    @Query("SELECT * FROM unitEntity WHERE url_api = :url_api")
    UnitEntity getAUnit(String url_api);
}
