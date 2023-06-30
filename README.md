# Melifera Ecommerce API 
   # `Spring Boot and Thymeleaf Ecommerce Application`


## Summary
The webplatform is designed to allow users to upload advertisements for bee products, services and related items. However, in order to provide a secure and controlled environment, the administrator has the right to monitor and manage these ads and users.


<img width="550" height="330"  alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/76248e64-e7a7-4c47-9019-6f399ba7017e">
<img width="452" height="330" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/d045cb25-4084-4aee-a714-ec4dcaeadd8f">



> **Warning**
> This project is still in development and is not ready for production use.
## Features:

#### For Users:

 1. can see all categories and ads corresponding to the category
   <img width="452"  height="253" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/7dc351cc-c856-4f22-8897-3ed18d777f9c">
   <img width="452" height="253" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/2727163b-7c21-45bb-ba28-d1c94fd8922d">


 2. can see all active ads
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/f5fc04f7-1c87-429d-9c27-a877c9c61bfb">

 3. can see his active ads and archive them
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/090b8599-9bef-4342-b782-64b3dca6fc9b">

 4. can see his archived ads
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/a0bf8db2-be35-4f54-85dc-efceef2a21eb">

 5. can create an ad
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/a33104b0-0a9a-432e-bd10-376091ac2c01">


#### For Admin:

 1. Can see the site statistics (number of active ads, users
 categories, etc.)
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/fc93cd92-ad1e-4250-abac-e40def0cb9d3">

 2. Can see all categories and delete them
<img width="452" height="275" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/7e660f49-63d8-41b6-b688-f1e5bb63b77f">

 3. Can add a category
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/80fd8d33-eb7e-454b-ad03-4da81460ece2">

 4. Can see all active users and deactivate them
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/d4775973-6b53-48f9-9567-13927bab8ac6">

 5. Can see all deactivated users and activate or delete them
<img width="452" height="265" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/f7f7bc03-cb90-406e-87eb-05d1fc0bd261">

 6. Can see all active ads and deactivate them
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/9055cb08-9784-4e57-85df-322db542d85c">

 7. Can see all archived ads and activate or delete them
<img width="452" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/ae17ad88-8401-40de-a898-67be6a83eaa4">


## Documentation
The project includes documentation in the Bulgarian language, located in the `documentation` folder. You can refer to this   
documentation for detailed information about the project.

## Installation

### 1. Clone the repository
```
git clone https://github.com/dzhanrafetov/Melifera
```

### 2. Open the project

```
File -> Open -> The `pom.xml` file from the project folder -> Open as project
```
### 3.Database Connection

- Make the connection to the MySQL database. 
- If desired, you can insert the `SQL` file from the database folder.

### 4.Configure

 - Configure your email to enable sending emails for verification [Gmail Settings](https://mail.google.com/mail/u/0/#settings/general)
 - Set the local variables for the email data, such as email and password, by introducing local variables from the `MailConfig` file.

## Application APIS

### The application has 7 APIS:
* AdvertisementAPI
<img width="284" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/54c1750d-efc0-4119-994c-f673d5d87f16">

* CategoryAPI
<img width="287" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/8c55cf26-ee04-4345-b2e9-4c8b7983a924">

* UserAPI
<img width="286" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/fbccaebc-1d46-4d0b-bd3d-fdc3c00be489">

* UserDetailsAPI
<img width="286" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/ecc24e6d-0e95-4113-8242-df340cacf88b">

* EmailAPI
<img width="286" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/6b26b56e-76af-4d13-9c96-cf323a01030d">

* ImageAPI
<img width="286" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/0e882f25-50ab-41a2-89b2-e362a3480a02">

* ThymeleafApi
* `contains APIs that have similar functionality to the other APIs in the project. However, they are separated into a distinct API because they specifically return models that are designed for rendering with the Thymeleaf frontend framework. This separation allows for better organization and encapsulation `


## Tech Stack

- <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg" title="Java" alt="Java" width="34" height="40"/>&nbsp;Java 
- <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg" title="Spring" alt="Spring" width="30" height="30"/>&nbsp;Spring Boot
- <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg" title="Spring" alt="Spring" width="30" height="30"/>&nbsp;Spring Data JPA and Hibernate
- <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg" title="Spring" alt="Spring" width="30" height="30"/>&nbsp;Spring Security for authentication and authorization
- <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg" title="Spring" alt="Spring" width="30" height="30"/>&nbsp;Spring Validation for validation
- <img src="https://github.com/devicons/devicon/blob/master/icons/spring/spring-original.svg" title="Spring" alt="Spring" width="30" height="30"/>&nbsp;Spring EmailSender for sending verification emails
- <img src="https://github.com/devicons/devicon/blob/master/icons/mysql/mysql-original.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp; MySQL Database
- <img src="https://static-00.iconduck.com/assets.00/postman-icon-497x512-beb7sy75.png" title="Java" alt="Java" width="33" height="33"/>&nbsp;Postman for API testing
- <img src="https://www.thymeleaf.org/images/thymeleaf.png" title="Java" alt="Java" width="33" height="30"/>&nbsp;Thymeleaf, HTML and CSS for frontend
- <img src="https://github.com/dzhanrafetov/Melifera/assets/49691399/af19ce86-c144-4421-b644-d82d7e27a41c" title="Java" alt="Java" width="60" height="30"/>&nbsp;Maven for downloading dependencies
  
## The strengths of the application lie in:
- Account confirmation with email verification
- Responsive and Simplistic design
- Respect for MVC structure
- Dto's are used for transferring data between different layers or components of an application

## Pending :
- [ ]  The frontend will be rewritten to React
- [ ]  Sessions will be added.
- [ ]  The authorization will be changed from Basic Auth to OAuth 2.0.
- [ ]  API calls to list all towns, regions, etc. will be implemented.
- [ ]  Users will be able to make changes to their data such as password, city, number, etc.






