package com.example.snapdoc;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ImageDecoder;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.snapdoc.adapters.AdapterImage;
import com.example.snapdoc.models.ModelImage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;


import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageListFragment extends Fragment {

    private static final String TAG = "IMAGE_LIST_TAG";

    private Uri imageUri = null;
    private FloatingActionButton addImageFab;
    private RecyclerView imagesRv;
    private ArrayList<ModelImage> allImageArrayList;
    private AdapterImage adapterImage;
<<<<<<< HEAD
    private ProgressDialog progressDialog;
=======

    private AlertDialog progressDialog;


>>>>>>> main
    private Context mContext;
    private ImageView imageView;
    private TextView textView;

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

        addImageFab = view.findViewById(R.id.addImageFab);
        imagesRv = view.findViewById(R.id.imagesRv);
        imageView = view.findViewById(R.id.imageView);
        textView = view.findViewById(R.id.textView);

<<<<<<< HEAD
<<<<<<< Updated upstream

       //init setup progress dialog(e.g for showing progress while all/selected images are being converted to PDF)
=======
>>>>>>> Stashed changes
        progressDialog = new ProgressDialog(mContext);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);
=======
        // Initialize Progress Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_progress, null);
        builder.setView(dialogView);
        builder.setCancelable(false);
        progressDialog = builder.create();
>>>>>>> main

        loadImages();

        addImageFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInputImageDialog();
            }
        });

        // Add MenuProvider for handling menu
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_images, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int itemId = menuItem.getItemId();

                if (itemId == R.id.images_item_delete) {
                    Log.d(TAG, "TEST: " );
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    builder.setTitle("Delete Images")
                            .setMessage("Are you sure you want to delete All/Selected images?")
                            .setPositiveButton("Delete All", (dialog, which) -> deleteImages(true))
                            .setNeutralButton("Delete Selected", (dialog, which) -> deleteImages(false))
                            .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                            .show();
                    return true;
                } else if (itemId == R.id.images_item_pdf) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
                    builder.setTitle("Convert To Pdf")
                            .setMessage("Convert All/Selected Images to Pdf")
                            .setPositiveButton("Convert All", (dialog, which) -> convertImagesToPdf(true))
                            .setNeutralButton("Convert Selected", (dialog, which) -> convertImagesToPdf(false))
                            .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                            .show();
                    return true;
                }

                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
    }

