package com.devcreature.moderndashboard.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.devcreature.moderndashboard.R;
import com.devcreature.moderndashboard.model.MenuModel;

import java.util.ArrayList;

public class MenuAdapter extends
        RecyclerView.Adapter<MenuAdapter.MenuGrid> {

    private ArrayList<MenuModel> menuModels;

    public MenuAdapter(ArrayList<MenuModel> menuModels) {
        this.menuModels = menuModels;
    }

    @NonNull
    @Override
    public MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuGrid holder, int position) {
        holder.sefDataMenu(menuModels.get(position));
    }

    @Override
    public int getItemCount() {
        if (menuModels != null) return menuModels.size();
        else return 0;
    }

    class MenuGrid extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private ImageView ivPhoto;


        MenuGrid(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView);
            ivPhoto = itemView.findViewById(R.id.imageView);
        }

        void sefDataMenu(MenuModel menuModel){
            tvTitle.setText(menuModel.getName());
            ivPhoto.setImageResource(menuModel.getImage());
            ivPhoto.setBackgroundResource(menuModel.getColor());
        }
    }
}
