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

public class BeerFragment extends Fragment {
    List<Dish> dishes = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beer, container, false);
        GridView gridView = view.findViewById(R.id.gridViewBeer);

        dishes.clear();
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));

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
                intent.putExtra("description", "" + dishes.get(position).getDescription());
                startActivity(intent);

            }
        });
        return view;
    }
}
