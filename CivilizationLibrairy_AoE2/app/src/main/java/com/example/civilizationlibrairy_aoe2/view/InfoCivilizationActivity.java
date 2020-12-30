package com.example.civilizationlibrairy_aoe2.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.data.di.AoE2DecencyInjector;
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;
import com.example.civilizationlibrairy_aoe2.data.entity.UnitEntity;
import com.example.civilizationlibrairy_aoe2.view.viewmodel.HomeCivilizationsViewModel;

import java.util.concurrent.ExecutionException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

/**
 * an activity to show the civilization's information
 */
public class InfoCivilizationActivity extends AppCompatActivity {
    private CivilizationEntity civilizationEntity;
    private UnitEntity unitEntity;
    private ImageView img_civ;
    private TextView text_name;
    private TextView text_expansion;
    private TextView text_armyType;
    private TextView text_uniqueUnit;
    private TextView text_uniqueTech;
    private TextView text_teamBonus;
    private TextView text_civilizationBonus;
    private Button back_to_holdContext;
    private HomeCivilizationsViewModel civilizationsViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_civilization);
        Intent intent = getIntent();
        civilizationEntity = intent.getParcelableExtra("civilization");
        unitEntity = intent.getParcelableExtra("unit");
        civilizationsViewModel = new ViewModelProvider(this, AoE2DecencyInjector.getViewModelFactory()).get(HomeCivilizationsViewModel.class);
        if(unitEntity == null){
            unitEntity = new UnitEntity();
            String temp = civilizationEntity.getUnique_unit();
            String[] name_unity = temp.split("/");
            String request = name_unity[name_unity.length-1];
            try {
                civilizationsViewModel.getAUnit(civilizationEntity.getArmy_type()) ;
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            unitEntity = civilizationsViewModel.getUnit().getValue();
            civilizationsViewModel.addUnitToDatabase(unitEntity);
        }

        img_civ = findViewById(R.id.img_civ);
        text_name = findViewById(R.id.text_name);
        text_expansion = findViewById(R.id.text_expansion);
        text_armyType = findViewById(R.id.text_armyType);
        text_uniqueUnit = findViewById(R.id.text_uniqueUnit);
        text_uniqueTech = findViewById(R.id.text_uniqueTech);
        text_teamBonus = findViewById(R.id.text_teamBonus);
        text_civilizationBonus = findViewById(R.id.text_civilizationBonus);
        back_to_holdContext = findViewById(R.id.back_to_holdContext);

        Glide.with(this)
                .load(civilizationEntity.getUrl_picture())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(img_civ);
        text_name.setText(civilizationEntity.getName());
        text_expansion.setText(civilizationEntity.getExpansion());
        text_armyType.setText(civilizationEntity.getArmy_type());
        text_uniqueUnit.setText(civilizationEntity.getUnique_unit());
        text_uniqueTech.setText(civilizationEntity.getUnique_tech());
        text_teamBonus.setText(civilizationEntity.getTeam_bonus());
        text_civilizationBonus.setText(civilizationEntity.getCivilization_bonus());
        back_to_holdContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
