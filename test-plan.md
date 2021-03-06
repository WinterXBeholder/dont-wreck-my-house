
# Module 5 Code Reviews

## Process

### Overview

> To help keep things moving quickly, keep a list of values (i.e. host and guest emails) in a text file that you can quickly copy and paste into the console when testing an app locally.

## Requirements Checklist

* [ ] View Reservations for Host
* [ ] Make a Reservation
* [ ] Edit a Reservation
* [ ] Cancel a Reservation
* [ ] File Format Unaltered
* [ ] Spring DI
* [ ] Proper BigDecimal/LocalDate Usage
* [ ] Data and Domain Tests
* [ ] Deliverables (planning, task schedule, Maven project, test suite)
* [ ] Java Idioms (excellent layering, class design, method responsibilities, and naming)
* [ ] Pattern Awareness (complete understanding of patterns: repository, service, MVC)

## Test Plan

* [ ] On startup, the application displays a menu containing the following items:
    * View Reservations
    * Add a Reservation
    * Edit a Reservation
    * Delete a Reservation
    * Exit

### View Reservations

* [ ] Select **View Reservations**
    * Search for host "Test" (test@test.com)
        * Does the application return a message that no host could be found?
* [ ] Select **View Reservations**
    * Search for host "Fader" (mfader2@amazon.co.jp)
        * Does the application return a message that the host has no reservations?
* [ ] Select **View Reservations**
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
        * Does the application return reservations for that host?
        * Does the reservation list display in a meaningful way?
        * Is the list sorted appropriately?

### Add a Reservation

* [ ] Select **Add a Reservation**
    * Search for guest "Test" (test@test.com)
        * Does the application return a message that no guest could be found?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Test" (test@test.com)
        * Does the application return a message that no host could be found?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * Does the application display a list of current reservations?
    * For Start Date, have the student enter in "Test"
        * Does the application re-prompt for a valid date?
    * For Start Date, have the student enter in `[yesterday's date]`
    * For End Date, have the student enter in `[today's date]`
    * Does the application display a summary?
    * Does the application display an error that reservations must be made for a future date?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in `[tomorrow's date]`
    * For End Date, have the student enter in `[today's date]`
    * Does the application display a summary?
    * Does the application display an error that reservation start date must come before the end date?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in a start date that is after the start date of an existing reservation
    * For End Date, have the student enter in an end date that is before the end date of that same existing reservation
    * Does the application display a summary?
    * Does the application display an error that reservation cannot overlap an existing reservation?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in a start date that is before the start date of an existing reservation (make sure the date is available and not in use by another reservation)
    * For End Date, have the student enter in an end date that is before the end date of that same existing reservation
    * Does the application display a summary?
    * Does the application display an error that reservation cannot overlap an existing reservation?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in a start date that is after the start date of an existing reservation
    * For End Date, have the student enter in an end date that is after the end date of that same existing reservation (make sure the date is available and not in use by another reservation)
    * Does the application display a summary?
    * Does the application display an error that reservation cannot overlap an existing reservation?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in a start date that is before the start date of an existing reservation (make sure the date is available and not in use by another reservation)
    * For End Date, have the student enter in an end date that is after the end date of that same existing reservation (make sure the date is available and not in use by another reservation)
    * Does the application display a summary?
    * Does the application display an error that reservation cannot overlap an existing reservation?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in `[next Tuesday's date]`
    * For End Date, have the student enter in `[next Wednesday's date]`
    * Does the application display a summary?
        * Is the total for the reservation `$340`
    * Does the application add the reservation successfully?
* [ ] Select **Add a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * For Start Date, have the student enter in `[next Thursday's date]`
    * For End Date, have the student enter in `[the Monday's date after next Thursday]`
    * Does the application display a summary?
        * Is the total for the reservation `$1530`
    * Does the application add the reservation successfully?

### Edit a Reservation

* [ ] Select **Edit a Reservation**
    * Search for guest "Test" (test@test.com)
    * Does the application display an error message that no guest can be found?
* [ ] Select **Edit a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Test" (test@test.com)
    * Does the application display an error message that no host can be found?
* [ ] Select **Edit a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Fader" (mfader2@amazon.co.jp)
    * Does the application display an error message that no reservations can be found?
* [ ] Select **Edit a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * Does the reservation list display?
    * Does the list include the 2 reservations just created?
    * Use the reservation set using `[next Tuesday's date]` as the start date to execute the same date validations as done for **Add a Reservation**
* [ ] Select **Edit a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * Does the reservation list display?
    * Select the last reservation just added
    * For Start Date, have the student press `[enter]` to keep the current value
    * For End Date, have the student enter in `[the Tuesday's date after next Thursday]`
    * Does the application display a summary?
        * Is the total for the reservation `$1870`
    * Does the application update the reservation successfully?

### Cancel a Reservation

* [ ] Select **Cancel a Reservation**
    * Search for guest "Test" (test@test.com)
    * Does the application display an error message that no guest can be found?
* [ ] Select **Cancel a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Test" (test@test.com)
    * Does the application display an error message that no host can be found?
* [ ] Select **Cancel a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Fader" (mfader2@amazon.co.jp)
    * Does the application display an error message that no reservations can be found?
* [ ] Select **Cancel a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * Does the reservation list display?
    * Attempt to cancel a past reservation
        * Does the application prevent you in some way from cancelling a past reservation?
* [ ] Select **Cancel a Reservation**
    * Search for guest "Lomas" (slomas0@mediafire.com)
    * Search for host "Yearnes" (eyearnes0@sfgate.com)
    * Does the reservation list display?
    * Select a future reservation
    * Does the application successfully remove the reservation? 