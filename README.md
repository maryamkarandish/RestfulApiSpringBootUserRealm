# UserRealm Application version 1.0  
### Date : 14/06/2019

## Description
-------------------

* The test is designed to provide an indicator of technical level.
* the assignment is looking for the right approach and appropriate considerations, not a business-ready solution. 
* The application should be implemented as a Java web-app using Spring Boot RESTful MVC, store data in a relational database, and be deployable to Tomcat. 
* The APIs support the creation and retrieval of representations of a User Realm.
* A User Realm is a context for the registration and authentication of a user, which comprises a unique integer identifier, a unique name, an (encryption) key and a description.


## Assumptions
-------------------
For the purposes of this exercise all that is required is to implement APIs to create (store)
and retrieve the entity:
● JSON and XML representations must be supported.
● No security (authentication or authorisation) checks are required on the APIs. The
code for generating the encryption key can be stubbed, returning any string.

* If the user requested realm id is not an integer value it should throw error.
* If the mandatory realm name is not supplied it should throw error

## Purposes
-------------------
- _Create Realm_ Creates a new realm including the generation of an encryption key. 
- _Get Realm_ Returns the details of an individual realm, identified by its unique id.

## About Project
---------------------------

- It is developed by Java language
- The project uses the JDK 8 
- It is essencial to install Maven before running the project
- it is deployable with Apache tomcat 9
- it is tested with unit testing with the coverage of 100% for the classes and 70% for the methods.

## About Project
---------------------------

To run the project after deploying it with Apache tompcat, use the url as below :
http://localhost:8080/brighttalk/service/user/realm


for more information you can contact:
--------------------------------------
maryam.karandish4@gmail.com
+98 936 769 3346
