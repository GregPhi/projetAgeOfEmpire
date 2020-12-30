package com.example.civilizationlibrairy_aoe2.data.repository.unit;

import android.os.AsyncTask;

import com.example.civilizationlibrairy_aoe2.data.api.object.Unit;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.local.UnitLocalDataSource;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.remote.UnitRemoteDataSource;

import java.util.concurrent.ExecutionException;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UnitRepository {
    private final UnitRemoteDataSource unitRemoteDataSource;
    private final UnitLocalDataSource unitLocalDataSource;

    public UnitRepository(UnitLocalDataSource unitLocalDataSource, UnitRemoteDataSource unitRemoteDataSource) {
        this.unitLocalDataSource = unitLocalDataSource;
        this.unitRemoteDataSource = unitRemoteDataSource;
    }

    /**
     * Add a <code>unitEntity</code> to the database (on the unit database)
     * @param unitEntity : a specific unit to add
     */
    public void addUnitToDatabase(final UnitEntity unitEntity){
        unitLocalDataSource.addUnitToDatabase(unitEntity);
    }

    /**
     * Remove a <code>unitEntity</code> to the database (on the unit database)
     * @param url_api : a specific unit to remove
     * @return : job completed (a UnitEntity was remove)
     */
    public Completable deleteUnitToDatabaseWithId(String url_api){
        return unitLocalDataSource.deleteUnitToDatabaseWithId(url_api);
    }

    /**
     * Get a unit in database
     * @param url_api : a specific unit to get
     * @return : the specific unit
     */
    public UnitEntity getAUnit(String url_api) throws ExecutionException, InterruptedException {
        AsyncTask<String, Void, UnitEntity> get = new getAsyncTask(unitLocalDataSource).execute(url_api);
        return get.get();
    }

    private static class getAsyncTask extends AsyncTask<String, Void, UnitEntity> {
        private final UnitLocalDataSource mAsyncTaskDao;
        getAsyncTask(UnitLocalDataSource dao) {
            mAsyncTaskDao = dao;
        }
        @Override
        protected UnitEntity doInBackground(String... strings) {
            return mAsyncTaskDao.getAUnit(strings[0]);
        }
    }

    /**
     * Remote a specific unit using id or name
     * @param id : use to remote an unit
     * @return : the specific unit
     */
    public Single<Unit> searchAnUnit(String id){
        return unitRemoteDataSource.searchAnUnit(id);
    }
}
