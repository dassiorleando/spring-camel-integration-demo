# Spring Apache Camel Integration Demo

Just a demo project to showcasing Spring Boot and Apache Camel integration capabilities.

Every time a new “file” is added to a folder, upload it to “AWS S3”, send an SMS notification to a specified phone number using “Twilio”, and send a message to a “Slack” channel.

How it Works?
- **Camel** is used for the integration within a **Spring Boot** project.
- Processing files are saved in the **files/processing** folder.
- Processed files are saved in the **files/processed** folder.
- The **Camel Components** involved are: file, aws2-s3, slack, and twilio.

## Prerequisites

- Java 17 or newer version is needed to build and run the project.
- The folder named **files** should be created at the root of the project.
- Provide environment variables or fill in the credentials in the **application.properties** file.
- Create the bucket "demo-camel-bucket" on **AWS S3**.
- Set up a **Slack** token that can publish a message to the **general** channel.

## Build

The compilation is triggered by running `./mvnw clean install -DskipTests`.

## Run

To run the project, use the command `./mvnw spring-boot:run`.

## API Doc

The API Doc is accessible at: http://localhost:8282/api/doc

MIT
