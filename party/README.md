# Party Component – Moqui Framework

## Overview
This component is a custom implementation built on the **Moqui Framework** to manage Party-related data such as persons, organizations, and their contact mechanisms.

The component demonstrates:
- Creating a custom Moqui component
- Defining entities using Moqui entity XML
- Loading seed data
- Verifying entities through Moqui Entity Tools
- Proper use of Git and GitHub for version control

---

## Technologies Used
- **Java JDK 11**
- **Moqui Framework**
- **MySQL 8.x**
- **MySQL Connector/J**
- **Gradle**
- **Git & GitHub**

---

## Component Structure
# Party Component – Moqui Framework

## Overview
This component is a custom implementation built on the **Moqui Framework** to manage Party-related data such as persons, organizations, and their contact mechanisms.

The component demonstrates:
- Creating a custom Moqui component
- Defining entities using Moqui entity XML
- Loading seed data
- Verifying entities through Moqui Entity Tools
- Proper use of Git and GitHub for version control

---

## Technologies Used
- **Java JDK 11**
- **Moqui Framework**
- **MySQL 8.x**
- **MySQL Connector/J**
- **Gradle**
- **Git & GitHub**

---

## Component Structure
party/
├── component.xml
├── entity/
│ └── PartyEntities.xml
├── data/
│ └── PartySeedData.xml
└── README.md


---

## Step 1: Create Custom Component
- A new component named `party` was created under:

runtime/component/party
- The component was registered using `component.xml`.

## Step 2: Entity Definitions
The following entities were defined in `PartyEntities.xml`:

### Core Entities
- **Party**
- **Person**
- **PartyGroup**
- **ContactMech**
- **PartyContactMech**

These entities follow proper Moqui and Java naming conventions and are visible in:

Applications → Tools → Entity → Entities

---

## Step 3: Seed Data
Sample data was added using `PartySeedData.xml`, including:
- A PERSON party with contact mechanisms
- A PARTY_GROUP entity
- Email and phone contact records

Data was loaded using:
- Moqui **Entity → Import Tool**
- Or `gradlew load` (when applicable)

---

## Step 4: Verification
- All entities are visible in **Entity Tools**
- Tables were successfully created in MySQL
- Seed data is available and queryable

---

## Version Control
- Changes were committed with meaningful commit messages
- The component is maintained as a standalone GitHub repository

---

## Author
**Aruni Sharma**


