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


//    private AppBarConfiguration mAppBarConfiguration;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//
//        setSupportActionBar(binding.appBarMain.toolbar);
//        if (binding.appBarMain.fab != null) {
//            binding.appBarMain.fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).setAnchorView(R.id.fab).show());
//        }
//        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_content_main);
//        assert navHostFragment != null;
//        NavController navController = navHostFragment.getNavController();
//
//        NavigationView navigationView = binding.navView;
//        if (navigationView != null) {
//            mAppBarConfiguration = new AppBarConfiguration.Builder(
//                    R.id.nav_transform, R.id.nav_reflow, R.id.nav_slideshow, R.id.nav_settings)
//                    .setOpenableLayout(binding.drawerLayout)
//                    .build();
//            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//            NavigationUI.setupWithNavController(navigationView, navController);
//        }
//
//        BottomNavigationView bottomNavigationView = binding.appBarMain.contentMain.bottomNavView;
//        if (bottomNavigationView != null) {
//            mAppBarConfiguration = new AppBarConfiguration.Builder(
//                    R.id.nav_transform, R.id.nav_reflow, R.id.nav_slideshow)
//                    .build();
//            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//            NavigationUI.setupWithNavController(bottomNavigationView, navController);
//        }
//
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        boolean result = super.onCreateOptionsMenu(menu);
//        // Using findViewById because NavigationView exists in different layout files
//        // between w600dp and w1240dp
//        NavigationView navView = findViewById(R.id.nav_view);
//        if (navView == null) {
//            // The navigation drawer already has the items including the items in the overflow menu
//            // We only inflate the overflow menu if the navigation drawer isn't visible
//            getMenuInflater().inflate(R.menu.overflow, menu);
//        }
//        return result;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.nav_settings) {
//            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//            navController.navigate(R.id.nav_settings);
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }
//
////    private void startScan() {
////        // Deschide activitatea de scanare
////        Intent scanIntent = new Intent(this, DocumentScanActivity.class);
////        startActivityForResult(scanIntent, SCAN_REQUEST_CODE);
////    }
//



}