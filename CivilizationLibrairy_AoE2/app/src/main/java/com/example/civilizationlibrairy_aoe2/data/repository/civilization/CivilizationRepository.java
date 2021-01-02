package com.example.civilizationlibrairy_aoe2.data.repository.civilization;

import com.example.civilizationlibrairy_aoe2.data.api.list.CivilizationsList;
import com.example.civilizationlibrairy_aoe2.data.api.object.Civilization;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.local.CivilizationLocalDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.civilization.remote.CivilizationRemoteDataSource;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.BiFunction;

public class CivilizationRepository{
    private final CivilizationLocalDataSource civilizationLocalDataSource;
    private final CivilizationRemoteDataSource civilizationRemoteDataSource;

    public CivilizationRepository(CivilizationLocalDataSource civilizationLocalDataSource, CivilizationRemoteDataSource civilizationRemoteDataSource) {
        this.civilizationLocalDataSource = civilizationLocalDataSource;
        this.civilizationRemoteDataSource = civilizationRemoteDataSource;
    }

    /**
     * Get all civilization in database (says like favorites civilizations)
     * @return : all civilization in database
     */
    public Flowable<List<CivilizationEntity>> getAllFavoriteCivilizations() {
        return civilizationLocalDataSource.getAllFavoriteCivilizations();
    }

    /**
     * Get a favorite civilization
     * @param id : the id's civilization to return
     * @return : a specific civilization
     */
    public Single<CivilizationEntity> getAFavoriteCivilization(String id){
        return civilizationLocalDataSource.getAFavoriteCivilization(id);
    }

    /**
     * Add a <code>bookEntity</code> to the database (on the favorite database)
     * @param civilizationEntity : a specific civilization to add
     * @return job completed (a CivilizationEntity was add)
     */
    public Completable addCivilizationToFavoriteDatabase(CivilizationEntity civilizationEntity) {
        return civilizationLocalDataSource.addCivilizationToFavoriteDatabase(civilizationEntity);
    }

    /**
     * Remove a <code>bookEntity</code> to the database (on the favorite database)
     * @param id : a specific civilization to remove
     * @return job completed (a CivilizationEntity was remove)
     */
    public Completable deleteCivilizationToFavoriteDatabaseWithThisId(String id) {
        return civilizationLocalDataSource.deleteCivilizationToFavoriteDatabaseWithThisId(id);
    }

    /**
     * returns all the ids of civilizations in the database
     * @return all ids in database
     */
    public Single<List<String>> getFavoriteCivilizationListId() {
        return civilizationLocalDataSource.getFavoriteCivilizationListId();
    }

    /**
     * Get all civilizations from the API
     * @return : all civilizations
     */
    public Single<CivilizationsList> getAllCivilizations() {
        return civilizationRemoteDataSource.getAllCivilizations()
                .zipWith(civilizationLocalDataSource.getFavoriteCivilizationListId(), new BiFunction<CivilizationsList, List<String>, CivilizationsList>() {
                    @Override
                    public CivilizationsList apply(CivilizationsList civilizationsList, List<String> strings) {
                        for(Civilization civilization : civilizationsList.getCivilizationList()){
                            if(strings.contains(String.valueOf(civilization.getId()))){
                                civilization.setFavorite();
                            }
                        }
                        return civilizationsList;
                    }
                });
    }

    /**
     * Get a specific civilization using this <code>id</code>
     * @param id : the id of the civilization to remote
     * @return : one specific civilization
     */
    public Single<Civilization> getACivilization(String id) {
        return civilizationRemoteDataSource.getACivilization(id)
                .zipWith(civilizationLocalDataSource.getFavoriteCivilizationListId(), new BiFunction<Civilization, List<String>, Civilization>() {
                    @Override
                    public Civilization apply(Civilization civilization, List<String> strings) {
                        if(strings.contains(String.valueOf(civilization.getId()))){
                            civilization.setFavorite();
                        }
                        return civilization;
                    }
                });
    }
}
