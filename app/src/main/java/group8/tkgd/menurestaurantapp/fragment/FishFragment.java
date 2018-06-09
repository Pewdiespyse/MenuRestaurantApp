package group8.tkgd.menurestaurantapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import group8.tkgd.menurestaurantapp.activity.DishDetailActivity;
import group8.tkgd.menurestaurantapp.model.Dish;
import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewMainMenuAdapter;

public class FishFragment extends Fragment {

    List<Dish> dishes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fish, container, false);
        GridView gridView = view.findViewById(R.id.gridViewFish);

        dishes.clear();
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));

        CustomGridviewMainMenuAdapter customGridviewAdapter = new CustomGridviewMainMenuAdapter(getActivity(), R.layout.custom_layout_gridview, dishes);
        customGridviewAdapter.notifyDataSetChanged();
        gridView.setAdapter(customGridviewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), dishes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DishDetailActivity.class);
                intent.putExtra("image", "" + dishes.get(position).getImage());
                intent.putExtra("name", "" + dishes.get(position).getName());
                intent.putExtra("price", ""+dishes.get(position).getPrice());
                intent.putExtra("rate", "" + dishes.get(position).getRate());
                intent.putExtra("description", "" + dishes.get(position).getDescription());
                startActivity(intent);

            }
        });
        return view;
    }
}
