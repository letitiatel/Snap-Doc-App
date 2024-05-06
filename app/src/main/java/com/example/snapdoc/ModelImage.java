package com.example.snapdoc;

import android.net.Uri;

public class ModelImage {

    Uri imageUri;

    public ModelImage(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }
}
