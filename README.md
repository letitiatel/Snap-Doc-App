# Snap-Doc-App
Project developed for the 'Software Development Methods' course within the Faculty of Mathematics and Computer Science, University of Bucharest.
## Members
- [Telicov Letitia-Ioana](https://github.com/letitiatel)
- [Suditu Ana-Maria](https://github.com/anamaria29s)
- [Mocanu Alexandra](https://github.com/alexandramocanu1)

## Describing the app - (non-tehnical description - user stories, backlog creation, features list)

Scan&Doc  is an app designed to effortlessly capture text from physical documents or images using your device's camera. With powerful OCR technology, it accurately extracts text and offers seamless conversion options, allowing you to save it as PDF, Word, or other popular formats. Edit, enhance, and manage your scanned documents with ease, and effortlessly share or sync them across devices. Whether you're a student, professional, or enthusiast, Scan&Doc simplifies text scanning and document management on the go.

### 1. User Stories
1.As a student, I want to use the device's camera to scan text from physical documents or images so that I can capture information for various purposes.

2.As a journalist, I want to convert scanned text into PDF format so that I can easily share and view the documents.

3.As a business professional, I want to edit the scanned text within the app before saving it to a document format.

4.As a researcher, I want to manage my scanned documents by renaming, deleting, or sharing them.

5.As a teacher, I want to convert scanned text into different fonts so that I can customize the appearance of my documents.

6.As a legal assistant, I want to choose a photo from the gallery or Drive to scan text so that I can work with existing images.

7.As a traveler, I want to scan travel itineraries and save them as PDFs on my phone for offline access during my trip.

8.As a writer, I want to convert scanned text into Word documents so that I can edit and format the text as needed.

9.As a teacher, I want to customize the font style, size, and color of the scanned text to enhance readability.

10.As a language learner, I need to scan foreign language texts and save them as PDFs for later translation and study.

11.As a medical professional, I want to scan patient charts and save them as PDFs securely for digital record-keeping and compliance with privacy regulations.

12.As a designer, I need to scan sketches and save them as editable vector files, such as SVG or EPS, for further refinement in graphic design software.

13.As a real estate agent, I need to scan property listings and save them as PDFs to share with potential buyers or renters during property viewings.

14.As a project manager, I want to view the scanned documents within the app so that I can verify the scanned content.

### 2. Backlog Creation
We monitorized our backlog creation using Trello. It can be found [here](https://trello.com/b/Y3UW7ffC/scandoc-app).

<img width="767" alt="trelloss" src="https://github.com/letitiatel/Snap-Doc-App/assets/116514235/b8574b34-efbf-49ca-a964-dfcdf3fca9f9">



### 3. Features List
- Ability to use the device's camera to scan text from physical documents or images.
- Manual adjustment options for text cropping and rotation.
- Chosing a photo from the gallery/ from Drive.
- Viewing, organizing, and managing scanned documents.
- Options to rename, delete, or share scanned documents.

### 4. UML Use Case Diagram

![MDS DIAGRAMA](https://github.com/letitiatel/Snap-Doc-App/assets/116514235/d5b29f16-0cd9-4e9c-8b53-a4bfeb3a1169)

### 5.  App's behaviour description

Snap&Doc allows users to scan text from photos taken instantly or from the gallery. Once the text is extracted, it can be converted into various formats such as PDF, DOCX, and more. Users can edit the extracted text to correct any errors before conversion. Here is a detailed breakdown of how the app works:

1. Scanning a Document:

- The user can opt to take a new photo or select an existing one from the gallery.
- The app will scan the photo and use OCR (Optical Character Recognition) technology to extract the text.

2. Building a List of Extracted Words:

- The extracted text is organized into a list format, displaying the words extracted from the scanned photo. This list can be used for further processing or conversion into various document formats.

3. Editing the List:

 - Users can modify the list to correct any mistakes by adding new words, deleting incorrect ones, or clearing the entire list. 

4. Finalizing the List:

- Once the list is accurate, users can review the extracted words and make any final adjustments. After confirming the list, users can proceed to convert the text into their desired format, such as PDF, DOCX, etc.

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
     
    



     
      
      
     





 
     

  





    


  



