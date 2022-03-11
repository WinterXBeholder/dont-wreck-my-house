package learn.house.ui;

import learn.house.models.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class View {

    private final ConsoleIO io;
    private final String hostTemplate = "%-2s: Standard_Rate_$%-6s  Weekend_Rate_$%-6s  Last_Name_%-20s  Phone_%-13s  Email_%-30s  Address_%-30s %-20s %s %s";
    private final String reservationTemplate = "%-2s: %s_to_%s    Guest:_%s    Total_Cost:_$%.2f%n";

    public View(ConsoleIO io) {
        this.io = io;
    }

    public MainMenuOption selectMainMenuOption() {
        displayHeader("Main Menu");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (MainMenuOption option : MainMenuOption.values()) {
            if (!option.isHidden()) {
                io.printf("%s. %s%n", option.getValue(), option.getMessage());
            }
            min = Math.min(min, option.getValue());
            max = Math.max(max, option.getValue());
        }

        String message = String.format("Select [%s-%s]: ", min, max);
        return MainMenuOption.fromValue(io.readInt(message, min, max));
    }

    public void enterToContinue() {
        io.readString("Press [Enter] to continue.");
    }

    // display only
    public void displayHeader(String message) {
        io.println("");
        io.println(message);
        io.println("=".repeat(message.length()));
    }

    public void displayException(Exception ex) {
        displayHeader("A critical error occurred:");
        io.println(ex.getMessage());
    }

    public void displayStatus(boolean success, String message) {
        displayStatus(success, List.of(message));
    }

    public void displayStatus(boolean success, List<String> messages) {
        displayHeader(success ? "Success" : "Error");
        for (String message : messages) {
            io.println(message);
        }
    }

//    public LocalDate getForageDate() {return io.readLocalDate("Select a date [MM/dd/yyyy]: ");}
    private String formatHost(int index, Host host) {
        return String.format(hostTemplate,
                index++, host.getStandardRate().toString(), host.getWeekendRate().toString(), host.getLastName(),
                host.getPhone(), host.getEmail(), host.getAddress(), host.getCity(), host.getState(), host.getPostalCode());
    }

    public Host selectHost(List<Host> hosts) {
        if (hosts.size() == 0) {
            io.println("No hosts found");
            return null;
        }

        int index = 1;
        for (Host host : hosts.stream().limit(25).collect(Collectors.toList())) {
            io.println(formatHost(index++, host));
        }

        if (hosts.size() > 25) {
            io.println("More than 25 hosts found. Showing first 25. Please refine your search.");
        }

        io.println("0: Exit");
        String message = String.format("Select a host by their index [1-%s]: ", index-1);

        index = io.readInt(message, 0, index-1);
        if (index <= 0) {
            return null;
        }
        return hosts.get(index - 1);
    }

    public Host getHostCriteria() {
        io.println("Enter criteria to filter Hosts by equivalence (empty fields will be ignored): ");
        String id = io.readString("HostID: ");
        String lastName = io.readString("Last Name: ");
        String email = io.readEmailOptional("Email: ");
        String phone = io.readString("Phone #: ");
        String address = io.readString("address: ");
        String city = io.readString("City: ");
        States state = io.readStateOptional("State (two letters): ");
        String postalCode = io.readString("Postal Code: ");
        BigDecimal standardRate = io.readBigDecimalOptional("Standard Rate (no symbols): ");
        BigDecimal weekendRate = io.readBigDecimalOptional("Weekend Rate (no symbols: ");

        return new Host(
               id.equals("") ? null : id,
               lastName.equals("") ? null : lastName,
               email,
               phone.equals("") ? null : phone,
               address.equals("") ? null : address,
               city.equals("") ? null : city,
               state,
               postalCode.equals("") ? null : postalCode,
               standardRate,
               weekendRate);
    }

    public void printReservations(List<Reservation> reservations, Host host) {
        if (reservations == null || reservations.isEmpty()) {
            io.println("No reservations found for "+formatHost( 1, host));
            return;
        }
        displayHeader("Reservations for "+formatHost( 1, host));
        for (Reservation reservation : reservations) {
            io.printf(reservationTemplate,
                    reservation.getId(),
                    reservation.getStartDate(),
                    reservation.getEndDate(),
                    reservation.getGuestID(),
                    reservation.getTotal()
            );
        }
    }

//    displayHeader("Where would you like to go?");


//    public Item chooseItem(List<Item> items) {
//
//        displayItems(items);
//
//        if (items.size() == 0) {
//            return null;
//        }
//
//        int itemId = io.readInt("Select an item id: ");
//        Item item = items.stream()
//                .filter(i -> i.getId() == itemId)
//                .findFirst()
//                .orElse(null);
//
//        if (item == null) {
//            displayStatus(false, String.format("No item with id %s found.", itemId));
//        }
//
//        return item;
//    }
//
//    public Forage makeForage(Forager forager, Item item) {
//        Forage forage = new Forage();
//        forage.setForager(forager);
//        forage.setItem(item);
//        forage.setDate(io.readLocalDate("Forage date [MM/dd/yyyy]: "));
//        String message = String.format("Kilograms of %s: ", item.getName());
//        forage.setKilograms(io.readDouble(message, 0.001, 250.0));
//        return forage;
//    }
//
//    public Item makeItem() {
//        displayHeader(MainMenuOption.ADD_ITEM.getMessage());
//        Item item = new Item();
//        item.setCategory(getItemCategory());
//        item.setName(io.readPhrase("Item Name: "));
//        item.setDollarPerKilogram(io.readBigDecimal("$/Kg: ", BigDecimal.ZERO, new BigDecimal("7500.00")));
//        return item;
//    }
//
//    public Forager makeForager() {
//        displayHeader(MainMenuOption.ADD_FORAGER.getMessage());
//        Forager forager = new Forager();
//        forager.setFirstName(io.readWord("First Name: "));
//        forager.setLastName(io.readWord("Last Name: "));
//        forager.setState(io.readState("State of residence: "));
//        return forager;
//    }
//
//    public GenerateRequest getGenerateRequest() {
//        displayHeader(MainMenuOption.GENERATE.getMessage());
//        LocalDate start = io.readLocalDate("Select a start date [MM/dd/yyyy]: ");
//        if (start.isAfter(LocalDate.now())) {
//            displayStatus(false, "Start date must be in the past.");
//            return null;
//        }
//
//        LocalDate end = io.readLocalDate("Select an end date [MM/dd/yyyy]: ");
//        if (end.isAfter(LocalDate.now()) || end.isBefore(start)) {
//            displayStatus(false, "End date must be in the past and after the start date.");
//            return null;
//        }
//
//        GenerateRequest request = new GenerateRequest();
//        request.setStart(start);
//        request.setEnd(end);
//        request.setCount(io.readInt("Generate how many random forages [1-500]?: ", 1, 500));
//        return request;
//    }




//
//    public void printItemKiloReport(List<ItemKilo> rows) {
//        if (rows == null || rows.isEmpty()) {
//            io.println("No items found.");
//            return;
//        }
//        for (ItemKilo row : rows) {
//            io.printf("%s: %.2f kilograms%n",
//                    row.getItem().getName(),
//                    row.getKilograms()
//            );
//        }
//    }
//
//    public void printCategoryValueReport(List<CategoryValue> rows) {
//        if (rows == null || rows.isEmpty()) {
//            io.println("No items found.");
//            return;
//        }
//        for (CategoryValue row : rows) {
//            io.printf("%s: $%.2f total%n",
//                    row.getCategory(),
//                    row.getValue()
//            );
//        }
//    }
//
//    public void displayItems(List<Item> items) {
//
//        if (items.size() == 0) {
//            io.println("No items found");
//        }
//
//        for (Item item : items) {
//            io.printf("%s: %s, %s, %.2f $/kg%n", item.getId(), item.getName(), item.getCategory(), item.getDollarPerKilogram());
//        }
//    }
}
