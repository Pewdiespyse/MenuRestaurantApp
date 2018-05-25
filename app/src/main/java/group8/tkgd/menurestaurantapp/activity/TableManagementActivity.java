package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
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
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewMenuManagementAdapter;
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewTableManagementAdapter;
import group8.tkgd.menurestaurantapp.model.Dish;
import group8.tkgd.menurestaurantapp.model.Table;

public class TableManagementActivity extends AppCompatActivity {
    List<Table> tables = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_management);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarTableManagement);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridView gridView = findViewById(R.id.gridViewTableManagement);

        tables.clear();
        tables.add(new Table(1, "Serving"));
        tables.add(new Table(2, "Serving"));
        tables.add(new Table(3, "Available"));
        tables.add(new Table(4, "Available"));
        tables.add(new Table(5, "Available"));
        tables.add(new Table(6, "Available"));
        tables.add(new Table(7, "Serving"));
        tables.add(new Table(8, "Available"));
        tables.add(new Table(9, "Serving"));
        tables.add(new Table(10, "Serving"));
        tables.add(new Table(11, "Serving"));
        tables.add(new Table(12, "Available"));
        tables.add(new Table(13, "Available"));
        tables.add(new Table(14, "Available"));
        tables.add(new Table(15, "Serving"));
        tables.add(new Table(16, "Serving"));
        tables.add(new Table(17, "Serving"));
        tables.add(new Table(18, "Available"));
        tables.add(new Table(19, "Available"));
        tables.add(new Table(20, "Available"));
        tables.add(new Table(21, "Serving"));
        tables.add(new Table(22, "Serving"));
        tables.add(new Table(23, "Serving"));
        tables.add(new Table(24, "Available"));

        CustomGridviewTableManagementAdapter customGridviewAdapter = new CustomGridviewTableManagementAdapter(this, R.layout.custom_table_gridview, tables);
        customGridviewAdapter.notifyDataSetChanged();
        gridView.setAdapter(customGridviewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                Toast.makeText(getApplication(), "Table " + tables.get(position).getNumber() + " is " + tables.get(position).getStatus().toLowerCase(), Toast.LENGTH_SHORT).show();
                if (tables.get(position).getStatus() == "Serving") {
                    intent = new Intent(TableManagementActivity.this, OrderManagementActivity.class);
                }
                else if (tables.get(position).getStatus() == "Available") {
                    intent = new Intent(TableManagementActivity.this, EmptyOrderCartActivity.class);
                }

                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_table_managemet,menu);
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
