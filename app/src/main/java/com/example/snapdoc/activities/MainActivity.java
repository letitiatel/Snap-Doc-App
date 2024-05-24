package com.example.snapdoc.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.snapdoc.ImageListFragment;
import com.example.snapdoc.PdfListFragment;
import com.example.snapdoc.R;
import com.example.snapdoc.ui.TextViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.appcompat.app.AppCompatActivity;

//import com.example.snapdoc.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        /** ImageView backgroundImageView = findViewById(R.id.backgroundImageView);

        String imageUrl = "https://img.freepik.com/free-vector/abstract-purple-red-gradient-blur-background-vector_53876-174826.jpg?w=360&t=st=1716312313~exp=1716312913~hmac=1744502fd05bbe1f6cd1b5e5dddbf4b7d31043c9a7e0fe00408c0baa4daded2d"; // Replace with your image URL
        Glide.with(this)
                .load(imageUrl)
                .into(backgroundImageView); **/

        /**WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/index.html");**/



        loadImagesFragment();
        loadPdfsFragment();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if(itemId == R.id.bottom_menu_images){
                    loadImagesFragment();
                }
                else if (itemId == R.id.bottom_menu_pdfs){
                    loadPdfsFragment();
                } else if (itemId == R.id.bottom_menu_text) {
                    loadTextFragment();

                }

                return true;
            }
        });
    }



    private void loadPdfsFragment() {
        setTitle("PDF List");
        PdfListFragment pdfListFragment = new PdfListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, pdfListFragment, "PdfListFragment");
        fragmentTransaction.commit();
    }

    private void loadImagesFragment() {
        setTitle("Images");
        ImageListFragment imageListFragment = new ImageListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, imageListFragment, "ImageListFragment");
        fragmentTransaction.commit();
    }

    private void loadTextFragment() {
        setTitle("Text");
        TextViewFragment textViewFragment = new TextViewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, textViewFragment, "TextViewFragment");
        fragmentTransaction.commit();
    }



}