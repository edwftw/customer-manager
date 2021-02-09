That's a simple project to implement tests with Spock Framework: http://spockframework.org/spock/docs/1.3/all_in_one.html

### Development
Inside `customer-manager` folder
Generate the .jar:
```sh
./gradlew build
```

After, create docker container with the application, mongo-express and mongo
```sh
docker-compose up
```

It's done. The application is running on http://localhost:8080

To test, just do a request on http://localhost:8080/customers

To delete/destroy docker containers created, just run:
```sh
docker-compose down --rmi local
```