package com.example.snapdoc.models;

import android.graphics.Bitmap;
import android.net.Uri;

public class ModelPdfView {

    private Uri uri;
    private int pageNumber;
    private int pageCount;
    private Bitmap bitmap;

    public ModelPdfView(Uri uri, int pageNumber, int pageCount, Bitmap bitmap) {
        this.uri = uri;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
        this.bitmap = bitmap;
    }

    public Uri getUri() {
        return uri;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
