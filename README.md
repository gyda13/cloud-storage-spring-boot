# SuperDuperDrive Cloud Storage


#### Udacity Java Web Developer Nanodegree - First Project
#### [Starter Project](https://github.com/udacity/nd035-c1-spring-boot-basics-project-starter/tree/master/starter/cloudstorage)

## User-facing features

1. Simple File Storage: Upload/download/remove files.</br>
2. Note Management: Add/update/remove text notes.</br>
2. Password Management: Save, edit, and delete website credentials.</br>


## Layers of the application

- The back-end with Spring Boot</br>
- The front-end with Thymeleaf</br>
- Application tests with Selenium and JUnit</br>

## 🛠 The back-end
The back-end is all about security and connecting the front-end to database and actions.

### Managing User Access with Spring Security
- Restrict unauthorized users from accessing pages other than the login and signup pages, using a [security configuration class](https://github.com/gyda13/cloud-storage-spring-boot/blob/main/src/main/java/com/udacity/jwdnd/course1/cloudstorage/config/SecurityConfig.java) that extends the WebSecurityConfigurerAdapter class from Spring.
- Implement a [custom AuthenticationProvider](https://github.com/gyda13/cloud-storage-spring-boot/blob/main/src/main/java/com/udacity/jwdnd/course1/cloudstorage/services/AuthenticationService.java) which authorizes user logins by matching their credentials against those stored in the database.


### Handling Front-End Calls with Controllers
- Controllers for the application that bind application data and functionality to the front-end. Using Spring MVC's application model to identify the templates served for different requests and populating the view model with data needed by the template.
- Services to support the Controllers.

### Making Calls to the Database with MyBatis Mappers
- Implement MyBatis mapper interfaces for each of the model types. The mappers have methods that represent specific SQL queries and statements required.

## 🖌 The Front-End

### Login and Signup Pages
https://user-images.githubusercontent.com/90142160/236632969-e0af699c-b9fe-4a2b-8448-b57e18281b65.mov


### Home Page
https://user-images.githubusercontent.com/90142160/236632986-668f16f2-1cc8-454b-b8da-5af15df044f1.mov



## 🧩 Testing
Using Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and using JUnit's assertions to check the data that is returned against expected values to verify user-facing functionality and prove that the code is feature-complete.
 
### 1. Tests for User Signup, Login, and Unauthorized Access Restrictions
https://user-images.githubusercontent.com/90142160/236633526-d20bc70e-85ff-4be5-80f4-9503eaa1c11f.mp4

### 2. Tests for Note Creation, Viewing, Editing, and Deletion
https://user-images.githubusercontent.com/90142160/236633676-7aee0dab-5443-43eb-8b71-eef300e6f5e2.mp4

### 3. Tests for Credential Creation, Viewing, Editing, and Deletion
https://user-images.githubusercontent.com/90142160/236633661-5f298175-78c6-4d30-a8b3-bb6999cb7307.mp4






