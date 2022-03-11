package learn.house.data;

import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.States;

import java.util.List;

public interface HostRepository {
    Host findById(String id) throws DataException;

    List<Host> findAll() throws DataException;

    List<Host> findByState(States state) throws DataException;

    List<Host> findByLastName(String lastName) throws DataException;

    //TODO: implement Add Host
//    Host add(Host host) throws DataException;


    //TODO: implement Delete Host
//    Boolean delete(Host host) throws DataException;

    //TODO: implement Update Host
//    Boolean update(Host host) throws DataException;

}
