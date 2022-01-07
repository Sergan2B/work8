package com.example.work8.ui.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.work8.R;
import com.example.work8.OnClickItem;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.DashboardViewHolder> {

    private ArrayList<DashboardModel> homeModels;
    private OnClickItem onClickItem;

    public void setOnClickItem(OnClickItem onClickItem) {
        this.onClickItem = onClickItem;
    }

    public DashboardAdapter(ArrayList<DashboardModel> homeModels) {
        this.homeModels = homeModels;
    }

    @NonNull
    @Override
    public DashboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DashboardViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dashboard, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardViewHolder holder, int position) {
        holder.onBind(homeModels.get(position));
        holder.itemView.setOnClickListener(view -> onClickItem.onClick(position));
    }

    @Override
    public int getItemCount() {
        return homeModels.size();
    }

    public DashboardModel getItem(int pos) {
        return homeModels.get(pos);
    }

    static class DashboardViewHolder extends RecyclerView.ViewHolder {

        private TextView tvStatus, tvName;
        private ImageView integer;

        public DashboardViewHolder(@NonNull View itemView) {
            super(itemView);
            integer = itemView.findViewById(R.id.imageView);
            tvStatus = itemView.findViewById(R.id.textView2);
            tvName = itemView.findViewById(R.id.textView);
        }

        public void onBind(com.example.work8.ui.dashboard.DashboardModel homeViewModel) {
            integer.setImageResource(homeViewModel.getIvInteger());
            tvStatus.setText(homeViewModel.getTvStatus());
            tvName.setText(homeViewModel.getTvName());
        }
    }
}
