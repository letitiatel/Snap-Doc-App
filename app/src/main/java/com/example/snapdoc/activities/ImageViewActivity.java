package com.example.snapdoc.activities;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.snapdoc.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageIv;
    private String imageUri; // Change to String
    private static final String TAG = "IMAGE_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        getSupportActionBar().setTitle("ImageView");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        imageIv = findViewById(R.id.imageIv);

        // Get image URI from intent
        imageUri = getIntent().getStringExtra("imageUri");
        Log.d(TAG, "onCreate: Image: " + imageUri);

        // Load image using Glide
        Glide.with(this)
                .load(imageUri)
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
        finish(); // Close current activity and go back to the parent activity
        return true;
    }

    private void showLargeImage() {
        // Create a custom dialog to display the image in a larger size
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_large_image);

        // Initialize the ImageView inside the dialog
        ImageView largeImageView = dialog.findViewById(R.id.largeImageView);

        // Load the large image using Glide
        Glide.with(this)
                .load(imageUri)
                .placeholder(R.drawable.ic_image_black)
                .into(largeImageView);

        // Enable the dialog to close when touching outside of it
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);

        // Show the dialog
        dialog.show();
    }
}
