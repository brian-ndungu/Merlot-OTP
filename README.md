# MERLOT-OTP

We are group 15 and have been tasked with designing and implementing the OTP subsystem of the new generation ATM. We will be interacting with the Authentication subsystem to receive a client ID to generate an OTP for, the Notification Subsystem in which we will pass the OTP to be send to a client and we will interact with the ATM Subsystem that in which we will process the input and verify if the OTP's match.

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

## Running the tests

Explain how to run the automated tests for this system

### Break down into end to end tests

The tests involved within this OTP module include the various Test Cases such as:
- Successful OTP input
- Notification Exceptions
- ATM Exceptions
- Incorrect inputs

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## Versioning

We use [SemVer](http://semver.org/) for versioning. For the versions available, see the [tags on this repository](https://github.com/your/project/tags). 

## Authors

Brian Ndung'u (Integration Lead)
Dylan Schwikkard (Software Testing and Documentation)
Theoveshen Naidu (Project Manager)
Tlou Lebelo (Software testing Lead)
Alessio Rossi (Documentation Lead)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
