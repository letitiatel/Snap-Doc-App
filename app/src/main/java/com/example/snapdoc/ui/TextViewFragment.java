package com.example.snapdoc.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.snapdoc.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.mlkit.vision.text.Text;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;


public class TextViewFragment extends Fragment {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;
    private EditText recognisedText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_text_list, container, false);

        imageView = view.findViewById(R.id.imageIq);
        recognisedText = view.findViewById(R.id.recognisedTextBtn);
        MaterialButton recognizeButton = view.findViewById(R.id.recognizeTextButton);

        recognizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_text, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.text_item_delete) {
            showDeleteConfirmationDialog();
            return true;
        } else if (itemId == R.id.text_item_pdf) {
            showPdfOptionDialog();


        }
        return false;
    }

//
//
//    @Override
//    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
//        MenuInflater inflater = mode.getMenuInflater();
//        inflater.inflate(R.menu.menu_text, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
//        // You can update menu items here if needed
//        return false;
//    }
//
//    @Override
//    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//        int itemId = item.getItemId();
//        if (itemId == R.id.text_item_delete) {
//            // Handle delete action
//            mode.finish(); // Finish the action mode after performing the action
//            return true;
//        } else if (itemId == R.id.text_item_pdf) {
//            // Handle PDF conversion action
//            mode.finish();
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void onDestroyActionMode(ActionMode mode) {
//        // Cleanup actions if needed
//    }
//
//
//
//    private void startActionMode() {
//        FragmentActivity activity = getActivity();
//        if (activity instanceof AppCompatActivity) {
//            AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
//            appCompatActivity.startSupportActionMode((androidx.appcompat.view.ActionMode.Callback) this);
//        }
//    }
    private void showPdfOptionDialog() {
        new AlertDialog.Builder(getContext())
                .setMessage("Convert to an existing PDF or create a new one?")
                .setPositiveButton("New PDF", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        createNewPdf();
                    }
                })
                .setNegativeButton("Existing PDF", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        addToExistingPdf();
                    }
                })
                .show();
    }

    private void showDeleteConfirmationDialog() {
        new AlertDialog.Builder(getContext())
                .setMessage("Do you want to delete all?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recognisedText.setText("");
                        Toast.makeText(getContext(), "Text deleted", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void createNewPdf() {
        // Logic for creating a new PDF
        Toast.makeText(getContext(), "New PDF created", Toast.LENGTH_SHORT).show();
    }

    private void addToExistingPdf() {
        // Logic for adding to an existing PDF
        Toast.makeText(getContext(), "Added to existing PDF", Toast.LENGTH_SHORT).show();
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            recognizeText(imageBitmap);
        }
    }

    private void recognizeText(Bitmap bitmap) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        recognizer.process(image)
                .addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text visionText) {
                        displayRecognizedText(visionText);
                        //startActionMode();
                    }
                })
                .addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        recognisedText.setText(R.string.text_recognition_failed);
                    }
                });
    }

    private void displayRecognizedText(Text visionText) {
        StringBuilder resultText = new StringBuilder();
        for (Text.TextBlock block : visionText.getTextBlocks()) {
            resultText.append(block.getText()).append("\n");
        }
        recognisedText.setText(resultText.toString());
    }
    //package com.example.snapdoc.ui;
//
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import com.example.snapdoc.R;
//import com.google.android.material.imageview.ShapeableImageView;
//
//public class TextViewFragment extends Fragment {
//
//    private EditText recognisedTextBtn;
//    private ShapeableImageView imageIq;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_text_list, container, false);
//
//        imageIq = view.findViewById(R.id.imageIq);
//        recognisedTextBtn = view.findViewById(R.id.recognisedTextBtn);
//
//        return view;
//    }
//
//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        inflater.inflate(R.menu.menu_text, menu);
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId())
//        switch (item.getItemId()) {
//            case R.id.text_item_delete:
//                showDeleteConfirmationDialog();
//                return true;
//            case R.id.text_item_pdf:
//                showPdfOptionDialog();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//
//    private void showDeleteConfirmationDialog() {
//        new AlertDialog.Builder(getContext())
//                .setMessage("Do you want to delete all?")
//                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        recognisedTextBtn.setText("");
//                        Toast.makeText(getContext(), "Text deleted", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setNegativeButton("No", null)
//                .show();
//    }
//
//    private void showPdfOptionDialog() {
//        new AlertDialog.Builder(getContext())
//                .setMessage("Convert to an existing PDF or create a new one?")
//                .setPositiveButton("New PDF", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        createNewPdf();
//                    }
//                })
//                .setNegativeButton("Existing PDF", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        addToExistingPdf();
//                    }
//                })
//                .show();
//    }
//

}
