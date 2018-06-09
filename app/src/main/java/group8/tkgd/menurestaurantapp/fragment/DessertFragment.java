package group8.tkgd.menurestaurantapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import java.util.ArrayList;
import java.util.List;

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.activity.MenuManagementActivity;
import group8.tkgd.menurestaurantapp.model.Dish;


public class DessertFragment extends Fragment {
    List<Dish> dishes = new ArrayList<>();
    Button btnAddDish;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dessert, container, false);
        btnAddDish = view.findViewById(R.id.btnAddDish);
        btnAddDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MenuManagementActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
