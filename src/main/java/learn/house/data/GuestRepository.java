package learn.house.data;

import learn.house.models.Guest;
import learn.house.models.States;

import java.util.List;

public interface GuestRepository {
    Guest findById(String id) throws DataException;

    List<Guest> findAll() throws DataException;

    List<Guest> findByLastName(String lastName) throws DataException;

    List<Guest> findByState(States state) throws DataException;

    //TODO: implement Add Guest
//    Guest add(Guest guest) throws DataException;

    //TODO: implement Delete Guest
//    Boolean delete(Guest guest) throws DataException;

    //TODO: implement Update Guest
//    Boolean update(Guest guest) throws DataException;
}
