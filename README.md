# 📝 Comment Sentiment Analyzer

A **Spring Boot-based** project that integrates **AWS Comprehend** to analyze the sentiment of user comments — detecting **Positive, Negative, Neutral, or Mixed** tone — with a clean and modular architecture.

---

## 🚀 Features

- **Sentiment Analysis** powered by **AWS Comprehend**  
- **Database Integration** with **AWS RDS / MySQL**  
- **Centralized Logging** using **Logback**  
- **Secure Configuration** for AWS and DB  
- **Exception Handling** with custom error responses  
- **Swagger Integration** for API exploration  

---

## 🖼️ Project Architecture

<img width="3840" height="1771" alt="Comment-Sentiment_Project_Flow" src="https://github.com/user-attachments/assets/8b549211-60e1-440c-9101-b78ca43e3d10" />

---

## ⚡ Tech Stack

| Layer             | Technology             |
|-------------------|-----------------------|
| **Language**      | Java 17 |
| **Framework**     | Spring Boot 3 |
| **Cloud Service** | AWS Comprehend |
| **Database**      | MySQL (AWS RDS) |
| **Logging**       | Logback |
| **Docs**          | Swagger / OpenAPI |

---

## 🛠️ Setup & Installation

### **1. Clone the repository**
```bash
git clone https://github.com/gautamkr538/CommentSentimentAnalyzer.git
cd CommentSentimentAnalyzer

2. Configure AWS Credentials
Update your application.properties:
properties
Copy
Edit
aws.accessKey=YOUR_AWS_ACCESS_KEY
aws.secretKey=YOUR_AWS_SECRET_KEY
aws.region=us-east-1
spring.datasource.url=jdbc:mysql://<your-db-host>:3306/comments_db
spring.datasource.username=your_db_user
spring.datasource.password=your_db_password

3. Build and Run
bash
Copy
Edit
mvn clean install
mvn spring-boot:run
