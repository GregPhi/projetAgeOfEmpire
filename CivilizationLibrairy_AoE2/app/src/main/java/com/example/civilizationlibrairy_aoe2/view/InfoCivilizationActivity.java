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
import com.example.civilizationlibrairy_aoe2.data.entity.CivilizationEntity;

import androidx.appcompat.app.AppCompatActivity;

/**
 * an activity to show the civilization's information
 */
public class InfoCivilizationActivity extends AppCompatActivity {
    private CivilizationEntity civilizationEntity;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_civilization);
        Intent intent = getIntent();
        civilizationEntity = intent.getParcelableExtra("civilization");

        ImageView img_civ = findViewById(R.id.img_civ);
        TextView text_name = findViewById(R.id.text_name);
        TextView text_expansion = findViewById(R.id.text_expansion);
        TextView text_armyType = findViewById(R.id.text_armyType);
        TextView text_uniqueTech = findViewById(R.id.text_uniqueTech);
        TextView text_teamBonus = findViewById(R.id.text_teamBonus);
        TextView text_civilizationBonus = findViewById(R.id.text_civilizationBonus);
        Button back_to_holdContext = findViewById(R.id.back_to_holdContext);

        Glide.with(this)
                .load(civilizationEntity.getUrl_picture())
                .centerCrop()
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(img_civ);
        text_name.setText(civilizationEntity.getName());
        text_expansion.setText(civilizationEntity.getExpansion());
        text_armyType.setText(civilizationEntity.getArmy_type());
        text_uniqueTech.setText(civilizationEntity.getUnique_tech());
        text_teamBonus.setText(civilizationEntity.getTeam_bonus());
        text_civilizationBonus.setText(civilizationEntity.getCivilization_bonus());

        setupUnique_unit();

        back_to_holdContext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    /**
     * setup the cardview_unit_in_info_civilization -> representing the unique unit
     */
    public void setupUnique_unit(){
        ImageView img_unit = findViewById(R.id.img_unit);
        TextView text_name_unit = findViewById(R.id.text_name_unit);
        String temp = civilizationEntity.getUnique_unit();
        if(temp!=null){
            String[] name_unity = temp.split("/");
            String name = name_unity[name_unity.length-1];
            String[] urls_unit = getResources().getStringArray(R.array.url_unit);
            String url = "";
            for(String u : urls_unit){
                String temp_name = name.replace("_","");
                if(u.toLowerCase().contains(temp_name.toLowerCase())){
                    url = u;
                }
            }
            System.out.println("URL :"+url);
            if(!url.equals("")){
                Glide.with(this)
                        .load(url)
                        .centerCrop()
                        .transition(DrawableTransitionOptions.withCrossFade())
                        .into(img_unit);
            }else{
                img_unit.setVisibility(View.INVISIBLE);
            }
            name = name.replaceAll("_"," ");
            text_name_unit.setText(name);
        }else{
            img_unit.setVisibility(View.INVISIBLE);
            text_name_unit.setText("N.C");
        }
    }
}
