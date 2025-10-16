# Internship-Projects2-SpringResutAPI

Project 1:Student REST API
A simple Spring Boot REST API to manage Student records using Spring Data JPA and MySQL. Supports CRUD operations and custom queries.
Features
Add Student: POST /student
Get Student by ID: GET /fetchStudent/{id}
Get All Students: GET /findAll
Delete Student by ID: DELETE /deleteStudent?id={id}
Find Student by Phone: GET /findWithPhone/{phone}
Custom Queries: fetch all students or fetch by phone using JPQL.

Technologies
Java, Spring Boot, Spring Data JPA, MySQL

Setup
Configure database in application.properties.
Run the Spring Boot application.
Test endpoints with Postman or REST client.


Project2:Created REST API using Spring Boot for Employee
Added endpoints —
POST → save employee (insert data)
PUT → update employee
GET → fetch by ID / fetch all / fetch by salary
3️⃣ Made a JPA Repository with custom queries (findBySalary, JPQL queries)
4️⃣ Configured MySQL connection in application.properties
5️⃣ Used Postman to send JSON data → it saved into the database successfully ✅
