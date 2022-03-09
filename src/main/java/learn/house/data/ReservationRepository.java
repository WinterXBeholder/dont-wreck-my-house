package learn.house.data;

import learn.house.models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository {
    List<Reservation> findById(String hostId) throws DataException;

    //TODO: Figure out if date range should be Service or Repository
//    List<Reservation> findByDateRange(String hostID, LocalDate start, LocalDate End) throws DataException;

    Reservation add(String hostId, Reservation reservation) throws DataException;

    boolean update(String hostId, Reservation reservation) throws DataException;

    Boolean delete(String hostId, Reservation reservation) throws DataException;
}
