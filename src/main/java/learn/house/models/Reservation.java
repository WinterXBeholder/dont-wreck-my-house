package learn.house.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

/** Reservation:
 One or more days where a Guest has exclusive access to a Location (or Host). Reservation data is provided.
 *
 */
public class Reservation {

    private String id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String guestID;
    private BigDecimal total = BigDecimal.ZERO;;

    public String getId() {return id;}

    public void setId(String id) {this.id = id;}

    public LocalDate getStartDate() {return startDate;}

    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public LocalDate getEndDate() {return endDate;}

    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public String getGuestID() {return guestID;}

    public void setGuestID(String guestID) {this.guestID = guestID;}

    public BigDecimal getTotal() { return total;}

    public void setTotal(BigDecimal total) { this.total = total;}
}
