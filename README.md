# Polls API

 
### Steps to Setup the Spring Boot App

 1. **Clone the application**
 
     ```bash
     git clone https://github.com/madthreed/polls_api.git
     ```
 
 2. **Create Postgresql or another database**
 

 3. **Change DB url, username and password**
 
     + open `src/main/resources/application.yml` file.
 
     + change `spring.datasource.username` and `spring.datasource.password` properties
 

 4. **Run the app**
 
     You can run the spring boot app by typing the following command -
 
     ```bash
     mvn spring-boot:run
     ```
 
     The server will start on port 8080.


 5. **Check SWAGGER API documentation**

     ```bash
     {app_base_url:port}/swagger-ui
     ```
 
 6. Docker image pull command

    ```bash
    docker pull madthreed/polls_api:latest
    ```
