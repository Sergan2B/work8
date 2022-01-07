package com.example.work8.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.work8.R;
import com.example.work8.databinding.FragmentDashboardBinding;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardAdapter dashboardAdapter;
    private ArrayList<DashboardModel> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        dashboardAdapter = new DashboardAdapter(list);
        binding.recDashboard.setAdapter(dashboardAdapter);
        dashboardAdapter.setOnClickItem(pos -> onClick(pos));
    }

    private void loadData() {
        list.add(new DashboardModel("Alive", "Rick Sanchez", R.drawable.img));
        list.add(new DashboardModel("Alive", "Morty Smith", R.drawable.img_1));
        list.add(new DashboardModel("Dead", "Albert Einstein", R.drawable.img_2));
        list.add(new DashboardModel("Alive", "Jerry Smith", R.drawable.img_3));
    }


    public void onClick(int pos) {
        Toast.makeText(getActivity(), "Click " + pos, Toast.LENGTH_LONG).show();
/*
        Intent intent = new Intent();
        intent.putExtra("Africa14", pos);
*/
        DashboardModel model = dashboardAdapter.getItem(pos);
        Bundle bundle = new Bundle();
        bundle.putSerializable("model_key", model);
        NavController controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        controller.navigate(R.id.blankFragment, bundle);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}