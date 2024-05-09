package com.example.snapdoc.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import androidx.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.snapdoc.R;
import com.example.snapdoc.models.ModelPdfView;
import com.technifysoft.imagestopdf.R;

import java.util.ArrayList;

public class AdapterPdfView extends RecyclerView.Adapter<AdapterPdfView.HolderPdfView>{

    private Context context;
    private ArrayList<ModelPdfView> pdfViewArrayList;

    public AdapterPdfView(Context context, ArrayList<ModelPdfView> pdfViewArrayList) {
        this.context = context;
        this.pdfViewArrayList = pdfViewArrayList;
    }

    @NonNull
    @Override
    public HolderPdfView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_pdf_view, parent, false);
        return new HolderPdfView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderPdfView holder, int position) {

        ModelPdfView modelPdfView = pdfViewArrayList.get(position);

        int pageNumber = position+1;
        Bitmap bitmap = modelPdfView.getBitmap();

        Glide.with(context)
                .load(bitmap)
                .placeholder(R.drawable.ic_image_black)
                .into(holder.imageIv);


        holder.pageNumberTv.setText(""+pageNumber);

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    class HolderPdfView extends RecyclerView.ViewHolder {
        TextView pageNumberTv;
        ImageView imageIv;

        public HolderPdfView(@NonNull View itemView) {
            super(itemView);
            pageNumberTv = itemView.findViewById(R.id.pageNumberTv);
        }
    }
}

