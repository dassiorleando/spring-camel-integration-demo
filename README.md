# Spring Apache Camel Integration Demo

Just a demo project to showcasing Spring Boot and Apache Camel integration capabilities.

## Prerequisites

- Java 17 or newer version is needed to build and run the project.
- The folder named **files** should be created at the root of the project.
- Provide environment variables or fill in the **application.properties** file.
- Create the bucket "demo-camel-bucket" on **AWS S3**.

## How it Works?

- Processing files are saved in the files/processing folder.
- Processed files are saved in the files/processed folder.

## Build

The compilation is triggered by running `./mvnw clean install -DskipTests`.

## Run

To run the project, use the command `./mvnw spring-boot:run`.

## API Doc

The API Doc is accessible at: http://localhost:8282/api/doc

MIT
