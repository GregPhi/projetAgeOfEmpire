package com.example.civilizationlibrairy_aoe2.view.civilization.favorite.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.civilizationlibrairy_aoe2.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CivilizationFavoriteAdapter extends RecyclerView.Adapter<CivilizationFavoriteAdapter.CivilizationListViewHolder> {
    private final List<CivilizationFavoriteItemViewModel> listItemViewModels;
    private final ActionOnFavorite actionInterface;

    public CivilizationFavoriteAdapter(ActionOnFavorite actionInterface) {
        this.listItemViewModels = new ArrayList<>();
        this.actionInterface = actionInterface;
    }

    @NonNull
    @Override
    public CivilizationListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list_civilization_layout_favorite,parent,false);
        return new CivilizationListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CivilizationListViewHolder holder, int position) {
        holder.setupView(listItemViewModels.get(position));
    }

    @Override
    public int getItemCount() {
        return this.listItemViewModels.size();
    }

    /**
     * set list of favorites civilization to display
     * @param listItemViewModels : list of favorites civilization
     */
    public void setListItemViewModels(List<CivilizationFavoriteItemViewModel> listItemViewModels) {
        this.listItemViewModels.clear();
        this.listItemViewModels.addAll(listItemViewModels);
        notifyDataSetChanged();
    }

    /**
     * class representing a favorite civilization on the recycler_view
     */
    public class CivilizationListViewHolder extends RecyclerView.ViewHolder{
        private final ImageView img_civilization;
        private final TextView civilization_name;
        private final TextView civilization_expansion;
        private final TextView civilization_bonus;
        private final ImageButton info_of_civilization_from_fav;
        private final ImageButton delete_civilization_to_favorite;
        private final View v;
        private CivilizationFavoriteItemViewModel civilizationFavoriteItemViewModel;

        public CivilizationListViewHolder(@NonNull View itemView) {
            super(itemView);
            this.v = itemView;
            this.img_civilization = v.findViewById(R.id.img_civilization_fac);
            this.civilization_name = v.findViewById(R.id.civilization_name);
            this.civilization_expansion = v.findViewById(R.id.civilization_expansion);
            this.civilization_bonus = v.findViewById(R.id.civilization_bonus);
            this.info_of_civilization_from_fav = v.findViewById(R.id.info_of_civilization_from_fav);
            this.delete_civilization_to_favorite = v.findViewById(R.id.delete_civilization_to_favorite);
        }

        /**
         * setup the ImageButton
         * -> <code>info_of_civilization_from_fav</code> to display info
         * -> <code>delete_civilization_to_favorite</code> to delete this civilization of favorite
         */
        public void setUpImageButton(){
            this.info_of_civilization_from_fav.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionInterface.displayInformation(civilizationFavoriteItemViewModel);
                }
            });
            this.delete_civilization_to_favorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    actionInterface.onRemoveFavorite(civilizationFavoriteItemViewModel.getCivilization_id());
                }
            });
        }

        /**
         * setup the display
         * @param item : a civilization to display
         */
        public void setupView(CivilizationFavoriteItemViewModel item){
            this.civilizationFavoriteItemViewModel = item;
            Glide.with(v)
                    .load(civilizationFavoriteItemViewModel.getImg_civilization())
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(img_civilization);
            civilization_name.setText(civilizationFavoriteItemViewModel.getCivilization_name());
            civilization_expansion.setText(civilizationFavoriteItemViewModel.getCivilization_expansion());
            civilization_bonus.setText(civilizationFavoriteItemViewModel.getCivilization_bonus());
            setUpImageButton();
        }
    }
}
