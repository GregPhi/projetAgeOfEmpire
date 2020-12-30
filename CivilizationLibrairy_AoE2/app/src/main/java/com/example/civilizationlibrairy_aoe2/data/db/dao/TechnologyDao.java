package com.example.civilizationlibrairy_aoe2.data.db.dao;

import com.example.civilizationlibrairy_aoe2.data.entity.TechnologyEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface TechnologyDao {
    /**
     * Add a <code>technologyEntity</code> to the database
     * @param technologyEntity : a specific technology to add
     * @return job completed (a TechnologyEntity was add)
     */
    @Insert
    Completable addTechnologyToDatabase(TechnologyEntity technologyEntity);

    /**
     * Remove a TechnologyEntity to the database
     * @param url_api : a specific technology to remove
     * @return job completed (a TechnologyEntity was remove)
     */
    @Query("DELETE FROM TechnologyEntity WHERE url_api = :url_api")
    Completable deleteTechnologyToDatabaseWithId(String url_api);

    /**
     * Get all technologies in database
     * @return : all technologies
     */
    @Query("SELECT * FROM TechnologyEntity")
    Flowable<List<TechnologyEntity>> getAllTechnologies();
}
