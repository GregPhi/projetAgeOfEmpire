package com.example.civilizationlibrairy_aoe2.data.db;


import com.example.civilizationlibrairy_aoe2.data.db.dao.CivilizationDao;
import com.example.civilizationlibrairy_aoe2.data.db.dao.TechnologyDao;
import com.example.civilizationlibrairy_aoe2.data.db.dao.UnitDao;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.data.entity.TechnologyEntity;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * class to make request on database
 */
@Database(entities = {CivilizationEntity.class, TechnologyEntity.class,UnitEntity.class}, version=1,exportSchema = false)
public abstract class ProjectDatabase extends RoomDatabase {
    public abstract CivilizationDao civilizationDao();
    public abstract TechnologyDao technologyDao();
    public abstract UnitDao unitDao();
}
