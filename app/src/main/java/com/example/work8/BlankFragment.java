package com.example.work8;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.work8.databinding.FragmentBlankBinding;
import com.example.work8.ui.dashboard.DashboardModel;
import com.example.work8.ui.home.HomeModel;

public class BlankFragment extends Fragment {

    private FragmentBlankBinding binding;
    private DashboardModel model;
    private HomeModel homeModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBlankBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            if (getArguments().getSerializable("model_key") != null) {
                model = (DashboardModel) getArguments().getSerializable("model_key");
                setData(model);
            }
            if (getArguments().getSerializable("Afrika_key") != null) {
                homeModel = (HomeModel) getArguments().getSerializable("Afrika_key");
                setData(homeModel);
            }
        }
    }

    private void setData(DashboardModel dashboardModel) {
        binding.tvName.setText(dashboardModel.getTvName());
        binding.tvStatus.setText(dashboardModel.getTvStatus());
        Glide.with(requireContext()).load(dashboardModel.getIvInteger()).into(binding.ivCharacter);
    }

    private void setData(HomeModel homeModel) {
        binding.tvStatus.setText(homeModel.getTvLocation());
        binding.tvName.setText(homeModel.getTvNameLocation());
        Glide.with(requireContext()).load(homeModel.getIvLocation()).into(binding.ivCharacter);
    }
}