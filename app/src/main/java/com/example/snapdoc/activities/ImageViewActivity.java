package com.example.snapdoc.activities;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.example.snapdoc.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageIv;
    private String image;

    private static final String TAG = "IMAGE_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        getSupportActionBar().setTitle("ImageView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageIv = findViewById(R.id.imageIv);

        image = getIntent().getStringExtra("imageUri");
        Log.d(TAG, "onCreate: Image: "+image);

        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_image_black)
                .into(imageIv);

        imageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLargeImage();
            }
        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Termină activitatea curentă și revine la activitatea părinte (dacă există)
        return true;
    }



    private void showLargeImage() {
        // Crează un dialog personalizat pentru afișarea imaginii într-o mărime mai mare
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_large_image);

        // Inițializează ImageView-ul din interiorul dialogului
        ImageView largeImageView = dialog.findViewById(R.id.largeImageView);

        // Încarcă imaginea mare folosind Glide sau altă bibliotecă de gestionare a imaginilor
        Glide.with(this)
                .load(image)
                .placeholder(R.drawable.ic_image_black) // Placeholder în timpul încărcării
                .into(largeImageView);

        // Activează funcția de închidere a dialogului la apăsarea butonului de închidere sau în afara dialogului
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        // Arată dialogul
        dialog.show();
    }

}