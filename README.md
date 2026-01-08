# Java Search Service Assignment

# Overview
This project implements a microservice-based Search Service that fetches product data
from an external Inventory Service using REST APIs.
The Search Service filters products priced under $50 using Java Stream API
and returns a sorted list of product names.
The application follows a clean microservices architecture where each service
has a single responsibility and communicates over HTTP.

# Microservices Architecture & Communication

This project consists of two independent Spring Boot microservices:

# Communication Approach
- Type: Synchronous communication
- Protocol: REST over HTTP
- Client Used: Spring `RestTemplate`

The Search Service makes a synchronous HTTP call to the Inventory Service.
It waits for the response before processing the data.
This approach is suitable for simple request-response use cases and aligns
well with the assignment requirements.

# Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- REST APIs

# Microservices
# 1. Inventory Service
- Stores product data in MySQL
- Exposes REST API to fetch products

**Endpoint** (postman testing)
i. POST localhost:8081/api/products
raw -> body (JSON)
{
  "name": "LAN Wire",
  "price": 50
}
Like this add multiple products, with price less than and greater than 50, dont give id, as it is auto-generated

ii. GET localhost:8081/api/products
this will get all the products which are stored in DB(MySQL).


# 2. Search Service
- Consumes Inventory Service APIs
- Uses synchronous REST communication via RestTemplate
- Applies Java Stream API to process product data

# Internal Flow :-
Calls Inventory Service /api/products
Filters products with price < $50
Extracts only product names
Sorts the result alphabetically
Returns final list to client

**Endpoint** (postman testing)
i. GET localhost:8080/api/search/products-under-50
in response you will get all the products whose price are less than 50$
for eg -
[
  "LAN Wire",
  "USB Cable",
  "Wireless Mouse"
]


#How to Run
1. Start MySQL and create database `inventory_db`
   in the applications.properties(inventory-service) section replace with your username and password (mysql credentials)
   and also before running the app for the first time change the spring.jpa.hibernate.ddl-auto=update -> spring.jpa.hibernate.ddl-auto=create so that you would be be getting product table created at mysql inventory-db. then stop the service and again change spring.jpa.hibernate.ddl-auto=create -> spring.jpa.hibernate.ddl-auto=update. then restart the service.

2. Navigate to inventory-service directory -> open editors cmd -> cd inventory-service -> mvn spring-boot:run ->
   Inventory Service will start on (port 8081).

3. Navigate to search-service directory -> open editors cmd -> cd search-service -> mvn spring-boot:run ->
   Search Service will start on (port 8080)

# Author :-
Ronit Dalal MCA | Java Full Stack Developer 
Email - dalalronit131@gmail.com 
LinkedIn - https://www.linkedin.com/in/ronit-dalal-4b4157267/ 
Github - https://github.com/ronitdalal27 
mob no - 8010166496.