<<<<<<< HEAD
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

        if (itemId == R.id.images_item_delete) {
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
<<<<<<< Updated upstream

                          dialog.dismiss();

=======
                            dialog.dismiss();
>>>>>>> Stashed changes
                        }
                    })
                    .show();
        } else if (itemId == R.id.images_item_pdf) {
            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
            builder.setTitle("Convert To Pdf")
                    .setMessage("Convert All/Selected Images to Pdf")
                    .setPositiveButton("Convert All", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            convertImagesToPdf(true);
                        }
                    })
                    .setNeutralButton("Convert Selected", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            convertImagesToPdf(false);
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

    private void convertImagesToPdf(boolean convertAll) {
        Log.d(TAG, "convertImagesToPdf: convertAll: " + convertAll);

        progressDialog.setMessage("Converting to PDF...");
=======
    private void convertImagesToPdf(boolean convertAll) {
        Log.d(TAG, "convertImagesToPdf: convertAll: " + convertAll);

>>>>>>> main
        progressDialog.show();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
<<<<<<< HEAD
<<<<<<< Updated upstream
            public void run(){

               // here we will do background  task to convert all/selected images to pdf
=======
            public void run() {
>>>>>>> Stashed changes
=======
            public void run() {
>>>>>>> main
                Log.d(TAG, "run: BG work start:..");
                ArrayList<ModelImage> imagesToPdfList = new ArrayList<>();
                if (convertAll) {
                    imagesToPdfList = allImageArrayList;
                } else {
<<<<<<< HEAD
                    for (int i = 0; i < allImageArrayList.size(); i++) {
                        if (allImageArrayList.get(i).isChecked()) {
                            imagesToPdfList.add(allImageArrayList.get(i));
=======
                    for (ModelImage image : allImageArrayList) {
                        if (image.isChecked()) {
                            imagesToPdfList.add(image);
>>>>>>> main
                        }
                    }
                }
                Log.d(TAG, "run: imagesToPdfList size: " + imagesToPdfList.size());

<<<<<<< HEAD
<<<<<<< Updated upstream
                try{
                   //1) create folder where we will save th pdf
=======
                try {
>>>>>>> Stashed changes
=======
                try {
>>>>>>> main
                    File root = new File(mContext.getExternalFilesDir(null), Constants.PDF_FOLDER);
                    root.mkdirs();
                    long timestamp = System.currentTimeMillis();
                    String fileName = "PDF_" + timestamp + ".pdf";
                    Log.d(TAG, "run: fileName:" + fileName);
                    File file = new File(root, fileName);
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    PdfDocument pdfDocument = new PdfDocument();

                    for (int i = 0; i < imagesToPdfList.size(); i++) {
                        Uri imageToAdInPdfUri = imagesToPdfList.get(i).getImageUri();
                        try {
                            Bitmap bitmap;
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                                bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(mContext.getContentResolver(), imageToAdInPdfUri));
                            } else {
                                bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), imageToAdInPdfUri);
                            }
                            bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, false);
<<<<<<< HEAD
<<<<<<< Updated upstream
                          // setup pdf  page info e.g page height, width, nmber.Since value of i will start from 0 so we will do i+1
                            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(),i+1).create();
                           //create pdf page
=======
                            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), i + 1).create();
>>>>>>> main
                            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                            Paint paint = new Paint();
                            paint.setColor(Color.WHITE);
<<<<<<< HEAD
                             //setup canva with bitmap to add in pdf page
=======
                            PdfDocument.PageInfo pageInfo = new PdfDocument.PageInfo.Builder(bitmap.getWidth(), bitmap.getHeight(), i + 1).create();
                            PdfDocument.Page page = pdfDocument.startPage(pageInfo);
                            Paint paint = new Paint();
                            paint.setColor(Color.WHITE);
>>>>>>> Stashed changes
=======
>>>>>>> main
                            Canvas canvas = page.getCanvas();
                            canvas.drawPaint(paint);
                            canvas.drawBitmap(bitmap, 0f, 0f, null);
                            pdfDocument.finishPage(page);
                            bitmap.recycle();
                        } catch (Exception e) {
                            Log.e(TAG, "run:", e);
                        }
                    }

                    pdfDocument.writeTo(fileOutputStream);
                    pdfDocument.close();
                } catch (Exception e) {
<<<<<<< HEAD
                    progressDialog.dismiss();
=======
>>>>>>> main
                    Log.e(TAG, "run:", e);
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
<<<<<<< HEAD
                        progressDialog.dismiss();
                        Toast.makeText(mContext, "PDF Converted Successfully...", Toast.LENGTH_SHORT).show();
=======
                        Log.d(TAG, "run: Converted..");
                        progressDialog.dismiss();
                        Toast.makeText(mContext, "Converted...", Toast.LENGTH_SHORT).show();
>>>>>>> main
                    }
                });
            }
        });
    }

    private void deleteImages(boolean deleteAll) {
<<<<<<< HEAD
        if (deleteAll) {
            progressDialog.setMessage("Deleting All Images...");
            progressDialog.show();

            for (int i = 0; i < allImageArrayList.size(); i++) {
                Uri imageUriToDelete = allImageArrayList.get(i).getImageUri();
                mContext.getContentResolver().delete(imageUriToDelete, null, null);
            }

            allImageArrayList.clear();
            adapterImage.notifyDataSetChanged();
            progressDialog.dismiss();

            Toast.makeText(mContext, "All Images Deleted...", Toast.LENGTH_SHORT).show();
        } else {
            progressDialog.setMessage("Deleting Selected Images...");
            progressDialog.show();

            for (int i = 0; i < allImageArrayList.size(); i++) {
                if (allImageArrayList.get(i).isChecked()) {
                    Uri imageUriToDelete = allImageArrayList.get(i).getImageUri();
                    mContext.getContentResolver().delete(imageUriToDelete, null, null);
                }
            }

            loadImages();
            progressDialog.dismiss();
        }
=======
        ArrayList<ModelImage> imagesToDeleteList = new ArrayList<>();

        if (deleteAll) {
            Log.d(TAG, "TEST1: " );
            imagesToDeleteList = new ArrayList<>(allImageArrayList);
        } else {
            Log.d(TAG, "TEST2: " );
            for (ModelImage image : allImageArrayList) {
                if (image.isChecked()) {
                    imagesToDeleteList.add(image);
                }
            }
        }
        Log.d(TAG, "TEST3: " );
        for (ModelImage image : imagesToDeleteList) {
            try {
                Log.d(TAG, "TEST4: " );
                Uri imageUriToDelete = image.getImageUri();
                String pathOfImageToDelete = imageUriToDelete.getPath();
                assert pathOfImageToDelete != null;
                File file = new File(pathOfImageToDelete);
                if (file.exists()) {
                    boolean isDeleted = file.delete();
                    Log.d(TAG, "deleteImages: isDeleted: " + isDeleted);
                    if (isDeleted) {
                        allImageArrayList.remove(image);
                    } else {
                        // Încearcă să ștergi folosind ContentResolver dacă metoda file.delete() eșuează
                        int deletedRows = mContext.getContentResolver().delete(imageUriToDelete, null, null);
                        if (deletedRows > 0) {
                            Log.d(TAG, "deleteImages: Deleted using ContentResolver: " + imageUriToDelete);
                            allImageArrayList.remove(image);
                        }
                    }
                }
            } catch (Exception e) {
                Log.d(TAG, "deleteImages: ", e);
            }
        }

        adapterImage.notifyDataSetChanged();
        Toast.makeText(mContext, "Deleted", Toast.LENGTH_SHORT).show();
>>>>>>> main
    }

    private void loadImages() {
        allImageArrayList = new ArrayList<>();
        adapterImage = new AdapterImage(mContext, allImageArrayList);
        imagesRv.setAdapter(adapterImage);

<<<<<<< Updated upstream
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
<<<<<<< HEAD
                
=======
        String[] projection = {MediaStore.Images.Media._ID, MediaStore.Images.Media.DATA, MediaStore.Images.Media.TITLE, MediaStore.Images.Media.DATE_ADDED, MediaStore.Images.Media.SIZE};
        String orderBy = MediaStore.Images.Media.DATE_ADDED + " DESC";
        Cursor cursor = mContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, orderBy);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                long id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID));
                Uri uri = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id);
                ModelImage modelImage = new ModelImage(uri, false);
                allImageArrayList.add(modelImage);
