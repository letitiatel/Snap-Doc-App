package com.example.snapdoc.adapters;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.snapdoc.R;
import com.example.snapdoc.activities.ImageViewActivity;
import com.example.snapdoc.models.ModelImage;

import java.util.ArrayList;

public class AdapterImageView extends RecyclerView.Adapter<AdapterImageView.HolderImageView> {

    private Context context;
    private ArrayList<ModelImage> imageArrayList;

    public AdapterImageView(Context context, ArrayList<ModelImage> imageArrayList) {
        this.context = context;
        this.imageArrayList = imageArrayList;
    }

    @NonNull
    @Override
    public HolderImageView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_image_view, parent, false);
        return new HolderImageView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderImageView holder, int position) {
        ModelImage modelImage = imageArrayList.get(position);
        Uri imageUri = modelImage.getImageUri();

        Glide.with(context)
                .load(imageUri)
                .placeholder(R.drawable.ic_image_black)
                .into(holder.imageIv);

        holder.imageIv.setOnClickListener(v -> {
            Intent intent = new Intent(context, ImageViewActivity.class);
            intent.putExtra("imageUri", imageUri.toString());
            context.startActivity(intent);
        });


    }

    @Override
    public int getItemCount() {
        return imageArrayList.size();
    }

    private void showLargeImage(Uri imageUri) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_large_image);

        ImageView largeImageView = dialog.findViewById(R.id.largeImageView);

        Glide.with(context)
                .load(imageUri)
                .placeholder(R.drawable.ic_image_black)
                .into(largeImageView);

        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    class HolderImageView extends RecyclerView.ViewHolder {
        ImageView imageIv;

        public HolderImageView(@NonNull View itemView) {
            super(itemView);
            imageIv = itemView.findViewById(R.id.imageIv);
        }
    }
}
