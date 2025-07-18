<h1 align="center">INVENTORY-MANAGEMENT-SYSTEM</h1>
<br>
<p align="center">Transform Inventory, Accelerate Business Growth</p>

<p align="center">
  <img src="https://img.shields.io/badge/last%20commit-today-brightgreen" />
  <img src="https://img.shields.io/badge/java-100.0%25-blue" />
  <img src="https://img.shields.io/badge/languages-1-blue" />
</p>

<p align="center">Built with the tools and technologies:</p>

<p align="center">
  <img src="https://img.shields.io/badge/Markdown-black" />
  <img src="https://img.shields.io/badge/XML-red" />
  <img src="https://img.shields.io/badge/PostgreSQL-purple" />
</p>

<h2>Group Members</h2>

- Vedant Vallal
- Rohit Bansode
- Vinay Maheshwaram

<h2>Table of Contents</h2>

- [Overview](#overview)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Testing](#testing)
  - [Screenshots](#screenshots)

<h2>Overview</h2>

Inventory-management-System is a comprehensive Java-based tool designed to stereamline stock, order,and product management for businesses. It integrates seamlessly with PostgreSQL, Hibernate, and JPA to provide reliable data storage and retrival, ensuring your inventory data is always accurate and accessible.

<h3>Why Inventory-management-System?</h3>

This project aims to simplify inventory workflows and enhance data consistency. The core features include:

- **Database Integration**: Connects with PostgreSQL using Hibernate and JPA for efficient data management.
- **Automated Testing**: Ensures system reliability through comprehensive unit tests.
- **Modular Architecture**: Orchestrates core operations like product management, sales, and user access.
- **Core Entities**: Defines Product, User, and Sale models for seamless data handling.
- **Developer-Friendly**: Facilitates easy extension and intefration within existing systems.


---


<h2>Getting Started</h2>
<h3>Prerequisites</h3>
<p>This project requires the following dependencies:</p>

- **Programming Language**: Java
- **Package Manager**: Maven

<h3>Installation</h3>
<p>Build Inventory-management-System from the source and install dependencies:</p>

1. **Clone the repository**:
   ```
   > git clone https://github.com/Tanishq747Shivasharan/Inventory-management-System
   ```
2. **Navigate to the project directory**:
   ```
   > cd Inventory-management-System
   ```
3. **Install the dependencies**:<br>
   **Using** [Maven](https://maven.apache.org/download.cgi)
   ```
   > mvn install
   ```
   ```
   <!-- My Driver for Postgres -->
    <dependency>
      <groupId>org.postgresql</groupId>
      <artifactId>postgresql</artifactId>
      <version>42.7.1</version>
    </dependency>
    <!-- My hibernate dependency -->
    <dependency>
      <groupId>org.hibernate.orm</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>7.0.1.Final</version>
    </dependency>
    <!-- My JPA API -->
    <dependency>
      <groupId>jakarta.persistence</groupId>
      <artifactId>jakarta.persistence-api</artifactId>
      <version>3.2.0</version>
    </dependency>
   ```

<h3>Usage</h3>
<p>Run the project with:</p>

**Using** [Maven](https://maven.apache.org/download.cgi)
```
> mvn exec:java
```

<h3>Testing</h3>
<p>Inventory-management-system uses the {<b>test_framework</b>} test framework. Run the test suite with:</p>

**Using** [Maven](https://maven.apache.org/download.cgi)
```
> mvn test
```

<h3>Screenshots</h3>

![Project Screenshot](https://github.com/Tanishq747Shivasharan/Inventory-mangement-System/blob/main/inventory-system/images/Screenshot%20(9).png)

[🔝 Return to Top](#INVENTORY-MANAGEMENT-SYSTEM)
