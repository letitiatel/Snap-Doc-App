package com.example.snapdoc.models;

import android.net.Uri;

import java.io.File;

public class ModelPdf {
    File file;
    Uri uri;

    public ModelPdf(File file, Uri uri) {
        this.file = file;
        this.uri = uri;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> 05632a61443216cca08eee49d6d6bd87efd43056
