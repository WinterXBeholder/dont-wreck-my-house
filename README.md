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

### Design:
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
> [] create data-access layer (repositories)
> 
> [] implement find-by methods
> 
> [] implement write methods
> 
> [] implement update methods
> 
> [] implement delete methods
> 
> [] create test data-sets
> 
> [] test data-access

> [] create domain layer (Service) to control repositories
> 
> [] implement data validation - users (existing, fields)
>
> [] implement data validation - hosts (existing, fields)
> 
> [] implement data validation - reservations (existing, fields, date overlap)
> 
> [] implement list building logic based around UI vision, maybe do UI first
> 
> [] create repository doubles
> 
> [] test domain layer

> [] create Controller
> 
> [] implement menu options
> 
> [] implement domain calls
> 
> [] implement view calls, which loop while Result object is bad (almost all validation controlled by domain)

> [] create view layer
> 
> [] implement view methods
> 
> [] create io layer as generic as possible

> [] add Spring dependency injection to the project
> 
> [] implement Spring in App class

