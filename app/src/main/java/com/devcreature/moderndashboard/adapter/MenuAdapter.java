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
    private OnClickListener onClickListener;

    public MenuAdapter(ArrayList<MenuModel> menuModels, OnClickListener onClickListener) {
        this.menuModels = menuModels;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public MenuGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MenuGrid(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false), onClickListener);
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

    class MenuGrid extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvTitle;
        private ImageView ivPhoto;
        private OnClickListener onClickListener;

        MenuGrid(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.textView);
            ivPhoto = itemView.findViewById(R.id.imageView);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }

        void sefDataMenu(MenuModel menuModel){
            tvTitle.setText(menuModel.getName());
            ivPhoto.setImageResource(menuModel.getImage());
            ivPhoto.setBackgroundResource(menuModel.getColor());
        }

        @Override
        public void onClick(View v) {
            onClickListener.onItemClickListener(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onItemClickListener(int position);
    }
}
