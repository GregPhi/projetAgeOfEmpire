package com.example.civilizationlibrairy_aoe2.view;

import android.os.Bundle;

import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.di.AoE2DecencyInjector;
import com.example.civilizationlibrairy_aoe2.view.civilization.favorite.fragment.FragmentFavoriteCivilization;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.fragment.FragmentHomeCivilization;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

/**
 * the main activity of this application
 */
public class CivilizationActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private TabLayout tabLayout;
    private final String[] tabTitles = new String[]{FragmentHomeCivilization.name, FragmentFavoriteCivilization.name};

    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        AoE2DecencyInjector.setContext(this);
        setupViewPager();
    }

    /**
     * setup the view pager -> what fragment to display
     */
    public void setupViewPager() {
        viewPager = findViewById(R.id.fragments_viewpager);
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.frag_tab);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(tabTitles[position]);
                    }
                }).attach();
    }
}
