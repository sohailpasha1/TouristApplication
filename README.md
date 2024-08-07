# Hands-On Guide: Developing a Tourist Management App with Spring Boot

## Understanding Spring Boot Components Through a Real-World Application

## Tourist Application Overview

We’re going to build a tourist management app with Spring Boot. Here’s how it will work:

**What It Does:** The app keeps track of tourists and their details like name, age, where they’re from, and how long they’re staying.

**Main Components:**

- **Tourist Entity:** This defines what information we store about each tourist, such as their ID, name, gender, age, and visit details.  

  **Field Purpose:**
  - `touristId`: Unique identifier for each tourist.
  - `name`: Name of the tourist.
  - `gender`: Gender of the tourist.
  - `age`: Age of the tourist.
  - `fromPlace`: Place from which the tourist is coming.
  - `numberOfDaysVisits`: Duration of the visit in days.
  - `createdDate`: Date when the tourist entry was created.

- **Controller:** The part of the app that handles requests:
  - **Register Tourist:** Lets you add new tourists.
  - **Find Tourist by Name:** Retrieves a list of tourists based on their name.
  - **Update Tourist:** Updates existing tourist information.
  - **Find Tourist by ID:** Retrieves a specific tourist using their ID.
  - **Delete Tourist:** Removes a tourist based on their ID.

- **Service Layer:** Manages the main logic for adding, finding, and deleting tourists, including handling errors like age limits or missing records.

- **Repository:** Uses Spring Data JPA to handle database operations.
