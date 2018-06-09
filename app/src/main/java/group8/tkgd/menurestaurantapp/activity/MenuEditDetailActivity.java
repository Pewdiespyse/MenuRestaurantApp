package group8.tkgd.menurestaurantapp.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

import group8.tkgd.menurestaurantapp.R;
import group8.tkgd.menurestaurantapp.model.Dish;

public class MenuEditDetailActivity extends AppCompatActivity {

    private ImageView imageViewEdit;
    private EditText nameEdit;
    private TextView priceEdit;
    private EditText descriptionEdit;
    private Button addPrice;
    private Button subPrice;
    private Button editFood;
    private Button cancelFood;
    private int price = 1;

    private static final int PICK_IMAGE = 100;
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_edit_detail);

        imageViewEdit = findViewById(R.id.imageEdit);
        nameEdit = findViewById(R.id.editTextNameEdit);
        priceEdit = findViewById(R.id.titlePriceEdit);
        descriptionEdit = findViewById(R.id.editTextDescriptionEdit);
        addPrice = findViewById(R.id.btnAddPrice);
        subPrice = findViewById(R.id.btnSubPrice);
        editFood = findViewById(R.id.btnEditEdit);
        cancelFood = findViewById(R.id.btnCancelEdit);

        //Get information from editing item
        Dish dishEdit = new Dish(getIntent().getStringExtra("name"), Integer.parseInt(getIntent().getStringExtra("price")), Integer.parseInt(getIntent().getStringExtra("image")),Integer.parseInt(getIntent().getStringExtra("rate")),  getIntent().getStringExtra("description"));
        price = dishEdit.getPrice();

        nameEdit.setText(dishEdit.getName());
        priceEdit.setText("" + price);
        imageViewEdit.setImageResource(dishEdit.getImage());
        imageViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallery();
            }
        });
        descriptionEdit.setText(dishEdit.getDescription());

        addPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price++;
                priceEdit.setText("" + price);
            }
        });

        subPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price--;
                if (price < 1)
                    price = 1;
                priceEdit.setText("" + price);
            }
        });

        editFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuEditDetailActivity.this, "Edit successfully!", Toast.LENGTH_SHORT).show();
                MenuEditDetailActivity.this.finish();
            }
        });

        cancelFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuEditDetailActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                MenuEditDetailActivity.this.finish();
            }
        });
    }

    public void selectImageFromGallery() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = decodeUri(selectedImage);
                        imageViewEdit.setImageBitmap(bitmap);

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }

    }

    private Bitmap decodeUri(Uri selectedImage) throws FileNotFoundException {
        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o);
        // The new size we want to scale to
        final int REQUIRED_SIZE = 960;
        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp / 2 < REQUIRED_SIZE
                    || height_tmp / 2 < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }
        // Decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        return BitmapFactory.decodeStream(getContentResolver().openInputStream(selectedImage), null, o2);
    }
}
