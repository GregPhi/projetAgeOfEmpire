package com.example.civilizationlibrairy_aoe2.data.db.dao;

import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface CivilizationDao {
    /**
     * Add a <code>civilizationEntity</code> to the database (on the favorite database)
     * @param civilizationEntity : a specific civilization to add
     * @return job completed (a CivilizationEntity was add)
     */
    @Insert
    Completable addCivilizationToFavoriteDatabase(CivilizationEntity civilizationEntity);

    /**
     * Remove a CivilizationEntity to the database (on the favorite database)
     * @param id : a specific civilization to remove
     * @return job completed (a CivilizationEntity was remove)
     */
    @Query("DELETE FROM civilizationEntity where id = :id")
    Completable deleteCivilizationToFavoriteDatabaseWithThisId(String id);

    /**
     * Get all civilization in database (says like favorites civilizations)
     * @return : all civilization in database
     */
    @Query("SELECT * FROM civilizationEntity")
    Flowable<List<CivilizationEntity>> getAllFavoriteCivilizations();

    /**
     * Get a favorite civilization
     * @param id : the id's civilization to return
     * @return : a specific civilization
     */
    @Query("SELECT * FROM civilizationEntity WHERE id = :id")
    Single<CivilizationEntity> getAFavoriteCivilization(String id);

    /**
     * returns all the ids of civilizations in the database
     * @return all ids in database
     */
    @Query("SELECT id from civilizationEntity")
    Single<List<String>> getFavoriteCivilizationListId();
}