>>>>>>> Stashed changes
=======

>>>>>>> main
            }
            cursor.close();
        }

<<<<<<< HEAD
        adapterImage.notifyDataSetChanged();
=======
    private void saveImageToAppLevelDirectory(Uri imageUriToBeSaved) {
        //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ");
        Log.d(TAG, "saveImageToAppLevelDirectory: ");
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
                //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Image Saved");
                Log.d(TAG, "saveImageToAppLevelDirectory: Image Saved");
                Toast.makeText(mContext, "Image Saved", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
                Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
                //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Failed to save image due to "+ e.getMessage());
                Log.d(TAG, "saveImageToAppLevelDirectory: Failed to save image due to "+ e.getMessage());
                Toast.makeText(mContext, "Failed to save image due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
            Log.d(TAG, "saveImageToAppLevelDirectory: ", e);
            //android.util.Log.d(TAG, "saveImageToAppLevelDirectory: Failed to prepare image due to "+ e.getMessage());
            Log.d(TAG, "saveImageToAppLevelDirectory: Failed to prepare image due to "+ e.getMessage());
            Toast.makeText(mContext, "Failed to prepare image due to " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void showInputImageDialog() {
        //android.util.Log.d(TAG, "showInputImageDialog: ");
        Log.d(TAG, "showInputImageDialog: ");

        PopupMenu popupMenu = new PopupMenu(mContext, addImageFab);


        popupMenu.getMenu().add(Menu.NONE, 1, 1, "CAMERA");
        popupMenu.getMenu().add(Menu.NONE, 2, 2, "GALLERY");

        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                int itemId = menuItem.getItemId();
                if (itemId == 1) {

                    //android.util.Log.d(TAG, "onMenuItemClick: Camera is clicked, check if camera permissions are granted or not");
                    Log.d(TAG, "onMenuItemClick: Camera is clicked, check if camera permissions are granted or not");

                    if (checkCameraPermissions()) {
                        //camera permissions already granted, we can launch camera intent
                        pickImageCamera();
                    } else {
                        //requestCameraPermissions();
                        //camera permissions are not granted, request the camera permissions
                        requestCameraPermissions.launch(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE});

                    }
                } else if (itemId == 2) {

                    //android.util.Log.d(TAG, "onMenuItemClick: Gallery is clicked, check if storage permissions are granted or not");
                    Log.d(TAG, "onMenuItemClick: Gallery is clicked, check if storage permissions are granted or not");

//                    if (checkStoragePermission()) {

                        pickImageGallery();
//                    } else {
//                        requestStoragePermission.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE);
//                    }
                }

                return true;
            }
        });
    }


    private void pickImageGallery() {

        //android.util.Log.d(TAG, "pickImageGallery: ");
        Log.d(TAG, "pickImageGallery: ");

        Intent intent = new Intent(Intent.ACTION_PICK);

        intent.setType("image/*");
        galleryActivityResultLauncher.launch(intent);
>>>>>>> main
    }

    private ActivityResultLauncher<Intent> galleryActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        imageUri = data.getData();
                        processCapturedImage(imageUri);
                    } else {
                        Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

<<<<<<< Updated upstream

    private void pickImageCamera() {
        //android.util.Log.d(TAG, "pickImageCamera: ");
        Log.d(TAG, "pickImageCamera: ");

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

                        //android.util.Log.d(TAG, "onActivityResult: Picked image camera: "+imageUri);
                        Log.d(TAG, "onActivityResult: Picked image camera: "+imageUri);

                        saveImageToAppLevelDirectory(imageUri);

                        ModelImage modelImage = new ModelImage(imageUri, false);
                        allImageArrayList.add(modelImage);
                        adapterImage.notifyItemInserted(allImageArrayList.size());

<<<<<<< HEAD
=======
    private ActivityResultLauncher<Intent> cameraActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        processCapturedImage(imageUri);
                    } else {
                        Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                    }
>>>>>>> Stashed changes
=======
                    }
                    else{
                        Toast.makeText(mContext, "Cancelled...", Toast.LENGTH_SHORT).show();
                    }
