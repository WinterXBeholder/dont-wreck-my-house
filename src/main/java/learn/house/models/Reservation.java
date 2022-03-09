package learn.house.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/** Reservation:
 One or more days where a Guest has exclusive access to a Location (or Host). Reservation data is provided.
 *
 */
public class Reservation {

    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String guestId;
    private BigDecimal total = BigDecimal.ZERO;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public LocalDate getStartDate() {return startDate;}

    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}

    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public String getGuestID() {return guestId;}

    public void setGuestID(String guestID) {this.guestId = guestID;}

    public BigDecimal getTotal() { return total;}

    public void setTotal(BigDecimal total) { this.total = total;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return  Objects.equals(id, reservation.id) &&
                Objects.equals(guestId, reservation.guestId) &&
                total.equals(reservation.total);
    }

    public boolean testEquals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation reservation = (Reservation) o;
        return  Objects.equals(id, reservation.id) &&
                Objects.equals(startDate, reservation.startDate) &&
                Objects.equals(endDate, reservation.endDate) &&
                Objects.equals(guestId, reservation.guestId) &&
                total.equals(reservation.total);
    }
}
