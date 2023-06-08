Overview

Since the blip happened in 2018, there has been a steady stream of reported mutants in the universe.
Task is to write an application to keep track of all known mutants on Earth. Each mutant
belongs to one of several categories according to their powers: freeze, flight, fire, telepathy, strength,
magic, and others; their overall ability is measured by an integer between 0 and 100. Application
will collect information about a set of mutants and store their attributes in a JSON file.

Client-server model is used. The server will be running a Spring application using Tomcat
providing a REST API, while the client will be implemented using a JavaFX User Interface that allows
users to look up and augment the existing data.

Data: application will keep all known mutants in a JSON file called mutant.json and in a folder
called ‘data’. This file is used to collect information about the mutants. The  attributes for the Mutants are id (a
unique identifier for a mutant), name, weight, height, category (i.e., freeze, flight, fire, telepathy,
strength, magic, etc), and overall ability.

Features: 

1. The ability to add new mutants (with corresponding attributes).

2. The ability to delete any of the mutants.

3. The ability to display all mutants currently in the mutant.json file and then let the user will click on the image to reveal more information.

4. The ability to display information about a specific mutant. A link is provided from each of the Mutants currently in the system.



Architecture


The Server that provides a REST API for the application listens for client
requests on port 8080 and update the server accordingly, returning (responding with) the desired
information to the client. This includes updating the mutant.json file if needed.

Client-side application written in JavaFX that is responsible for providing a user
interface and making client calls to the server.

Server (REST API),

Responsibilities:

All commands return HTTP 200 (OK) unless otherwise stated.
Any end-point accepting an ID  return an HTTP 404 error with a meaningful message if the ID
does not exist.

The REST API for the application have the following endpoints:

a)GET /api/mutant/all

 Returns a list of all Mutant objects in the mutant.json file. This includes all attributes associated with
each object.

b)GET /api/mutant/{id}

Returns an object corresponding to a mutant with the specified id. For example, /api/mutant/3 would
return the Mutant object corresponding to id=3.

c)POST /api/mutant/add

 Create a new Mutant.
 Returns HTTP 201: Created.
 Expected body contents include all attributes of the new Mutant.

d)DELETE /api/mutant/{id}

 Removes the mutant with the specified id.
 Returns HTTP 204: No content.
