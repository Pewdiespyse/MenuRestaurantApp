package group8.tkgd.menurestaurantapp.activity;

import android.content.Context;
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
        toolbar.setTitle("Table " + getIntent().getStringExtra("tableID"));
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
                Intent intent = new Intent(EmptyOrderCartActivity.this, MainMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
