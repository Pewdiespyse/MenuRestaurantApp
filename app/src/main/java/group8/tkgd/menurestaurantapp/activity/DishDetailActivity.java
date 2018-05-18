package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.model.Dish;

public class DishDetailActivity extends AppCompatActivity {

    private ImageView imageDish;
    private TextView nameDish;
    private TextView priceDish;
    private TextView descriptionDish;
    private TextView countOfDish;
    private EditText noteOfDish;
    private Button btnAdd;
    private Button btnSub;
    private Button btnOrder;
    private Button btnCancel;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_detail);

        imageDish = findViewById(R.id.imageDishDetail);
        nameDish = findViewById(R.id.titleDishDetail);
        priceDish = findViewById(R.id.titlePriceDetail);
        descriptionDish = findViewById(R.id.titleDescriptionDetail);
        countOfDish = findViewById(R.id.titleCountOfDishDetail);
        noteOfDish = findViewById(R.id.editTextNoteDetail);
        btnAdd = findViewById(R.id.btnAddDetail);
        btnSub = findViewById(R.id.btnSubDetail);
        btnOrder = findViewById(R.id.btnOrderDetailDish);
        btnCancel = findViewById(R.id.btnCancelDetailDish);

        Dish dishDetail = new Dish(getIntent().getStringExtra("name"), Integer.parseInt(getIntent().getStringExtra("price")), Integer.parseInt(getIntent().getStringExtra("image")), getIntent().getStringExtra("description"));

        imageDish.setImageResource(dishDetail.getImage());
        nameDish.setText(dishDetail.getName());
        priceDish.setText(""+dishDetail.getPrice()+"$");
        descriptionDish.setText(dishDetail.getDescription());
        countOfDish.setText("" + count);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                countOfDish.setText("" + count);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count--;
                if (count < 1)
                    count = 1;
                countOfDish.setText("" + count);
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Order successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DishDetailActivity.this, MainMenuActivity.class);
                DishDetailActivity.this.finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplication(), "Cancel", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DishDetailActivity.this, MainMenuActivity.class);
                DishDetailActivity.this.finish();
            }
        });
    }
}
