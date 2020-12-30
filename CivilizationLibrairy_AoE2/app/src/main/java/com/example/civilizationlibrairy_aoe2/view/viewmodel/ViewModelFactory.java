package com.example.civilizationlibrairy_aoe2.view.viewmodel;

import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;
import com.example.civilizationlibrairy_aoe2.data.repository.unit.UnitRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final CivilizationRepository civilizationRepository;
    private final UnitRepository unitRepository;
    private final List<String> urls_civilization;
    private final List<String> urls_units;

    public ViewModelFactory(CivilizationRepository civilizationRepository, UnitRepository unitRepository, List<String> urlC, List<String> urlU) {
        this.civilizationRepository = civilizationRepository;
        this.unitRepository = unitRepository;
        this.urls_civilization = urlC;
        this.urls_units = urlU;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(FavoriteViewModel.class)){
            return (T) new FavoriteViewModel(civilizationRepository, unitRepository);
        }
        if(modelClass.isAssignableFrom(HomeCivilizationsViewModel.class)){
            return (T) new HomeCivilizationsViewModel(civilizationRepository, unitRepository,urls_civilization,urls_units);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
