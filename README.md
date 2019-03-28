# MERLOT-OTP (COS301 - 2019)

We as the OTP group, part of the Merlot Team, have been tasked with designing and implementing the OTP subsystem of the new generation ATM. We will be interacting with the Authentication subsystem to receive a client ID to generate an OTP for and the Notification Subsystem in which we will pass the OTP to be send to a client.

## Getting Started

The development of the OTP service package was done using Maven and Jersey (RESTful API Java library).

## Additinal Information
We have determined that we will receive the client ID in the form of a JSON object in which we will parse to retrieve the relevant information.
From there we will prepare JSON objects to send to both the Notification as well as the Authentication subsystems to pass the data and information efficiently.

The JSON objects will take the form of:
OTPObject { "clientID" : "12345",
            "otpNumber" : "678956",
            "status" : "Successful/Unsuccessful",
            "statusMessage" : "Successful/Timeout/IncorrectPin"
          }

### Break down into end to end tests

The tests involved within this OTP module include the various Test Cases such as:
- Successful OTP input
- Notification Exceptions
- Incorrect inputs

## Deployment

Deployment will take the form of being hosted on a server for demonstration purposes, to show the working of a system before it is incorporated into a complete system.

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

Brian Ndung'u (Integration Lead)
Dylan Schwikkard (Software Testing and Documentation)
Theoveshen Naidu (Project Manager)
Tlou Lebelo (Software testing Lead)
Alessio Rossi (Documentation Lead and Project Management)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

