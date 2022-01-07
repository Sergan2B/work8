package com.example.work8.ui.home;

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

import com.example.work8.OnClickItem;
import com.example.work8.R;
import com.example.work8.databinding.FragmentHomeBinding;
import com.example.work8.ui.dashboard.DashboardModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnClickItem {

    private FragmentHomeBinding binding;
    private HomeAdapter homeAdapter;
    private ArrayList<HomeModel> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadData();
        homeAdapter = new HomeAdapter(list, this);
        binding.rvHome.setAdapter(homeAdapter);
    }

    private void loadData() {
        list.add(new HomeModel(R.drawable.img_4,"Cluster", "Abadango"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Earth (C-137)"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Worldender's lair"));
        list.add(new HomeModel(R.drawable.img_4,"Space station", "Citadel of Ticks"));
        list.add(new HomeModel(R.drawable.img_4,"TV", "Interdimensional Cable"));
        list.add(new HomeModel(R.drawable.img_4,"Microverse", "Anatomy Park"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Post-Apocalyptic"));
        list.add(new HomeModel(R.drawable.img_4,"Resort", "Immortality Field Resort"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Venzenulon 7"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Purge Planet"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Cronenberg Earth"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Bepis 9"));
        list.add(new HomeModel(R.drawable.img_4,"Fantasy town", "Giant's Town"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Nuptia 4"));
        list.add(new HomeModel(R.drawable.img_4,"Space station", "St. Gloopy Noops Hospital"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Bird World"));
        list.add(new HomeModel(R.drawable.img_4,"Dream", "Mr. Goldenfold's dream"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Earth (5-126)"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Earth (Rpl. Dimension"));
        list.add(new HomeModel(R.drawable.img_4,"Planet", "Gromflom Prime"));

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(int pos) {
        HomeModel model = homeAdapter.getItem(pos);
        Toast.makeText(getActivity(), "Click" + pos, Toast.LENGTH_SHORT).show();
        Bundle bundle = new Bundle();
        bundle.putSerializable("Afrika_key", model);
        NavController controller = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_activity_main);
        controller.navigate(R.id.blankFragment, bundle);
    }
}