package learn.house.models;

import java.math.BigDecimal;
import java.util.Objects;

/** Host:
 The accommodation provider. Someone who has a property to rent per night. Host data is provided.
 Location:
 A rental property. In Don't Wreck My House, Location and Host are combined. The application enforces a limit on one
 Location per Host, so we can think of a Host and Location as a single thing.
 *
 */
public class Host {


    private String id;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private States state;
    private String postal_code;
    private BigDecimal standard_rate;
    private BigDecimal weekend_rate;


    public Host() {}

    public Host(String id, String lastName, String email, String phone, String address, String city, States state, String postal_code,
                BigDecimal standard_rate, BigDecimal weekend_rate) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.standard_rate = standard_rate;
        this.weekend_rate = weekend_rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public States state() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public BigDecimal getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(BigDecimal standard_rate) {
        this.standard_rate = standard_rate;
    }

    public BigDecimal getWeekend_rate() {
        return weekend_rate;
    }

    public void setWeekend_rate(BigDecimal weekend_rate) {
        this.weekend_rate = weekend_rate;
    }

/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return id == host.id &&
                Objects.equals(lastName, host.lastName) &&
                state == host.state &&
                Objects.equals(email, host.email);
    }
*/
/*
    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, email, state);
    }
*/
}
