package group8.tkgd.menurestaurantapp.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
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
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewOrderManagementAdapter;
import group8.tkgd.menurestaurantapp.adapter.CustomGridviewPaymentManagementAdapter;
import group8.tkgd.menurestaurantapp.model.Dish;

public class PaymentManagementActivity extends AppCompatActivity {

    List<Dish> dishes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_management);
        Toolbar toolbar = findViewById(R.id.toolbarPaymentManagement);
        toolbar.setTitle("Table " + getIntent().getStringExtra("tableID"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        GridView gridView = findViewById(R.id.gridViewPaymentManagement);

        dishes.clear();
        dishes.add(new Dish("Salmon Fish", 10, R.drawable.samon_fish, "Delicious salmon fish."));
        dishes.add(new Dish("Fried Squid", 15, R.drawable.fried_squid, "Delicious fried squid."));
        dishes.add(new Dish("Fried Chicken", 20, R.drawable.fried_chicken, "Delicious fried chicken."));
        dishes.add(new Dish("White Beer", 5, R.drawable.white_beer, "Fantastic white beer."));
        dishes.add(new Dish("Orange Wine", 8, R.drawable.orange_wine, "Fantastic orange wine."));

        CustomGridviewPaymentManagementAdapter customGridviewAdapter = new CustomGridviewPaymentManagementAdapter(this, R.layout.custom_payment_gridview, dishes);
        customGridviewAdapter.notifyDataSetChanged();
        gridView.setAdapter(customGridviewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplication(), dishes.get(position).getDescription(), Toast.LENGTH_SHORT).show();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fabPayment);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new AlertDialog.Builder(PaymentManagementActivity.this)
                        .setTitle("Confirmation")
                        .setMessage("Are you sure you want to pay?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(PaymentManagementActivity.this, "Pay Successfully!", Toast.LENGTH_SHORT).show();
                                PaymentManagementActivity.this.finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setIcon(R.drawable.ic_action_order_management)
                        .show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_payment_management,menu);
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
