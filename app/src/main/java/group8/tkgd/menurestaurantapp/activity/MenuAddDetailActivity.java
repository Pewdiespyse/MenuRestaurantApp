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

public class MenuAddDetailActivity extends AppCompatActivity {

    private ImageView imageViewAdd;
    private EditText nameAdd;
    private TextView priceAdd;
    private EditText descriptionAdd;
    private Button addPrice;
    private Button subPrice;
    private Button addFood;
    private Button cancelFood;
    private int price = 0;

    private static final int PICK_IMAGE = 100;
    private Bitmap bitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_add_detail);

        imageViewAdd = findViewById(R.id.imageAdd);
        nameAdd = findViewById(R.id.editTextNameAdd);
        priceAdd = findViewById(R.id.titlePriceAdd);
        descriptionAdd = findViewById(R.id.editTextDescriptionAdd);
        addPrice = findViewById(R.id.btnAddPrice);
        subPrice = findViewById(R.id.btnSubPrice);
        addFood = findViewById(R.id.btnAddAdd);
        cancelFood = findViewById(R.id.btnCancelAdd);

        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImageFromGallery();
            }
        });

        addPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price++;
                priceAdd.setText("" + price);
            }
        });

        subPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price--;
                if (price < 0)
                    price = 0;
                priceAdd.setText("" + price);
            }
        });

        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuAddDetailActivity.this, "Add successfully!", Toast.LENGTH_SHORT).show();
                MenuAddDetailActivity.this.finish();
            }
        });

        cancelFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuAddDetailActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                MenuAddDetailActivity.this.finish();
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
                        imageViewAdd.setImageBitmap(bitmap);

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
