
### 📌 **Project: API Testing**

#### **📖 Overview**
This project is designed for **API testing** using **REST Assured, JUnit 5, and Maven**.  
It covers **CRUD operations** and includes **parallel test execution**.

---

## 🛠 **Project Structure**
```
📂 src
 ├── 📂 main
 │    ├── 📂 java
 │    │    ├── epam.com.services       # API Service Layer
 │    │    ├── epam.com.model          # POJOs (User, Address, Geo, Company)
 │    │    ├── epam.com                
 │    │    ├── ── Endpoints            # Class for endpoints
 ├── 📂 test
 │    ├── 📂 java
 │    │    ├── ApiTest.java            # API Test Cases (JUnit 5 + REST Assured)
 │    ├── 📂 resources
 │    │    ├── junit-platform.properties  # JUnit Parallel Config
```

## ✅ **Run Tests**
```sh

mvn test

```

## 🏗 **API Endpoints**
| Method | Endpoint | Description |
|--------|----------|------------|
| `GET` | `/users` | Get all users |
| `GET` | `/users/{id}` | Get a single user by ID |
| `POST` | `/users` | Create a new user |
| `PUT` | `/users/{id}` | Update a user |
| `DELETE` | `/users/{id}` | Delete a user |

---

