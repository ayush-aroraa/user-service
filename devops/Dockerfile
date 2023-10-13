FROM openjdk:17-alpine

WORKDIR /usr/src/app
ENV AWS_SECRET_NAME=/api/dev/secret

ENV AWS_DEFAULT_REGION=ap-south-1

RUN apk add --no-cache  \
    maven

COPY . .

RUN mvn clean install

# Setting up work directory

RUN ls -al

RUN ls -al target && pwd

# Copy the jar file into our app
#COPY target/user-service-0.0.1-SNAPSHOT.jar /usr/src/app

# Exposing port 8001
EXPOSE 8001

# Starting the application
CMD ["java", "-jar", "target/user-service-0.0.1-SNAPSHOT.jar"]
