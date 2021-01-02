package com.example.civilizationlibrairy_aoe2.view;

import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.fragment.FragmentFavoriteCivilization;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.fragment.FragmentHomeCivilization;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Use to choose the good fragment to display
 */
public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NotNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 1){
            return FragmentFavoriteCivilization.getInstance();
        }
        return FragmentHomeCivilization.getInstance();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
