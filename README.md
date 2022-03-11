# Mastery Project "Don't Wreck My House"

# Description
> Using everything you've learned in Java Fundamentals, design, implement, and test an application that allows a user
> to reserve accommodations for a guest with a host. Don't Wreck My House is similar to Airbnb. A guest chooses a place
> to stay for a specific date range. If the host location is available, it may be reserved by the guest. Reserved
> locations are not available to other guests during reserved dates.

# High Level Requirements

>- The application user is an accommodation administrator. They pair guests to hosts to make reservations.
>- The administrator may view existing reservations for a host.
>- The administrator may create a reservation for a guest with a host.
>- The administrator may edit existing reservations.
>- The administrator may cancel a future reservation.

# Project Plan

> ### Design:
> 
> Combine Model-View-Controller with Repository+Service designs. Reference sustainable foraging project for examples.
> 
> All layers aware of the Model frameworks. Controller connects View and Service by scripting app loop. View creates the
> visual components based on the Model data. View will use an IO helper to abstract the basics of console IO. Service 
> mimics the Repository Methods, but filters data coming from Controller with validation, and processes data coming
> from Repository into a consumable form for the Controller->View. Repository's only responsibility is reading/writing/
> updating/deleting (CRUD) interactions with the raw data files (csv).
> 
> Ideally, I can allow most validation to be controlled by the Service, rather than writing "try again" loops in the
> View or IO. But IO will still have to control validation up to a certain level due to Java being a strictly typed
> language.

> [X] use csv's to create models (host, guest, reservation, result)
>
> [X] create data-access layer (repositories)
> 
> [X] implement find-by methods
> 
> [X] implement write methods
> 
> [X] implement update methods
> 
> [X] implement delete methods
> 
> [X] create test data-sets
> 
> [X] test data-access

> [X] create domain layer (Service) to control repositories
>

#### Functionality notes guiding Service creation:
#### SELECT - Host or Guest:
1. get search criteria
2. search all
3. filter by criteria
4. select host
#### RESERVATIONS BY HOST:
1. SELECT
2. get all reservations
3. Sort by start date
#### Make new Reservation:
1. SELECT guest
2. SELECT host
3. RESERVATIONS BY HOST, but filtered to future
4. enter start and end dates
5. OVERLAP CHECKER
6. calculate total by day
7. Summary
8. confirmation
9. Add Reservation
#### OVERLAP CHECKER:
1. given host's reservations array
2. given start and end dates
3. loop and return
#### EDIT RESERVATION
1. SELECT host
2. RESERVATIONS BY HOST
3. filter future
4. change date
5. update
#### CANCEL A RESERVATION
1. SELECT host
2. RESERVATIONS BY HOST
3. filter future
4. delete


> ** Update: intending to integrate the field validation into the model setter methods
> 
> [X] implement data validation - reservations existing
> 
> [X] implement data validation - reservations date overlap
> 
> [] implement data validation - users fields
>
> [] implement data validation - hosts fields
>
> [X] implement data validation - reservations fields
>
> [X] implement list building logic based around UI vision, maybe do UI first
> 
> [X] create repository doubles
> 
> [X] test domain layer
> 
> [X] implement response classes for validation feedback

> [X] create Controller
> 
> [X] implement menu options
> 
> [X] implement domain calls
> 
> [X] implement view calls, which loop while Result object is bad (almost all validation controlled by domain)

> [X] create view layer
> 
> [X] implement view methods
> 
> [X] create io layer as generic as possible
> 
> [] add guests feature to controller and to view
> 
> [] add make reservation feature to controller and view
> 
> [] add cancel reservation feature to controller and view
> 
> [] add edit reservation feature to controller and view

> [] add Spring dependency injection to the project
> 
> [] implement Spring in App class

