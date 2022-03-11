package learn.house.ui;


import learn.house.data.DataException;
import learn.house.domain.GuestService;
import learn.house.domain.HostService;
import learn.house.domain.ReservationService;
import learn.house.domain.Result;
import learn.house.models.Guest;
import learn.house.models.Host;
import learn.house.models.Reservation;
import learn.house.ui.View;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public class Controller {

    private final HostService hostService;
    private final GuestService guestService;
    private final ReservationService reservationService;
    private final View view;

    public Controller(HostService hostService, GuestService guestService, ReservationService reservationService, View view) {
        this.hostService = hostService;
        this.guestService = guestService;
        this.reservationService = reservationService;
        this.view = view;
    }

    public void run() {
        view.displayHeader("Welcome to \"Don't Wreck My House\"!!!");
        try {
            runAppLoop();
        } catch (DataException ex) {
            view.displayException(ex);
        }
        view.displayHeader("Goodbye.");
    }

    private void runAppLoop() throws DataException {
        MainMenuOption option;
        do {
            option = view.selectMainMenuOption();
            switch (option) {
                case VIEW_RESERVATIONS_BY_HOST:
                    reservationsByHost();
                    break;
                case MAKE_NEW_RESERVATION:
                    newReservation();
                    break;
//                case EDIT_A_RESERVATION:
//                    editReservation();
//                    break;
//                case CANCEL_A_RESERVATION:
//                    cancelReservation();
//                    break;
//                case ADD_HOST:
//                    addHost();
//                    break;
//                case ADD_GUEST:
//                    addGuest();
//                    break;
//                case EDIT_HOST:
//                    editHost();
//                    break;
//                case EDIT_GUEST:
//                    editGuest();
//                    break;
//                case REMOVE_HOST:
//                    removeHost();
//                    break;
//                case REMOVE_GUEST:
//                    removeGuest();
//                    break;
            }
        } while (option != MainMenuOption.EXIT);
    }

    // top level menu
    private void reservationsByHost() throws DataException{
        view.displayHeader(MainMenuOption.VIEW_RESERVATIONS_BY_HOST.getMessage());
        Host host = selectHost();
        if (host == null) return;
        view.printReservations(reservationService.resByHost(host.getId()), host);
        view.enterToContinue();
    }

    private Host selectHost() throws DataException{
        Host criteria = view.getHostCriteria();
        List<Host> hosts = hostService.getHosts(criteria);
        return view.selectHost(hosts);
    }

    private Guest selectGuest() throws DataException{
        Guest criteria = view.getGuestCriteria();
        List<Guest> guests = guestService.getGuests(criteria);
        return view.selectGuest(guests);
    }

    private void newReservation() throws DataException {
        view.displayHeader(MainMenuOption.MAKE_NEW_RESERVATION.getMessage());
        Guest guest = selectGuest();
        if(guest == null) return;
        Host host = selectHost();
        if( host == null ) return;
        view.displayMessage("Existing reservations:");
        view.printReservations(reservationService.resByHostFuture(host.getId()), host);
        Boolean finish = false;
        while(!finish) {
            Reservation newReservation = new Reservation();
            newReservation = view.getDates(newReservation, host);
            newReservation.setGuestID(guest.getGuestId());
            finish = !view.displayConfirmation(newReservation);
            if (finish) {
                Result result = reservationService.add(host.getId(), newReservation);
                finish = result.isSuccess();
                view.displayStatus(result.isSuccess(), result.getErrorMessages());
            }
        }
    }



//    private void viewItems() {
//        view.displayHeader(MainMenuOption.VIEW_ITEMS.getMessage());
//        Category category = view.getItemCategory();
//        List<Item> items = itemService.findByCategory(category);
//        view.displayHeader("Items");
//        view.displayItems(items);
//        view.enterToContinue();
//    }
//
//    private void viewForagers() throws DataException {
//        view.displayHeader(MainMenuOption.VIEW_FORAGERS.getMessage());
//        String state = view.getState();
//        List<Forager> foragers = foragerService.findByState(state);
//        view.printForagers(foragers);
//        view.enterToContinue();
//    }
//
//    private void kilogramReport() {
//        view.displayHeader(MainMenuOption.REPORT_KG_PER_ITEM.getMessage());
//        LocalDate date = view.getForageDate();
//        List<ItemKilo> rows = forageService.itemKiloReport(date);
//        view.printItemKiloReport(rows);
//        view.enterToContinue();
//    }
//
//    private void valueReport() {
//        view.displayHeader(MainMenuOption.REPORT_CATEGORY_VALUE.getMessage());
//        LocalDate date = view.getForageDate();
//        List<CategoryValue> rows = forageService.categoryValueReport(date);
//        view.printCategoryValueReport(rows);
//        view.enterToContinue();
//    }
//
//    private void addForage() throws DataException {
//        view.displayHeader(MainMenuOption.ADD_FORAGE.getMessage());
//        Forager forager = getForager();
//        if (forager == null) {
//            return;
//        }
//        Item item = getItem();
//        if (item == null) {
//            return;
//        }
//        Forage forage = view.makeForage(forager, item);
//        Result<Forage> result = forageService.add(forage);
//        if (!result.isSuccess()) {
//            view.displayStatus(false, result.getErrorMessages());
//        } else {
//            String successMessage = String.format("Forage %s created.", result.getPayload().getId());
//            view.displayStatus(true, successMessage);
//        }
//    }
//
//    private void addItem() throws DataException {
//        Item item = view.makeItem();
//        Result<Item> result = itemService.add(item);
//        if (!result.isSuccess()) {
//            view.displayStatus(false, result.getErrorMessages());
//        } else {
//            String successMessage = String.format("Item %s created.", result.getPayload().getId());
//            view.displayStatus(true, successMessage);
//        }
//    }
//
//    private void addForager() throws DataException {
//        Forager forager = view.makeForager();
//        Result<Forager> result = foragerService.add(forager);
//        if (!result.isSuccess()) {
//            view.displayStatus(false, result.getErrorMessages());
//        } else {
//            String successMessage = String.format("Forager %s created.", result.getPayload().getId());
//            view.displayStatus(true, successMessage);
//        }
//    }
//
//    private void generate() throws DataException {
//        GenerateRequest request = view.getGenerateRequest();
//        if (request != null) {
//            int count = forageService.generate(request.getStart(), request.getEnd(), request.getCount());
//            view.displayStatus(true, String.format("%s forages generated.", count));
//        }
//    }
//
//    // support methods
//    private Forager getForager() {
//        String lastNamePrefix = view.getForagerNamePrefix();
//        List<Forager> foragers = foragerService.findByLastName(lastNamePrefix);
//        return view.chooseForager(foragers);
//    }
//
//    private Item getItem() {
//        Category category = view.getItemCategory();
//        List<Item> items = itemService.findByCategory(category);
//        return view.chooseItem(items);
//    }

}
