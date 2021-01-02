package com.example.civilizationlibrairy_aoe2.data.db;


import com.example.civilizationlibrairy_aoe2.data.db.dao.CivilizationDao;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * class to make request on database
 */
@Database(entities = {CivilizationEntity.class}, version=1,exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {
    public abstract CivilizationDao civilizationDao();
}
