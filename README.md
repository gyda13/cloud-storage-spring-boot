# cloud-storage-spring-boot
### SuperDuperDrive Cloud Storage

#### Udacity Java web developer Nanodegree - first project

## User-facing features

1. Simple File Storage: Upload/download/remove files.</br>
2. Note Management: Add/update/remove text notes.</br>
2. Password Management: Save, edit, and delete website credentials.</br>

### Starter Project
https://github.com/udacity/nd035-c1-spring-boot-basics-project-starter/tree/master/starter/cloudstorage

## Layers of the application

- The back-end with Spring Boot</br>
- The front-end with Thymeleaf</br>
- Application tests with Selenium and JUnit</br>

## The back-end
The back-end is all about security and connecting the front-end to database and actions.

1. Managing User Access with Spring Security
- Restrict unauthorized users from accessing pages other than the login and signup pages, using a security configuration class that extends the WebSecurityConfigurerAdapter class from Spring.
- Implement a custom AuthenticationProvider which authorizes user logins by matching their credentials against those stored in the database.

2. Handling Front-End Calls with Controllers
- Controllers for the application that bind application data and functionality to the front-end. Using Spring MVC's application model to identify the templates served for different requests and populating the view model with data needed by the template.
- Services to support the Controllers.

3. Making Calls to the Database with MyBatis Mappers
- Implement MyBatis mapper interfaces for each of the model types. The mappers have methods that represent specific SQL queries and statements required.

## The Front-End

### Login Page
### Signup Page
### Home Page

## Testing
Using Selenium's driver to navigate the web, interact with elements on the page, and extract data from those elements, and using JUnit's assertions to check the data that is returned against expected values to verify user-facing functionality and prove that the code is feature-complete.
 
### Tests for User Signup, Login, and Unauthorized Access Restrictions
### Tests for Note Creation, Viewing, Editing, and Deletion
### Tests for Credential Creation, Viewing, Editing, and Deletion



