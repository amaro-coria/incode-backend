# Spring Boot Transformer Application

This project is a Spring Boot web application that provides a service to apply a series of transformations to strings. The application exposes an endpoint to accept a collection of elements, each with a string value and a list of transformers to be applied to that value.

## Features

- Accepts a collection of elements with string values and a list of transformers.
- Supports three types of transformers:
    - **RegexRemoveTransformer**: Removes substrings matching a regex pattern.
    - **RegexReplaceTransformer**: Replaces substrings matching a regex pattern with a replacement string.
    - **CyrillicGreekToLatinTransformer**: Converts Cyrillic and Greek characters to their Latin equivalents.
- Applies transformers in the specified order and returns the original and transformed values.

## Getting Started

### Prerequisites

- Java 17
- Maven 3.6.3+
- Docker (for containerization)

### Building and Running

1. **Clone the repository**

    ```bash
    git clone https://github.com/yourusername/spring-boot-transformer-app.git
    cd spring-boot-transformer-app
    ```

2. **Build the project**

    ```bash
    mvn clean package
    ```

3. **Run the application**

    ```bash
    java -jar target/app.jar
    ```

4. **Access the application**

   The application will be running at `http://localhost:8080`.

### Docker

To build and run the application using Docker:

1. **Build the Docker image**

    ```bash
    docker build -t amarocoria/spring-boot-app .
    ```

2. **Run the Docker container**

    ```bash
    docker run -p 8080:8080 amarocoria/spring-boot-app
    ```

### API Usage

**Endpoint**: `/transform`

**Method**: POST

**Request Body**:

```json
{
  "elements": [
    {
      "value": "This is some Random Text 123",
      "transformers": [
        {
          "group": "group1",
          "transformerId": "t1",
          "parameters": ["\\d+"]
        },
        {
          "group": "group1",
          "transformerId": "t2",
          "parameters": ["Random", "Replaced"]
        }
      ]
    },
    {
      "value": "Example with Greek: ΑΒΓ and Cyrillic: АБВ",
      "transformers": [
        {
          "group": "group1",
          "transformerId": "t3",
          "parameters": []
        }
      ]
    }
  ]
}
```
**Response Body**:
``` json
{
  "elements": [
    {
      "original": "This is some Random Text 123",
      "transformed": "This is some Replaced Text "
    },
    {
      "original": "Example with Greek: ΑΒΓ and Cyrillic: АБВ",
      "transformed": "Example with Greek: ABG and Cyrillic: ABV"
    }
  ]
}

```
### Development ###
#### Running Tests ####
To run the unit tests:
``` bash
mvn test
```

### GitHub Actions CI/CD ###
The project is set up with GitHub Actions for CI/CD. The workflow file is located at .github/workflows/ci.yml and includes steps to:

Checkout the code.
* Set up JDK 17.
* Cache Maven dependencies.
* Build the project.
* Run tests.
* Build and push the Docker image to Docker Hub.
* Secrets for GitHub Actions
* Make sure to add the following secrets in your GitHub repository settings:
* DOCKER_USERNAME: Your Docker Hub username.
* DOCKER_PASSWORD: Your Docker Hub password or access token.