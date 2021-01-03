package com.example.civilizationlibrairy_aoe2.view.viewmodel;

import com.example.civilizationlibrairy_aoe2.data.repository.civilization.CivilizationRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final CivilizationRepository civilizationRepository;
    private final List<String> urls_civilization;

    public ViewModelFactory(CivilizationRepository civilizationRepository, List<String> urlC) {
        this.civilizationRepository = civilizationRepository;
        this.urls_civilization = urlC;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass.isAssignableFrom(FavoriteViewModel.class)){
            return (T) new FavoriteViewModel(civilizationRepository);
        }
        if(modelClass.isAssignableFrom(HomeCivilizationsViewModel.class)){
            return (T) new HomeCivilizationsViewModel(civilizationRepository,urls_civilization);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