>>>>>>> main
                }
            }
    );

<<<<<<< HEAD
=======

    private boolean checkStoragePermission(){
        //android.util.Log.d(TAG, "checkStoragePermission: ");
        Log.d(TAG, "checkStoragePermission: ");
        boolean result = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return result;
    }

    private ActivityResultLauncher<String> requestStoragePermission = registerForActivityResult(
            new ActivityResultContracts.RequestPermission(),
            new ActivityResultCallback<Boolean>() {
                @Override
                public void onActivityResult(Boolean isGranted) {
                    Log.d(TAG, "onActivityResult: isGranted: " + isGranted);

                    if (isGranted) {

                        pickImageGallery();
                    } else {

                        Toast.makeText(mContext, "Permission denied...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );

    private boolean checkCameraPermissions(){
        //android.util.Log.d(TAG, "checkCameraPermissions: ");
        Log.d(TAG, "checkCameraPermissions: ");
        boolean cameraResult = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        //boolean storageResult = ContextCompat.checkSelfPermission(mContext, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        return cameraResult ;
    }


>>>>>>> main
    private ActivityResultLauncher<String[]> requestCameraPermissions = registerForActivityResult(
            new ActivityResultContracts.RequestMultiplePermissions(),
            new ActivityResultCallback<Map<String, Boolean>>() {
                @Override
                public void onActivityResult(Map<String, Boolean> result) {
                    boolean allGranted = true;
                    for (Boolean isGranted : result.values()) {
                        allGranted = allGranted && isGranted;
                    }
                    if (allGranted) {
                        pickImageCamera();
                    } else {
                        Toast.makeText(mContext, "Camera or Storage permission denied...", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
<<<<<<< HEAD

<<<<<<< Updated upstream
}
=======
    private void pickImageGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        galleryActivityResultLauncher.launch(intent);
    }

    private void pickImageCamera() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE, "TEMP IMAGE TITLE");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION, "TEMP IMAGE DESCRIPTION");

        imageUri = mContext.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        cameraActivityResultLauncher.launch(intent);
    }

    private void showInputImageDialog() {
        PopupMenu popupMenu = new PopupMenu(mContext, addImageFab);
        popupMenu.getMenu().add(Menu.NONE, 1, 1, "CAMERA");
        popupMenu.getMenu().add(Menu.NONE, 2, 2, "GALLERY");
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == 1) {
                    if (checkCameraPermissions()) {
                        pickImageCamera();
                    } else {
                        requestCameraPermissions.launch(new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE});
                    }
                } else if (itemId == 2) {
                    pickImageGallery();
                }
                return true;
            }
        });
    }

    private boolean checkCameraPermissions() {
        boolean cameraResult = ContextCompat.checkSelfPermission(mContext, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
        return cameraResult;
    }

    private void processCapturedImage(Uri imageUri) {
        try {
            Bitmap bitmap;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(mContext.getContentResolver(), imageUri));
            } else {
                bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), imageUri);
            }

            // Extrage textul din imagine folosind Firebase ML Kit
            Log.d(TAG, "processCapturedImage: Extracting text from image");
            //extractTextFromImage(bitmap);

            // Actualizarea ImageView cu imaginea capturată
            imageView.setImageBitmap(bitmap);

            // Salvează imaginea în directorul aplicației și adaugă în listă
            saveImageToAppLevelDirectory(imageUri);
            ModelImage modelImage = new ModelImage(imageUri, false);
            allImageArrayList.add(modelImage);
            adapterImage.notifyItemInserted(allImageArrayList.size());
        } catch (Exception e) {
            Log.e(TAG, "Error processing captured image", e);
        }
    }


