package com.example.snapdoc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.tool.util.L;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.Manifest;//?


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.snapdoc.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ImageListFragment extends Fragment {

    private static final int STORAGE_REQUEST_CODE = 100;
    private static final int CAMERA_REQUEST_CODE = 101;

    private static final String TAG = "IMAGE_LIST_TAG";

    private String[] cameraPermissions;
    private String[] storagePermissions;

    private Uri imageUri = null;

    private FloatingActionButton addImageFab;
    private RecyclerView imagesRv;

    private ArrayList<ModelImage> allImageArrayList;
    private AdapterImage adapterImage;

    private ProgressDialog progressDialog;


    private Context mContext;


    public ImageListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        mContext = context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cameraPermissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        addImageFab = view.findViewById(R.id.addImageFab);
        imagesRv = view.findViewById(R.id.imagesRv);


       //init setup progress dialog(e.g for showing progress while all/selected images are being converted to PDF)
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        loadImages();

        addImageFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputImageDialog();
            }
        });
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        inflater.inflate(R.menu.menu_images, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();

        if (itemId == R.id.images_item_delete){

            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Delete Images")
                    .setMessage("Are you sure you want to delete All/Selected images?")
                    .setPositiveButton("Delete All", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            deleteImages(true);

                        }
                    })

                    .setNeutralButton("Delete Selected", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            deleteImages(false);

                        }
                    })

                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                          dialog.dismiss();

                        }

                    })

                    .show();
        }
        else if (itemId == R.id.images_item_pdf){
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Convert To Pdf")
                    .setMessage("Convert All/Selected Images to Pdf")
                    .setPositiveButton("Convert All", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            convertImagesTpPdf(true);

                        }
                    })
                    .setNeutralButton("Convert Selected", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which){
                            convertImagesTpPdf(false);


                        }


                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();

                        }
                    })
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

    private void  convertImagesTpPdf(boolean convertAll){
        Log.d(TAG, "convertImagesTpPdf: convertAll: "+ convertAll);

        progressDialog.setMessage("Converting to PDF...");
        progressDialog.show();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run(){

                Log.d(TAG, "run: BG work start:..");

                ArrayList<ModelImage> imagesToPdfList = new ArrayList<>();
                if(convertAll){
                    imagesToPdfList = allImageArrayList;
                }

            }
        });



    }


    private void deleteImages(boolean deleteAll){

        ArrayList<ModelImage> imagesToDeleteList = new ArrayList<>();

        if(deleteAll){

            imagesToDeleteList = allImageArrayList;

        }
        else{

            for (int i = 0; i < allImageArrayList.size(); i++){
                if (allImageArrayList.get(i).isChecked()){
                    imagesToDeleteList.add(allImageArrayList.get(i));
                }
            }

        }

        for (int i = 0; i < imagesToDeleteList.size(); i++){

            try {
                String pathOfImageToDelete = imagesToDeleteList.get(i).getImageUri().getPath();

                File file = new File(pathOfImageToDelete);
                if (file.exists()){

                    boolean isDeleted = file.delete();

                    Log.d(TAG, "deleteImages: isDeleted: "+isDeleted);
                }


            }
            catch (Exception e){

                Log.d(TAG, "deleteImages: ", e);

            }
        }

        Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();

        loadImages();

    }



    private void loadImages(){
        Log.d(TAG, "loadImages: ");

        allImageArrayList = new ArrayList<>();
        adapterImage = new AdapterImage(mContext, allImageArrayList);

        //set adapter
        imagesRv.setAdapter(adapterImage);

        File folder = new File(mContext.getExternalFilesDir(null), Constants.IMAGES_FOLDER);

        if(folder.exists()){
            Log.d(TAG, "loadImages: Folder exists");

            File[] files = folder.listFiles();

            if (files != null){
                Log.d(TAG, "loadImages: Folder exists and has images");

                for (File file: files){
                    Log.d(TAG, "loadImages: fileName: " + file.getName());

                    Uri imageUri = Uri.fromFile(file);

                    ModelImage modelImage = new ModelImage(imageUri, false);

                    allImageArrayList.add(modelImage);
                    adapterImage.notifyItemInserted(allImageArrayList.size());
                }
                
            }
            else{
                Log.d(TAG, "loadImages: Folder exists but empty");
            }
        }
        else{
            Log.d(TAG, "loadImages: Folder doesn't exist");
        }
    }

    private void saveImageToAppLevelDirectory(Uri imageUriToBeSaved) {
        android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ");
        //Log.d(TAG, "saveImageToAppLevelDirectory: ");
        try {
            Bitmap bitmap;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {

                bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(mContext.getContentResolver(), imageUriToBeSaved));
            } else {

                bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), imageUriToBeSaved);
            }

            //create folder for the saved image
            File directory = new File(mContext.getExternalFilesDir(null), Constants.IMAGES_FOLDER);
            directory.mkdirs();

            // name + extension of the image
            long timestamp = System.currentTimeMillis();
            String fileName = timestamp + ".jpeg";

            File file = new File(mContext.getExternalFilesDir(null), "" + Constants.IMAGES_FOLDER + "/" + fileName);

            // Save Image
            try {
                FileOutputStream fos = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
                fos.flush();
                fos.close();
                android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Image Saved");
                //Log.d(TAG, "saveImageToAppLevelDirectory: Image Saved");
                Toast.makeText(mContext, "Image Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
                //Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
                android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Failed to save image due to "+ e.getMessage());
                //Log.d(TAG, "saveImageToAppLevelDirectory: Failed to save image due to "+ e.getMessage());
                Toast.makeText(mContext, "Failed to save image due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
            //Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
            android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Failed to prepare image due to "+ e.getMessage());
            //Log.d(TAG, "saveImageToAppLevelDirectory: Failed to prepare image due to "+ e.getMessage());
            Toast.makeText(mContext, "Failed to prepare image due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void showInputImageDialog() {
        android.util.Log.d(TAG, "showInputImageDialog: ");
        //Log.d(TAG, "showInputImageDialog: ");

        PopupMenu popupMenu = new PopupMenu(mContext, addImageFab);


        popupMenu.getMenu().add(Menu.NONE, 1, 1, "CAMERA");
        popupMenu.getMenu().add(Menu.NONE, 2, 2, "GALLERY");

        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                if (itemId == 1) {

                    android.util.Log.d(TAG, "onMenuItemClick: Camera is clicked, check if camera permissions are granted or not");
                    //Log.d(TAG, "onMenuItemClick: Camera is clicked, check if camera permissions are granted or not");

                    if (checkCameraPermissions()) {

                        pickImageCamera();
                    } else {
                        requestCameraPermissions();
                    }
                } else if (itemId == 2) {

                    android.util.Log.d(TAG, "onMenuItemClick: Gallery is clicked, check if storage permissions are granted or not");
                    //Log.d(TAG, "onMenuItemClick: Gallery is clicked, check if storage permissions are granted or not");

                    if (checkStoragePermission()) {

                        pickImageGallery();
                    } else {
                        requestStoragePermission();
                    }
                }

                return true;
            }
        });
    }


    private void pickImageGallery() {

        android.util.Log.d(TAG, "pickImageGallery: ");
        //Log.d(TAG, "pickImageGallery: ");

        Intent intent = new Intent(Intent.ACTION_PICK);

        intent.setType("image/*");
        galleryActivityResultLauncher.launch(intent);
    }

    private ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();

                        imageUri = data.getData();
                        android.util.Log.d(TAG, "onActivityResult: Picked image gallery: " + imageUri);
                        //Log.d(TAG, "onActivityResult: Picked image gallery: " + imageUri);

                        saveImageToAppLevelDirectory(imageUri);

                        ModelImage modelImage = new ModelImage(imageUri, false);
                        allImageArrayList.add(modelImage);
                        adapterImage.notifyItemInserted(allImageArrayList.size());

                    } else {
                        Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                    }

                }
            }
    );


    private void pickImageCamera() {
        android.util.Log.d(TAG, "pickImageCamera: ");
        //Log.d(TAG, "pickImageCamera: ");

        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, "TEMP IMAGE TITLE");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "TEMP IMAGE DESCRIPTION");

        imageUri = mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        cameraActivityResultLauncher.launch(intent);
    }


private ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult(
        new ActivityResultContracts.StartActivityForResult(),
        new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if(result.getResultCode() == Activity.RESULT_OK){

                    android.util.Log.d(TAG, "onActivityResult: Picked image camera: "+imageUri);
                    //Log.d(TAG, "onActivityResult: Picked image camera: "+imageUri);

                    saveImageToAppLevelDirectory(imageUri);

                    ModelImage modelImage = new ModelImage(imageUri, false);
                    allImageArrayList.add(modelImage);
                    adapterImage.notifyItemInserted(allImageArrayList.size());

                }
                else{
                    Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                }
        }
    }
);


    private boolean checkStoragePermission(){
        android.util.Log.d(TAG, "checkStoragePermission: ");
        //Log.d(TAG, "checkStoragePermission: ");
        boolean result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return result;
    }

    private void requestStoragePermission(){
        android.util.Log.d(TAG, "requestStoragePermission: ");
        //Log.d(TAG, "requestStoragePermission: ");
        requestPermissions(storagePermissions, STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermissions(){
        android.util.Log.d(TAG, "checkCameraPermissions: ");
        //Log.d(TAG, "checkCameraPermissions: ");
        boolean cameraResult = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        boolean storageResult = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return cameraResult && storageResult;
    }

    private void requestCameraPermissions(){
        android.util.Log.d(TAG, "requestCameraPermissions: ");
        //Log.d(TAG, "requestCameraPermissions: ");
        requestPermissions(cameraPermissions, CAMERA_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case CAMERA_REQUEST_CODE:{

                if(grantResults.length > 0){

                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if(cameraAccepted && storageAccepted){
                        android.util.Log.d(TAG, "onRequestPermissionResult: both permissions (Camera & Gallery) are granted, we can launch camera intent");
                        //Log.d(TAG, "onRequestPermissionsResult: both permissions (Camera & Gallery) are granted, we can launch camera intent");
                        pickImageCamera();
                    }
                    else{
                        android.util.Log.d(TAG, "onRequestPermissionResult: Camera & Storage permissions are required");
                        //Log.d(TAG, "onRequestPermissionsResult: Camera & Storage permissions are required");
                        Toast.makeText(mContext, "Camera & Storage permissions are required", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    android.util.Log.d(TAG, "onRequestPermissionResult: Cancelled...");
                    //Log.d(TAG, "onRequestPermissionsResult: Cancelled...");
                    Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case STORAGE_REQUEST_CODE:{

                if(grantResults.length > 0){

                    boolean storageAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if (storageAccepted){

                        android.util.Log.d(TAG, "onRequestPermissionResult: storage permission granted, we can launch gallery intent");
                        //Log.d(TAG, "onRequestPermissionsResult: storage permission granted, we can launch gallery intent");
                        pickImageGallery();
                    }
                    else{

                        android.util.Log.d(TAG, "onRequestPermissionResult: storage permission denied, can't launch gallery intent");
                        //Log.d(TAG, "onRequestPermissionsResult: storage permission denied, can't launch gallery intent");
                        Toast.makeText(mContext, "Storage permission is required...", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    android.util.Log.d(TAG, "onRequestPermissionResult: Cancelled");
                    //Log.d(TAG, "onRequestPermissionsResult: Cancelled");
                    Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                }
            }
            break;
        }

    }
}