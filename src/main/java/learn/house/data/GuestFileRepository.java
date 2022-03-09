package learn.house.data;

import learn.house.models.Guest;
import learn.house.models.States;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestFileRepository implements GuestRepository {

    private static final String HEADER = "guest_id,first_name,last_name,email,phone,state";
    private final String filePath;

    public GuestFileRepository(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Guest> findAll() throws DataException {
        ArrayList<Guest> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            reader.readLine(); // read header

            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                String[] fields = line.split(",", -1);
                if (fields.length == 6) {
                    result.add(deserialize(fields));
                }
            }
        } catch (IOException ex) {
            // don't throw on read
        }
        return result;
    }

    @Override
    public List<Guest> findByLastName(String lastName) throws DataException {
        return findAll().stream()
                .filter(i -> i.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    @Override
    public List<Guest> findByState(States state) throws DataException {
        return findAll().stream()
                .filter(i -> i.getState().equals(state))
                .collect(Collectors.toList());
    }

    @Override
    public Guest findById(String id) throws DataException {
        return findAll().stream()
                .filter(i -> i.getGuestId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }



//    @Override
//    public Guest add(Guest guest) throws DataException {
//
//        if (guest == null) {
//            return null;
//        }
//
//        List<Guest> all = findAll();
//
//        guest.setId(UUID.randomUUID().toString());
//
//        all.add(guest);
//        writeAll(all);
//
//        return guest;
//    }

//    public boolean update(Guest guest) throws DataException {
//
//        if (guest == null) {
//            return false;
//        }
//
//        List<Guest> all = findAll();
//        for (int i = 0; i < all.size(); i++) {
//            if (guest.getId() == all.get(i).getId()) {
//                all.set(i, guest);
//                writeAll(all);
//                return true;
//            }
//        }
//
//        return false;
//    }

    private String serialize(Guest guest) {
        return String.format("%s,%s,%s,%s,%s,%s",
                guest.getGuestId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getEmail(),
                guest.getPhone(),
                guest.getState());
    }

    private Guest deserialize(String[] fields) {
        Guest guest = new Guest();
        guest.setGuestId(fields[0]);
        guest.setFirstName(fields[1]);
        guest.setLastName(fields[2]);
        guest.setEmail(fields[3]);
        guest.setPhone(fields[4]);
        guest.setState(States.valueOf(fields[5]));
        return guest;
    }

//    protected void writeAll(List<Guest> guests) throws DataException {
//        try (PrintWriter writer = new PrintWriter(filePath)) {
//
//            writer.println(HEADER);
//
//            if (guests == null) {
//                return;
//            }
//
//            for (Guest guest : guests) {
//                writer.println(serialize(guest));
//            }
//
//        } catch (FileNotFoundException ex) {
//            throw new DataException(ex);
//        }
//    }
}
