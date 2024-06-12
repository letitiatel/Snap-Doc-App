# Snap-Doc-App
Project developed for the 'Software Development Methods' course within the Faculty of Mathematics and Computer Science, University of Bucharest.
## Members
- [Telicov Letitia-Ioana](https://github.com/letitiatel)
- [Suditu Ana-Maria](https://github.com/anamaria29s)
- [Mocanu Alexandra](https://github.com/alexandramocanu1)

## App Demo
https://www.youtube.com/watch?v=rzbQnwcF-gI

## Describing the app - (non-tehnical description - user stories, backlog creation, features list, UML Use Case Diagram, App's behaviour description, App's appearance )

Scan&Doc  is an app designed to effortlessly capture text from images using your device's camera. With powerful OCR technology, it accurately extracts text and offers seamless conversion options, allowing you to save it as PDF. Edit, enhance, and manage your scanned documents with ease. Whether you're a student, professional, or enthusiast, Scan&Doc simplifies text scanning and document management on the go.

### 1. User Stories
1.As a user, I want to upload a photo from my gallery so that I can extract text from it.

2.As a user, I want to convert scanned text into PDF format so that I can easily share and view the documents.

3.As a user, I want to edit the extracted text so that I can correct any errors before saving or converting it.

4.As a user, I want to manage my scanned documents by renaming, deleting, or sharing them.

5.As a user, I want to scan a document with my camera so that I can extract the text for digital use.

6.As a user, I want to view the extracted text in a list format so that I can easily see all the words.

7.As a user, I want to easily navigate between different functions of the app (e.g., scanning, editing, converting) so that my experience is seamless.

8.As a user, I want to rename the PDF file after it has been created so that I can organize my documents more effectively.

9.As a user, I want to save the converted PDF to a specific location on my device so that I can easily find it later.

10.As a user, I want to share the PDF file directly from the app so that I can quickly send it to others.

11.As a user, I want to have a history of recently created PDF files within the app so that I can easily access my previous documents.

12.As a user, I want to delete the PDF files from the app’s history so that I can manage my storage space efficiently.


### 2. Backlog Creation
We monitorized our backlog creation using Trello. It can be found [here](https://trello.com/b/Y3UW7ffC/scandoc-app).

<img width="767" alt="trelloss" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/b8574b34-efbf-49ca-a964-dfcdf3fca9f9">



### 3. Features List
- Ability to use the device's camera to scan text from physical documents or images.
- Chosing a photo from the gallery.
- Viewing, organizing, and managing scanned documents.
- Options to rename, delete, or share scanned documents.

### 4. UML Use Case Diagram

![MDS DIAGRAMA](https://github.com/letitiatel/Snap-Doc-App/assets/116514235/d5b29f16-0cd9-4e9c-8b53-a4bfeb3a1169)

### 5.  App's behaviour description

Snap&Doc allows users to scan text from photos taken instantly or from the gallery. Once the text is extracted, it can be converted into various formats such as PDF. Users can edit the extracted text to correct any errors before conversion. Here is a detailed breakdown of how the app works:

1. Scanning a Document:

- The user can opt to take a new photo or select an existing one from the gallery.
- The app will scan the photo and use OCR (Optical Character Recognition) technology to extract the text.

2. Building a List of Extracted Words:

- The extracted text is organized into a list format, displaying the words extracted from the scanned photo. This list can be used for further processing or conversion into various document formats.

3. Editing the List:

 - Users can modify the list to correct any mistakes by adding new words, deleting incorrect ones, or clearing the entire list. 

4. Finalizing the List:

- Once the list is accurate, users can review the extracted words and make any final adjustments. After confirming the list, users can proceed to convert the text into PDF.

5. User Interface and Experience:

- The interface is designed to be intuitive, with clear instructions and easily accessible buttons for all major functions.
- Real-time feedback and confirmation messages ensure users are aware of the actions they are performing.


### 6. Source control
Branches: [https://github.com/letitiatel/Snap-Doc-App/branches](https://github.com/letitiatel/Snap-Doc-App/branches)

Commits: [https://github.com/letitiatel/Snap-Doc-App/commits/main/](https://github.com/letitiatel/Snap-Doc-App/commits/main/)

### 7. App's appearance (design description)

- App icon

![WhatsApp Image 2024-06-11 at 13 19 19](https://github.com/letitiatel/Snap-Doc-App/assets/116514235/bc2d3855-a210-4f91-af4c-b63340d19690)

- Welcome Page design - appears every time the app is opened

  - activity_splash_screen.xml
  - SplashScreen.java
 
  

  <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/325dbe8e-8b7e-4bb3-aee1-d2c5ff9b89b4">

- Front Page design / Scanner page

  -activity_main.xml

   <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/028c0bf0-45e7-4af1-a8cb-1d475ae5b7f5">

- Navigation bar

   - app_bar_main.xml
   - Text, Images, PDFS

     <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/f8304198-1c7e-4fed-b7c3-d3ac5d1afe4e">

 - Chose an image option

   - takes the user to the gallery in order to select an image and Recognise Text - scans the image that was selected/ the user can take a photo and upload it into the app

      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/58eba84c-ae78-4316-a06c-62116f52dfd2">

     After the image was chosen we can convert it into a PDF or delete it
     
      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/8c3a7475-32e3-4279-a85f-523b6f3b9dfa">
      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/3bcf2745-3774-41d3-b7f5-ae1bfd7adeac">

      Text recognition function

     <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/c9d18d82-9311-4833-9d3d-020e7e352073">
   Image 
   
      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/3ac7db16-4d79-4d6d-b95b-9cbba84fd392">

   Text recognition function

    <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/2185a51c-8752-4bd9-a0a9-65355f97efe5">

   Modify text (DELETE, ADD, CLEAR)

    <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/aec5b0e2-0272-4ff4-a7c7-decd78b38956">

    Convert into PDF

    <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/15d78276-b019-4328-b7b2-66bbbbb3ee9c">

    PDF options
   
     <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/d8d96382-9a95-426b-ad6b-005f611f6305">

     Delete Option

      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/c2f2b738-b1e0-4ab0-b0de-aa1a893aec84">
      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/2bc7cc25-70a8-406f-aa25-a7a9f61547e7">

     Rename Option

      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/19bed8f8-976e-45bf-8f7f-2606905a1a9a">
      <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/ef5905fa-9198-497b-b9c7-6686369196ce">

     Share Option

     <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/c5fc5f23-1a4b-4def-8f54-76d9614cce66">
     <img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/00a8d8ae-0808-4468-9eba-72df5ac558e0">

 ## Describing the code (tehnical - Functions and proprieties, Tehnical Description of behaviour)

 - Splash Screen 

   - info: the first activity that starts when the app launches and acts as a welcome/ loading page
   - behaviour: starts every time the app launches, runs for 5 seconds and then reddirects to main activity
   - splash.html

 ### Code for Bottom Navigation 

 <?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    tools:showIn="navigation_view">

    <item
        android:id="@+id/bottom_menu_text"
        android:icon="@drawable/ic_text"
        android:title="Text" />

    <item android:id="@+id/bottom_menu_images"
        android:title="Images"
        android:icon="@drawable/ic_image_black"/>

    <item android:id="@+id/bottom_menu_pdfs"
        android:icon="@drawable/ic_image_black"
        android:title="PDFs"/>

</menu>

These functions can be found in bottom_navigation.xml file.

### Code for Menu Bar which is the same for the pdf and text pages

<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <item android:id="@+id/images_item_delete"
        android:icon="@drawable/ic_delete_white"
        app:showAsAction="always"
        android:title="Delete"/>

    <item android:id="@+id/images_item_pdf"
        android:title="Convert To Pdf"
        app:showAsAction="always"
        android:icon="@drawable/ic_pdf_pink"/>
</menu>

This code can be found in the menu_images file.



### Code for Text Page

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/activity_container"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".ui.TextViewFragment">


    <ScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@id/toolbar"
        android:layout_above="@id/bottomNavigationView">

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical">

            <com.google.android.material.button.MaterialButton
                android:id="@+id/recognizeTextButton"
                android:layout_width="208dp"
                android:layout_height="56dp"
                android:layout_marginStart="10dp"
                android:layout_weight="1"
                android:text="Recognize Text"
                app:cornerRadius="5dp" />

            <com.google.android.material.imageview.ShapeableImageView
                android:id="@+id/imageIq"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:adjustViewBounds="true"
                android:src="@drawable/ic_baseline_image_24"
                app:strokeWidth="2dp" />

            <TextView
                style="@style/TextAppearance.MaterialComponents.Headline6"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:text="Recognised text: "
                android:padding="8dp"
                android:layout_marginTop="10dp"
                android:textSize="16sp"
                android:textColor="@android:color/black"/>

            <EditText
                android:id="@+id/recognisedTextBtn"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:textSize="12sp"/>

            <FrameLayout
                android:id="@+id/frameLayout"
                android:layout_width="match_parent"
                android:layout_height="wrap_content">
            </FrameLayout>

        </LinearLayout>
    </ScrollView>

</RelativeLayout>

These functions can be found in fragment_text_list.xml file. 


 ### Converts images to pdf

     private void convertImagesToPdf(boolean convertAll) {
        Log.d(TAG, "convertImagesToPdf: convertAll: " + convertAll);

        progressDialog.setMessage("Converting to PDF...");
        progressDialog.show();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executorService.execute(new Runnable() {
            @Override
            public void run(){

               // here we will do background  task to convert all/selected images to pdf
            public void run() {
                Log.d(TAG, "run: BG work start:..");
                ArrayList<ModelImage> imagesToPdfList = new ArrayList<>();
                if (convertAll) {
                    imagesToPdfList = allImageArrayList;
                } else {
                    for (int i = 0; i < allImageArrayList.size(); i++) {
                        if (allImageArrayList.get(i).isChecked()) {
                            imagesToPdfList.add(allImageArrayList.get(i));
                        }
                    }
                }
                Log.d(TAG, "run: imagesToPdfList size: " + imagesToPdfList.size());


###  Delete images

    private void deleteImages(boolean deleteAll) {
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

### Picks image from camera

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

 ### Proces image captured by camera

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

### Picks image from gallery

    private void pickImageGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        galleryActivityResultLauncher.launch(intent);
    }
            loadImages();
            progressDialog.dismiss();
        }
    }

## Report bug and resolve it with pull request

### Discovered bug

<img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/8eafa3be-cba5-4871-add9-5c93f63272f1">

### Fixed bug with pull request

<img width="300" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/958a53b7-a5ea-4b2b-9a90-dd329c5d1b91">


## Refactoring - Code standards

Enhancing Maintainability:

 - Adding comments and documentation to make the code easier to understand.
 - Refactoring to follow consistent coding standards and conventions.
 - Renaming variables, methods, and classes to more meaningful names.

## Using an AI tool that assists during software development
   ML Kit used to recognize text from an image

     private void recognizeText(Bitmap bitmap) {
        InputImage image = InputImage.fromBitmap(bitmap, 0);
        TextRecognizer recognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS);

        recognizer.process(image)
                .addOnSuccessListener(new com.google.android.gms.tasks.OnSuccessListener<Text>() {
                    @Override
                    public void onSuccess(Text visionText) {
                        displayRecognizedText(visionText);
                    }
                })
                .addOnFailureListener(new com.google.android.gms.tasks.OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        recognisedText.setText(R.string.text_recognition_failed);
                    }
                });
    }

 
 link Firebase - https://firebase.google.com/docs/ml-kit/recognize-text












 
