# Quizzer

Quizzer is a RESTful API for creating and taking quizzes, built with Spring Boot, JPA, and PostgreSQL. It allows you to manage quizzes and questions, and calculate results based on user responses.

## Features
- Create quizzes with random questions from a selected category
- Add and manage questions with multiple options and difficulty levels
- Retrieve quizzes and their questions
- Submit answers and get results
- Filter questions by category

## Technologies Used
- Java 17+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6.3 or higher
- PostgreSQL database
- Postman or any API testing tool
- IDE (IntelliJ IDEA, Eclipse, etc.)
- Git
- Docker (optional, for running PostgreSQL in a container)

### Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone <repo-url>
   ```
2. **Navigate to the project directory**:
   ```bash
   cd Quizzer
   ```
3. **Configure the database**:
   - Create a PostgreSQL database named `quizzer`.
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/quizzer
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     
     spring.security.user.password=<customizable_password>
     spring.security.user.name=<customizable_username>
     ```
     - Spring Security is enabled by default with a customizable username and password. You can change these values as needed.
     - Use basic authentication to configure security for the API endpoints.
     - If you want to disable Spring Security, you can comment out the `spring.security.user.name` and `spring.security.user.password` lines in the `application.properties` file.
     - 
4. **Build the project**:
   ```bash
   mvn clean install
   ```
5. **Run the application**:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints

>[!Postman Document}
> https://documenter.getpostman.com/view/42363796/2sB3BDKrEH

### Quiz Endpoints
- `POST /quiz/create?category={category}&numQ={numQ}&quizTitle={title}`: Create a new quiz
- `GET /quiz/get/{id}`: Get quiz questions by quiz ID
- `POST /quiz/submit/{id}`: Submit answers and get result

### Question Endpoints
- `GET /questions/allQuestions`: Get all questions
- `GET /questions/category/{category}`: Get questions by category
- `POST /questions/add`: Add a new question

## Example Usage
You can use Postman or any API client to interact with the endpoints. See the API section above for details.

## Project Structure
- `controller/`: REST controllers for quizzes and questions
- `service/`: Business logic for quizzes and questions
- `dao/`: Data access layer using Spring Data JPA
- `model/`: Entity and DTO classes

## License
This project is open source and available under the MIT License.