//    private void extractTextFromImage(Bitmap bitmap) {
//        FirebaseVisionImage firebaseVisionImage = FirebaseVisionImage.fromBitmap(bitmap);
//        FirebaseVision firebaseVision = FirebaseVision.getInstance();
//        FirebaseVisionTextRecognizer firebaseVisionTextRecognizer = firebaseVision.getOnDeviceTextRecognizer();
//
//        Task<FirebaseVisionText> task = firebaseVisionTextRecognizer.processImage(firebaseVisionImage);
//        task.addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
//            @Override
//            public void onSuccess(FirebaseVisionText firebaseVisionText) {
//                String text = firebaseVisionText.getText();
//                Log.d(TAG, "onSuccess: Detected text: "+text);
//                //show the text in a TextView
//                textView.setText(text);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                Log.d(TAG, "onFailure: Text extraction failed"+e.getMessage());
//                Toast.makeText(mContext, "Failed to extract text", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }


    private void saveImageToAppLevelDirectory(Uri uri) {
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(mContext.getContentResolver(), uri);
            File directory = new File(mContext.getFilesDir(), "images");
            if (!directory.exists()) {
                directory.mkdir();
            }
            String filename = "image_" + System.currentTimeMillis() + ".jpg";
            File file = new File(directory, filename);
            FileOutputStream outputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.close();
        } catch (Exception e) {
            Log.e(TAG, "Error saving image to app level directory", e);
        }
    }
}
>>>>>>> Stashed changes
=======
}
>>>>>>> main
