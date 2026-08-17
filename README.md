# Readscape 📚

**Readscape** is a Java console application designed to manage an ebook library with ambient tracks, categories, and full catalog metadata. Built using an **MVC (Model-View-Controller)** architecture and **JDBC**, it connects directly to a MySQL database for complete CRUD operations.

---

## 🚀 Features

* **View Catalog:** List all ebooks stored in the database.
* **Search:** Filter ebooks by title keyword.
* **Add Books:** Insert new ebooks complete with file paths, prices, page counts, cover images, categories, and ambient tracks.
* **Update Details:** Modify existing book entries safely by ID.
* **Delete Books:** Remove records from the database by ID.
* **Console UI:** Clean CLI interface with Scanner buffer flushing to prevent input skipping.

---

## 🛠️ Tech Stack & Prerequisites

* **Language:** Java (JDK 8 or higher)
* **Database:** MySQL Server
* **Driver:** MySQL Connector/J (`mysql-connector-j.jar`)

---

## 📁 Project Structure

```text
Readscape/
├── lib/
│   └── mysql-connector-j.jar   # MySQL JDBC Driver
├── src/
│   ├── config/                 # Database connection config
│   ├── dao/
│   │   └── BookManager.java    # Data Access Object (CRUD logic)
│   ├── model/
│   │   └── Ebook.java          # Ebook Data Model
│   ├── service/
│   │   └── Main.java           # Main application entry point
│   └── ui/
│       └── BookConsoleUI.java   # Terminal UI and user interaction
└── README.md
