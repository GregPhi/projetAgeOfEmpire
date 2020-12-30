package com.example.civilizationlibrairy_aoe2.data.db.dao;

import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;

@Dao
public interface UnitDao {
    /**
     * Add a <code>unitEntity</code> to the database
     * @param unitEntity : a specific unit to add
     * @return job completed (a UnitEntity was add)
     */
    @Insert
    Completable addUnitToDatabase(UnitEntity unitEntity);

    /**
     * Remove a UnitEntity to the database
     * @param url_api : a specific unit to remove
     * @return job completed (a UnitEntity was remove)
     */
    @Query("DELETE FROM unitEntity WHERE url_api = :url_api")
    Completable deleteUnitToDatabaseWithId(String url_api);

    /**
     * Get all units in database
     * @return : all units
     */
    @Query("SELECT * FROM unitEntity WHERE url_api = :url_api")
    UnitEntity getAUnit(String url_api);
}
