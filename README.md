# Melifera Ecommerce API 


## Summary
The webplatform is designed to allow users to upload advertisements for bee products, services and related items. However, in order to provide a secure and controlled environment, the administrator has the right to monitor and manage these ads and users.

<img width="600" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/6263fe23-d3ca-486d-b8d2-f07c5dc7303a">

> **Warning**
> This project is still in development and is not ready for production use.
## Features:

#### For Users:

 1. can see all categories and ads corresponding to the category
 2. can see all active ads
 3. can see his active ads and archive them
 4. can see his archived ads
 5. can create an ad

#### For Admin:

 1. can see the site statistics (number of active ads, users
 categories, etc.)
 2. can see all categories and delete them
 3. can add a category
 4. can see all active users and deactivate them
 5. can see all deactivated users and activate or delete them
 6. can see all active ads and deactivate them
 7. can see all archived ads and activate or delete them


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
<img width="496" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/4be5723b-84d3-42bc-916b-7a4edae8ce40">

* CategoryAPI
<img width="492" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/ae808268-87e0-41c6-8c0b-496ae5fa8a75">

* UserAPI
<img width="491" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/6cdf8114-10e1-4d90-a69f-64b91f8e7b4c">

* UserDetailsAPI
<img width="479" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/bc246969-d012-42e4-baaf-2f91e85b204a">

* EmailAPI
<img width="490" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/c3981009-5c34-4716-9612-b3cee97d6d1b">

* ImageAPI
<img width="489" alt="image" src="https://github.com/dzhanrafetov/Melifera/assets/49691399/f564e263-1cce-44f2-baf1-0d244f468152">

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
&nbsp;Maven for downloading dependencies
  
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






