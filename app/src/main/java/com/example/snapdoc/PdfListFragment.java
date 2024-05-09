package com.example.snapdoc;

import android.content.Context;
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 05632a61443216cca08eee49d6d6bd87efd43056
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

<<<<<<< HEAD
import com.example.snapdoc.activities.PdfViewActivity;
=======
>>>>>>> 05632a61443216cca08eee49d6d6bd87efd43056
import com.example.snapdoc.adapters.AdapterPdf;
import com.example.snapdoc.models.ModelPdf;

import java.io.File;
import java.util.ArrayList;

public class PdfListFragment extends Fragment {

    private RecyclerView pdfRv;
    private Context mContext;

    private ArrayList<ModelPdf> pdfArrayList;
    private AdapterPdf adapterPdf;
    private static final String TAG = "PDF_LIST_TAG";

    public PdfListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context){
        mContext = context;
        super.onAttach(context);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pdf_list, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        pdfRv = view.findViewById(R.id.pdfRv);
        loadPdfDocuments();
    }

    private void loadPdfDocuments(){

        pdfArrayList = new ArrayList<>();
<<<<<<< HEAD
        adapterPdf = new AdapterPdf(mContext, pdfArrayList, new RvListenerPdf() {
            @Override
            public void onPdfClick(ModelPdf modelPdf, int position) {

                Intent intent = new Intent(mContext, PdfViewActivity.class);
                intent.putExtra("pdfUri", ""+modelPdf.getUri());
                startActivity(intent);
            }

            @Override
            public void onPdfMoreClick(ModelPdf modelPdf, int position) {

            }
        });
=======
        adapterPdf = new AdapterPdf(mContext, pdfArrayList);
>>>>>>> 05632a61443216cca08eee49d6d6bd87efd43056
        pdfRv.setAdapter(adapterPdf);
        File folder = new File(mContext.getExternalFilesDir(null),Constants.PDF_FOLDER);

        if(folder.exists()){
            File[] files = folder.listFiles();
            Log.d(TAG,"loadPdfDocuments: Files Count: " + files.length);

            for(File fileEntry: files){
                Log.d(TAG, "loadPdfDocuments: File Name: " + fileEntry.getName());

                Uri uri = Uri.fromFile(fileEntry);

                ModelPdf modelPdf = new ModelPdf(fileEntry, uri);
                pdfArrayList.add(modelPdf);

                adapterPdf.notifyItemInserted(pdfArrayList.size());
            }
        }
    }
}