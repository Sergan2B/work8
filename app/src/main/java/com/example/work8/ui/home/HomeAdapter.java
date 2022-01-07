package com.example.work8.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.work8.R;
import com.example.work8.OnClickItem;
import com.example.work8.ui.dashboard.DashboardModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private ArrayList<HomeModel> homeModels;
    private OnClickItem onClickItem;

    public HomeAdapter(ArrayList<HomeModel> homeModels, OnClickItem onClickItem) {
        this.homeModels = homeModels;
        this.onClickItem = onClickItem;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(homeModels.get(position));
        holder.itemView.setOnClickListener(view -> onClickItem.onClick(position));
    }

    @Override
    public int getItemCount() {
        return homeModels.size();
    }

    public HomeModel getItem(int pos) {
        return homeModels.get(pos);
    }

    static class HomeViewHolder extends RecyclerView.ViewHolder {

        private TextView tvLocation, tvNameLocation;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLocation = itemView.findViewById(R.id.location);
            tvNameLocation = itemView.findViewById(R.id.name_location);
        }

        public void onBind(HomeModel homeViewModel) {
            tvLocation.setText(homeViewModel.getTvLocation());
            tvNameLocation.setText(homeViewModel.getTvNameLocation());
        }
    }
}
