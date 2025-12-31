# HotelRatingSystem
HotelRatingSystem: HotelRatingSystem is a Spring Boot–based microservices application designed to manage users, hotels, and ratings in a scalable and loosely coupled architecture. The system follows cloud-native principles using service discovery, centralized routing, and fault tolerance.

🧱 Microservices Architecture

The system consists of the following independent services:

🔹 User Service

Manages user profiles and basic user information

Communicates with Hotel and Rating services to fetch aggregated data

Exposes REST APIs for user operations

🔹 Hotel Service

Manages hotel details such as name, location, and description

Provides hotel data to other services via REST endpoints

🔹 Rating Service

Handles hotel ratings and feedback provided by users

Stores and exposes rating data linked to users and hotels

🚪 API Gateway

Implemented using Spring Cloud Gateway

Acts as a single entry point for all client requests

Performs dynamic routing using service discovery (lb://SERVICE-NAME)

Supports cross-cutting concerns like logging, filtering, and future security integration
