package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.di.AoE2DecencyInjector;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.view.InfoCivilizationActivity;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.ActionOnHome;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.grill.CivilizationHomeGrillAdapter;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.list.CivilizationHomeListAdapter;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.mapper.CivilizationHomeItemViewModelToCivilizationEntity;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.FavoriteViewModel;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.HomeCivilizationsViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FragmentHomeCivilization extends Fragment implements ActionOnHome {
    public final static String name = "Home";
    private View rootView;
    private HomeCivilizationsViewModel civilizationsViewModel;
    private FavoriteViewModel favoriteViewModel;
    private boolean layoutManagerList;
    private CivilizationHomeListAdapter civilizationHomeListAdapter;
    private CivilizationHomeGrillAdapter civilizationHomeGrillAdapter;

    public static FragmentHomeCivilization getInstance() {
        return new FragmentHomeCivilization();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_home_civilizations, container, false);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layoutManagerList = true;
        initializationOfRecyclerView_HomeListAdapter();
        setupSwitch_List_Grill();
    }

    /**
     * setup the switch list to grid and vice versa
     */
    public void setupSwitch_List_Grill(){
        Switch switch_list_to_grille = rootView.findViewById(R.id.switch_list_to_grille);
        switch_list_to_grille.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(layoutManagerList) {
                    initializationOfRecyclerView_HomeGrillAdapter();
                    layoutManagerList = false;
                } else {
                    initializationOfRecyclerView_HomeListAdapter();
                    layoutManagerList = true;
                }
            }
        });
    }

    /**
     * initialize the recyclerview who contains the HomeListAdapter
     */
    public void initializationOfRecyclerView_HomeListAdapter() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_home);
        civilizationHomeListAdapter = new CivilizationHomeListAdapter(this);
        recyclerView.setAdapter(civilizationHomeListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        getAllCivilizationsOnViewList();
    }

    /**
     * displays civilizations as a list
     */
    private void getAllCivilizationsOnViewList() {
        civilizationsViewModel = new ViewModelProvider(requireActivity(), AoE2DecencyInjector.getViewModelFactory()).get(HomeCivilizationsViewModel.class);
        favoriteViewModel = new ViewModelProvider(requireActivity(), AoE2DecencyInjector.getViewModelFactory()).get(FavoriteViewModel.class);
        civilizationsViewModel.getAllCivilizations();
        civilizationsViewModel.getCivilizations().observe(getViewLifecycleOwner(), new Observer<List<CivilizationHomeItemViewModel>>() {
            @Override
            public void onChanged(List<CivilizationHomeItemViewModel> civilizationHomeItemViewModels) {
                civilizationHomeListAdapter.setListItemViewModels(civilizationHomeItemViewModels);
            }
        });
    }

    /**
     * initialize the recyclerview who contains the HomeGrillAdapter
     */
    public void initializationOfRecyclerView_HomeGrillAdapter() {
        RecyclerView recyclerView = rootView.findViewById(R.id.recycler_view_home);
        civilizationHomeGrillAdapter = new CivilizationHomeGrillAdapter(this);
        recyclerView.setAdapter(civilizationHomeGrillAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        getAllCivilizationsOnViewGrid();
    }

    /**
     * displays civilizations as a grid
     */
    private void getAllCivilizationsOnViewGrid() {
        civilizationsViewModel = new ViewModelProvider(requireActivity(), AoE2DecencyInjector.getViewModelFactory()).get(HomeCivilizationsViewModel.class);
        civilizationsViewModel.getAllCivilizations();
        civilizationsViewModel.getCivilizations().observe(getViewLifecycleOwner(), new Observer<List<CivilizationHomeItemViewModel>>() {
            @Override
            public void onChanged(List<CivilizationHomeItemViewModel> civilizationHomeItemViewModels) {
                civilizationHomeGrillAdapter.setListItemViewModels(civilizationHomeItemViewModels);
            }
        });

    }

    @Override
    public void onFavorite(CivilizationHomeItemViewModel item) {
        CivilizationHomeItemViewModelToCivilizationEntity civilizationHomeItemViewModelToCivilizationEntity = new CivilizationHomeItemViewModelToCivilizationEntity();
        CivilizationEntity civilizationEntity = civilizationHomeItemViewModelToCivilizationEntity.map(item);
        favoriteViewModel.addCivilizationToFavoriteDatabase(civilizationEntity);
    }

    @Override
    public void displayInformation(CivilizationHomeItemViewModel item) {
        CivilizationHomeItemViewModelToCivilizationEntity civilizationHomeItemViewModelToCivilizationEntity = new CivilizationHomeItemViewModelToCivilizationEntity();
        CivilizationEntity civilizationEntity = civilizationHomeItemViewModelToCivilizationEntity.map(item);
        Intent intent = new Intent(getActivity(), InfoCivilizationActivity.class);
        intent.putExtra("civilization",civilizationEntity);
        startActivity(intent);
    }
}
