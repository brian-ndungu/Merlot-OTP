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

The application will be deployed through the Heroku online tool that will allow us to host and perform the relevant API calls needed.

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Authors

Brian Ndung'u (Integration Lead)
Dylan Schwikkard (Software Testing and Documentation)
Theoveshen Naidu (Project Manager)
Tlou Lebelo (Software testing Lead)
Alessio Rossi (Documentation Lead and Project Management)

## API information

The API calls we have used are all POST based in that we will be posting the information to the relevant subsystems. The API's are seperated into two types that will be used to namely send information to the Notification subsystem as well as the Authentication subsystems.

The API calls will send JSON structured data through to the relevant subsystems in which they will perform the tasks required.

OTP generation will be sent, via the API, to the Notifications subsystem in the format:
            {
               "clientID" : 7,
               "type" : "generate"
            }
whereby the type is generate to actually create the OTP relevant to a specific clientID. This information, regarding the clientID is passed to our subsystem by the Authentication subsystem. Within this process, we generate an OTP that will be used to verify an action and we will store it within our system for later verification.

OTP validation, send to the Authentication subsystem, will follow a similar structure and will create the object in the following format:
            {
               "clientID" : 7,
               "type" : "validate",
               "pin" : "pin"
            }
whereby the type will inform the subsystems that receieve the request of the action being performed. The information is once again received from the Authentication subsystem and we are tasked with validating that the correct OTP is enetered to the specific clientID. A reponse code is returned to the Authentication subsystem dictating whether it was successful or not.





