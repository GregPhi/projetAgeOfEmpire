package com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.grill;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.civilizationlibrairy_aoe2.R;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.ActionOnHome;
import com.example.civilizationlibrairy_aoe2.view.civilization.home_all.adapter.CivilizationHomeItemViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CivilizationHomeGrillAdapter extends RecyclerView.Adapter<CivilizationHomeGrillAdapter.CivilizationGridViewHolder> {
    private final List<CivilizationHomeItemViewModel> listItemViewModels;
    private final ActionOnHome actionOnHome;

    public CivilizationHomeGrillAdapter(ActionOnHome action) {
            this.listItemViewModels = new ArrayList<>();
            this.actionOnHome = action;
    }

    @NonNull
    @Override
    public CivilizationGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_civilization_layout_home,parent,false);
        return new CivilizationGridViewHolder(view, this.actionOnHome);
    }

    @Override
    public void onBindViewHolder(@NonNull CivilizationGridViewHolder holder, int position) {
        holder.setupView(listItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listItemViewModels.size();
    }

    /**
     * set list of civilization to display
     * @param listItemViewModels : list of civilization
     */
    public void setListItemViewModels(List<CivilizationHomeItemViewModel> listItemViewModels) {
        this.listItemViewModels.clear();
        this.listItemViewModels.addAll(listItemViewModels);
        notifyDataSetChanged();
    }

    /**
     * class representing a civilization on the recycler_view on GRID
     */
    public static class CivilizationGridViewHolder extends RecyclerView.ViewHolder{
        private final TextView civilization_name;
        private final ImageButton img_civilization;
        private final ImageButton info_of_civilization_from_home;
        private final ImageButton add_civilization_to_favorite;
        private final View v;
        private CivilizationHomeItemViewModel civilizationHomeItemViewModel;
        private final ActionOnHome actionOnHome;

        public CivilizationGridViewHolder(@NonNull View itemView,ActionOnHome action) {
            super(itemView);
            this.actionOnHome = action;
            this.v = itemView;
            this.img_civilization = v.findViewById(R.id.cardview_list_civilization_layout_home);
            this.civilization_name = v.findViewById(R.id.civilization_name);
            this.info_of_civilization_from_home = v.findViewById(R.id.info_of_civilization_from_home);
            this.add_civilization_to_favorite = v.findViewById(R.id.add_civilization_to_favorite);
        }

        /**
         * setup ImageButton
         * -> <code>info_of_civilization_from_home</code> to display info
         * -> <code>add_civilization_to_favorite</code> to add this civilization on favorite
         */
        public void setUpImageButton(){
            this.info_of_civilization_from_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionOnHome.displayInformation(civilizationHomeItemViewModel);
                }
            });
            this.add_civilization_to_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionOnHome.onFavorite(civilizationHomeItemViewModel);
                }
            });
        }

        /**
         * setup the display
         * @param item : a civilization to display
         */
        public void setupView(CivilizationHomeItemViewModel item){
            this.civilizationHomeItemViewModel = item;
            Glide.with(v)
                    .load(item.getImg_civilization())
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(img_civilization);
            civilization_name.setText(civilizationHomeItemViewModel.getCivilization_name());
            setUpImageButton();
        }
    }
}
