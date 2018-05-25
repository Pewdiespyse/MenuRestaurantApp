package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import group8.tkgd.menurestaurantapp.R;

public class EmptyOrderCartActivity extends AppCompatActivity {
    Button btnOrderNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_order_cart);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarEmptyOrderCart);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnOrderNow = findViewById(R.id.btnOrderNow);
        btnOrderNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                Toast.makeText(getApplication(), "Press back to order", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
