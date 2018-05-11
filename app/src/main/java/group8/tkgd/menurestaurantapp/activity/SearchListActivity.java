package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.SearchView;
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
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewAdapter;
import group8.tkgd.menurestaurantapp.model.Dish;

public class SearchListActivity extends AppCompatActivity {
    List<Dish> dishes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarSearchList);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridView gridView = findViewById(R.id.gridViewSearchList);

        dishes.clear();
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, "Delicious salmon fish."));
        dishes.add(new Dish("Fried Squid", 15, R.drawable.fried_squid, "Delicious fried squid."));
        dishes.add(new Dish("Fried Chicken", 20, R.drawable.fried_chicken, "Delicious fried chicken."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("Orange Wine", 8, R.drawable.orange_wine, "Fantastic orange wine."));

        CustomGridviewAdapter customGridviewAdapter = new CustomGridviewAdapter(this, R.layout.custom_search_gridview, dishes);
        customGridviewAdapter.notifyDataSetChanged();
        gridView.setAdapter(customGridviewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), dishes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SearchListActivity.this, DishDetailActivity.class);
                intent.putExtra("image", "" + dishes.get(position).getImage());
                intent.putExtra("name", "" + dishes.get(position).getName());
                intent.putExtra("price", "" + dishes.get(position).getPrice());
                intent.putExtra("description", "" + dishes.get(position).getDescription());
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search_list,menu);
        MenuItem itemSearch = menu.findItem(R.id.item_action_search_list);
        SearchView searchView = (SearchView) itemSearch.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchListActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
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