package com.example.civilizationlibrairy_aoe2.data.repository.civilization.local;

import com.example.civilizationlibrairy_aoe2.data.db.ProjectDatabase;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

public class CivilizationLocalDataSource {
    private final ProjectDatabase projectDatabase;

    public CivilizationLocalDataSource(ProjectDatabase database) {
        this.projectDatabase = database;
    }

    /**
     * Get all civilization in database (says like favorites civilizations)
     * @return : all civilization in database
     */
    public Flowable<List<CivilizationEntity>> getAllFavoriteCivilizations() {
        return projectDatabase.civilizationDao().getAllFavoriteCivilizations();
    }

    /**
     * Get a favorite civilization
     * @param id : the id's civilization to return
     * @return : a specific civilization
     */
    public Single<CivilizationEntity> getAFavoriteCivilization(String id){
        return projectDatabase.civilizationDao().getAFavoriteCivilization(id);
    }

    /**
     * Add a <code>bookEntity</code> to the database (on the favorite database)
     * @param civilizationEntity : a specific civilization to add
     * @return job completed (a CivilizationEntity was add)
     */
    public Completable addCivilizationToFavoriteDatabase(CivilizationEntity civilizationEntity) {
        return projectDatabase.civilizationDao().addCivilizationToFavoriteDatabase(civilizationEntity);
    }

    /**
     * Remove a <code>bookEntity</code> to the database (on the favorite database)
     * @param id : a specific civilization to remove
     * @return job completed (a CivilizationEntity was remove)
     */
    public Completable deleteCivilizationToFavoriteDatabaseWithThisId(String id) {
        return projectDatabase.civilizationDao().deleteCivilizationToFavoriteDatabaseWithThisId(id);
    }

    /**
     * returns all the ids of civilizations in the database
     * @return all ids in database
     */
    public Single<List<String>> getFavoriteCivilizationListId() {
        return projectDatabase.civilizationDao().getFavoriteCivilizationListId();
    }
}
