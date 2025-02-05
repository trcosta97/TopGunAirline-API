# About this repo

This is a study project that simulates an Airline API and a website that consumes it. The API was built using Java 17 and the Spring Boot framework, with Gradle as the dependency manager.  
For the frontend, I chose the React JS framework.  
Once again: this project was developed for studying purposes, so any comments or criticism are more than welcome.  

# Businnes Rules

- The user email is unique;  
- The user password can't match it's email;  
- The user password must contain letters and numbers;  
- A flight can't have it's destination matching it's origin or the other way around;  
- A flight date can't be retractive;
- A reservation can't have more seats than it's flight have available;  

# How to init the project

First you need to start the API. Open it with your favorite IDE (I used JetBrains IntelliJ). then run the build command in the command line:
```console
  gradle build
```

After that, run the main file:

![Captura de tela 2023-06-19 172305](https://github.com/trcosta97/top-gun-airline/assets/101136329/dc782590-9d85-409a-bfc5-0a5eed25e41c)


Now that the API is running, we have to initiate the front end application.  
Again: open the project in your favorite IDE and run the start command:

```console
  npm run dev
```

# Endpoints

## User

POST /user
```console
  {
  "name": "string",
  "adress": {
    "zipCode": "string",
    "number": "string",
    "country": "string"
  },
  "email": "string",
  "password": "string"
}
```
PUT /user/{id}
The {id} is a requested param that defines the user to be updated and isn't included in the json. 
```console
  {
  "name": "string",
  "adress": {
    "zipCode": "string",
    "number": "string",
    "country": "string"
  },
  "email": "string",
  "password": "string"
}
```

GET /user/{id}  
Returns the user with the provided id.  

GET /user/all  
Returns all the active users.  

DELETE /user/{id}  
Deactivate the user but maintains it on the database.  

## Flight

POST /flight
```console
  {
  "flightDate": "YYYY-MM-DD",
  "origin": "Airport",
  "destination": "Airport",
  "availableSeats": 0
}
```

PUT /flight/{id}
```console
{
  "flightDate": "2023-06-19",
  "origin": "GRU",
  "destination": "GRU",
  "availableSeats": 0
}
```

GET /flight/{id}  
Returns the flight with the provided id.  

GET /flight/all  
Returns all the active flights.  

GET /flight/origin  
Returns all the active flights by origin.  
 
GET /flight/destination  
Returns all the active flights by destination.  

DELETE /flight/{id}  
Deactivate the flight but maintains it on the database.  

## Reservation

POST /reservation
```console
{
  "flightId": 0,
  "userId": 0,
  "numberOfSeats": 0,
  "payment": {
    "userId": 0,
    "value": 0,
    "typeOfPayment": "CREDIT"
  }
}
```

PUT /reservation/{id}
```console
{
  "numberOfSeats": 0
}
```

GET /reservation/{id}   
Returns the reservation with the provided id.  

GET /reservation/all  
Returns all the active reservations.  

DELETE /reservation/{id}  
Deactivate the reservation but maintains it on the database.  

## Payment 

PUT payment/{id}

```console
  {
  "userId": 0,
  "value": 0,
  "typeOfPayment": "TYPE OF PAYMENT"
}
```

GET /payment/{id}    
Returns the payment with the provided id.  

GET /payment/all  
Returns all the active payments.  

DELETE /payment/{id}  
Deactivate the payment but maintains it on the database.  
