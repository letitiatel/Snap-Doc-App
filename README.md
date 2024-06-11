# Snap-Doc-App
Project developed for the 'Software Development Methods' course within the Faculty of Mathematics and Computer Science, University of Bucharest.
## Members
- [Telicov Letitia-Ioana](https://github.com/letitiatel)
- [Suditu Ana-Maria](https://github.com/anamaria29s)
- [Mocanu Alexandra](https://github.com/alexandramocanu1)

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
     
 
   








      


   

   





   

  
     
    




     
      
      
     





 
     

  





    


  



