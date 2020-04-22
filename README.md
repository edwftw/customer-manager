### Development
Inside `customer-manager` folder
Generate the .jar:
```sh
$ ./gradlew build
```

After, create docker container with the application, mongo-express and mongo
```sh
$ docker-compose up
```

It's done. The application is running on (http://localgost:8080).

To test, just do a request on (http://localgost:8080/customers)
