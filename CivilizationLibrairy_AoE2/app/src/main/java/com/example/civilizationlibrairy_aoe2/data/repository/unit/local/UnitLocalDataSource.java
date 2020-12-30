package com.example.civilizationlibrairy_aoe2.data.repository.unit.local;

import com.example.civilizationlibrairy_aoe2.data.db.ProjectDatabase;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;

public class UnitLocalDataSource {
    private final ProjectDatabase projectDatabase;

    public UnitLocalDataSource(ProjectDatabase database) {
        this.projectDatabase = database;
    }

    /**
     * Add a <code>unitEntity</code> to the database (on the unit database)
     * @param unitEntity : a specific unit to add
     */
    public void addUnitToDatabase(UnitEntity unitEntity){
        projectDatabase.unitDao().addUnitToDatabase(unitEntity);
    }

    /**
     * Remove a <code>unitEntity</code> to the database (on the unit database)
     * @param url_api : a specific unit to remove
     */
    public void deleteUnitToDatabaseWithId(String url_api){
        projectDatabase.unitDao().deleteUnitToDatabaseWithId(url_api);
    }

    /**
     * Get a unit in database
     * @param url_api : a specific unit to get
     * @return the specific unit
     */
    public UnitEntity getAUnit(String url_api){
        return projectDatabase.unitDao().getAUnit(url_api);
    }
}
