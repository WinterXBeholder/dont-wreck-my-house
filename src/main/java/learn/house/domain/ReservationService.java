package learn.house.domain;

import learn.house.data.DataException;
import learn.house.data.ReservationRepository;
import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {
    ReservationRepository repository;
    public ReservationService(ReservationRepository reservationRepository) {this.repository = reservationRepository;}

    public List<Reservation> resByHost(String hostId) throws DataException {
        List<Reservation> results = repository.findById(hostId);
        results.sort(Comparator.comparing(r -> r.getStartDate()));
        return results;
    }

    public List<Reservation> getReservations(String hostId, Reservation criteria) throws DataException {
        List<Reservation> results = null;
        results = resByHostFuture(hostId).stream().filter(r -> resStreamFilter(criteria, r)).toList();
        return results;
    }

    private Boolean resStreamFilter(Reservation c, Reservation r) {
        return (c.getId() == null || c.getId().equalsIgnoreCase(r.getId())) &&
                (c.getStartDate() == null || c.getStartDate().compareTo(r.getStartDate())==0) &&
                (c.getEndDate() == null || c.getEndDate().compareTo(r.getEndDate())==0) &&
                (c.getGuestID() == null || c.getGuestID().equalsIgnoreCase(r.getGuestID())) &&
                (c.getTotal() == null || c.getTotal().compareTo(r.getTotal())==0);
    }

    public List<Reservation> resByHostFuture(String hostId) throws DataException {
        List<Reservation> results = resByHost(hostId);
        return results.stream().filter(r -> r.getStartDate().compareTo(LocalDate.now()) >= 0)
                .collect(Collectors.toList());
    }

    public Boolean cancel(String hostId, Reservation reservation) throws DataException {
        return repository.delete(hostId, reservation);
    }

    public Boolean update(String hostId, Reservation reservation) throws DataException {
        if (reservationTest(hostId, reservation)) {
            repository.update(hostId, reservation); //assign payload
            return true;
        }
        // return error message
        return false;
    }

    public Boolean add(String hostId, Reservation reservation) throws DataException {
        if (reservationTest(hostId, reservation)) {
            repository.add(hostId, reservation); //assign payload
            return true;
        }
        // return error message
        return false;
    }

    public Boolean reservationTest(String hostId, Reservation newRes) throws DataException {
        List<Reservation> current = resByHost(hostId);
        if ( missingFieldTest(newRes)) {
            return false;
        }
        Boolean dateOverlap = current.stream().anyMatch(r ->
                !r.getId().equalsIgnoreCase(newRes.getId()) && overlapTest(r, newRes));
        if (dateOverlap) {
            return false;
        }
        return true;
    }

    private Boolean missingFieldTest(Reservation r) {
        return r.getStartDate() == null ||
                r.getEndDate() == null ||
                r.getGuestID() == null ||
                r.getTotal() == null;
    }

    private Boolean overlapTest(Reservation r, Reservation n) {
        if ((r.getStartDate().isBefore(n.getStartDate())) &&
                (r.getStartDate().isBefore(n.getEndDate())) &&
                (r.getEndDate().isBefore(n.getStartDate())) &&
                (r.getEndDate().isBefore(n.getEndDate()))) {
            return false;
        } else if ((r.getStartDate().isAfter(n.getStartDate())) &&
                (r.getStartDate().isAfter(n.getEndDate())) &&
                (r.getEndDate().isAfter(n.getStartDate())) &&
                (r.getEndDate().isAfter(n.getEndDate()))) {
            return false;
        }
        return true;
    }

}


































