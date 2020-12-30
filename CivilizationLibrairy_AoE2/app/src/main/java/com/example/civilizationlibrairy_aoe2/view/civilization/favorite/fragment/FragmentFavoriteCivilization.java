package com.example.civilizationlibrairy_aoe2.view.civilization.favorite.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.di.AoE2DecencyInjector;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.view.InfoCivilizationActivity;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter.ActionOnFavorite;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter.CivilizationFavoriteAdapter;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter.CivilizationFavoriteItemViewModel;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.mapper.CivilizationEntityToCivilizationFavoriteItemView;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.Event;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.FavoriteViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentFavoriteCivilization extends Fragment implements ActionOnFavorite {
    public final static String name = "Favorite";
    private View rootView;
    RecyclerView recyclerView;
    private CivilizationFavoriteAdapter civilizationFavoriteAdapter;
    RecyclerView.LayoutManager layoutManager;
    private FavoriteViewModel favoriteViewModel;

    public static FragmentFavoriteCivilization getInstance(){
        return new FragmentFavoriteCivilization();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup group, Bundle savedInstanceState){
        super.onCreateView(inflater,group,savedInstanceState);
        this.rootView = inflater.inflate(R.layout.fragment_favorites_civilizations,group,false);
        return this.rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        setRecyclerView();
    }

    /**
     * setup the recyclerview
     */
    public void setRecyclerView(){
        this.recyclerView = rootView.findViewById(R.id.recyclerview_favorite);
        this.layoutManager = new LinearLayoutManager(getContext());

        this.civilizationFavoriteAdapter = new CivilizationFavoriteAdapter(this);

        this.recyclerView.setAdapter(this.civilizationFavoriteAdapter);
        this.recyclerView.setLayoutManager(this.layoutManager);

        setFavoriteInRecyclerView();
    }

    /**
     * display favorites civilizations on recyclerview
     */
    public void setFavoriteInRecyclerView(){
        favoriteViewModel = new ViewModelProvider(requireActivity(), AoE2DecencyInjector.getViewModelFactory()).get(FavoriteViewModel.class);
        favoriteViewModel.getFavoritesCivilizations().observe(getViewLifecycleOwner(), new Observer<List<CivilizationFavoriteItemViewModel>>() {
            @Override
            public void onChanged(List<CivilizationFavoriteItemViewModel> civilizationFavoriteItemViewModels) {
                civilizationFavoriteAdapter.setListItemViewModels(civilizationFavoriteItemViewModels);
            }
        });

        favoriteViewModel.getCivAdd().observe(getViewLifecycleOwner(), new Observer<Event<String>>() {
            @Override
            public void onChanged(Event<String> stringEvent) {
                //Do nothing
            }
        });

        favoriteViewModel.getCivRem().observe(getViewLifecycleOwner(), new Observer<Event<String>>() {
            @Override
            public void onChanged(Event<String> stringEvent) {
                //Do nothing
            }
        });
    }

    @Override
    public void onRemoveFavorite(String id) {
        favoriteViewModel.removeCivilizationToFavoriteDatabase(id);
    }

    @Override
    public void displayInformation(CivilizationFavoriteItemViewModel item) {
        CivilizationEntityToCivilizationFavoriteItemView civilizationEntityToCivilizationFavoriteItemView = new CivilizationEntityToCivilizationFavoriteItemView();
        CivilizationEntity civilizationEntity = civilizationEntityToCivilizationFavoriteItemView.reverseMap(item);
        Intent intent = new Intent(getActivity(), InfoCivilizationActivity.class);
        intent.putExtra("civilization",civilizationEntity);
        startActivity(intent);
    }
}
