package com.example.snapdoc;

import com.example.snapdoc.adapters.AdapterPdf;
import com.example.snapdoc.models.ModelPdf;

public interface RvListenerPdf {

    void onPdfClick(ModelPdf modelPdf, int position);
    void onPdfMoreClick(ModelPdf modelPdf, int position, AdapterPdf.HolderPdf holder);
}
