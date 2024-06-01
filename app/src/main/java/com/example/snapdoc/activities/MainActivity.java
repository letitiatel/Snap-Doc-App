package com.example.snapdoc.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.snapdoc.ImageListFragment;
import com.example.snapdoc.PdfListFragment;
import com.example.snapdoc.R;
import com.example.snapdoc.ui.TextViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private MenuItem deleteMenuItem;
    private MenuItem pdfMenuItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.frameLayout, new ImageListFragment())
                    .commit();
        }

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.bottom_menu_images) {
                    loadImagesFragment();
                } else if (itemId == R.id.bottom_menu_pdfs) {
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
        hideImageMenuItems();
        PdfListFragment pdfListFragment = new PdfListFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, pdfListFragment, "PdfListFragment");
        fragmentTransaction.commit();
    }

    private void loadImagesFragment() {
        setTitle("Images");
        showImageMenuItems();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Do not inflate a menu here, fragments will handle their own menus
        getMenuInflater().inflate(R.menu.menu_images, menu);
        deleteMenuItem = menu.findItem(R.id.images_item_delete);
        pdfMenuItem = menu.findItem(R.id.images_item_pdf);
        return super.onCreateOptionsMenu(menu);
    }

    private void showImageMenuItems() {
        if (deleteMenuItem != null && pdfMenuItem != null) {
            deleteMenuItem.setVisible(true);
            pdfMenuItem.setVisible(true);
        }
    }

    private void hideImageMenuItems() {
        if (deleteMenuItem != null && pdfMenuItem != null) {
            deleteMenuItem.setVisible(false);
            pdfMenuItem.setVisible(false);
        }
    }


}
