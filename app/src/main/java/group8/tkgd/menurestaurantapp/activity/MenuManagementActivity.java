package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewMainMenuAdapter;
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewMenuManagementAdapter;
import group8.tkgd.menurestaurantapp.model.Dish;

public class MenuManagementActivity extends AppCompatActivity {

    List<Dish> dishes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_management);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMenuManagement);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridView gridView = findViewById(R.id.gridViewMenuManagement);

        dishes.clear();
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, 3, "Delicious salmon fish."));
        dishes.add(new Dish("Fried Squid", 15, R.drawable.fried_squid, 5, "Delicious fried squid."));
        dishes.add(new Dish("Fried Chicken", 20, R.drawable.fried_chicken, 5, "Delicious fried chicken."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, 4, "Fantastic white beer."));
        dishes.add(new Dish("Orange Wine", 8, R.drawable.orange_wine, 4, "Fantastic orange wine."));

        CustomGridviewMenuManagementAdapter customGridviewAdapter = new CustomGridviewMenuManagementAdapter(this, R.layout.custom_menu_gridview, dishes);
        customGridviewAdapter.notifyDataSetChanged();
        gridView.setAdapter(customGridviewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), dishes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuManagementActivity.this, DishDetailActivity.class);
                intent.putExtra("image", "" + dishes.get(position).getImage());
                intent.putExtra("name", "" + dishes.get(position).getName());
                intent.putExtra("price", "" + dishes.get(position).getPrice());
                intent.putExtra("description", "" + dishes.get(position).getDescription());
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabMenu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuManagementActivity.this, MenuAddDetailActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menu_management,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
