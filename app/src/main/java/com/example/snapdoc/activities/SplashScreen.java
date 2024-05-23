package com.example.snapdoc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.snapdoc.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Activează JavaScript-ul
        webView.loadUrl("file:///android_asset/splash.html");

        // Setează un delay pentru splash screen
        int SPLASH_DISPLAY_LENGTH = 5000; // 5 secunde
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                SplashScreen.this.startActivity(mainIntent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
