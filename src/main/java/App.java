import learn.house.data.GuestFileRepository;
import learn.house.data.HostFileRepository;
import learn.house.data.ReservationFileRepository;
import learn.house.domain.GuestService;
import learn.house.domain.HostService;
import learn.house.domain.ReservationService;
import learn.house.ui.ConsoleIO;
import learn.house.ui.Controller;
import learn.house.ui.View;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
//        GuestFileRepository guestRepository = new GuestFileRepository("./data/guests.csv");
//        HostFileRepository hostRepository = new HostFileRepository("./data/hosts.csv");
//        ReservationFileRepository resRepository = new ReservationFileRepository("./data/reservations/");
//
//        GuestService guestService = new GuestService(guestRepository);
//        HostService hostService = new HostService((hostRepository));
//        ReservationService reservationService = new ReservationService(resRepository);
//
//        ConsoleIO io = new ConsoleIO();
//        View view = new View(io);
//
//        Controller controller = new Controller(hostService, guestService, reservationService, view);

        ApplicationContext context = new ClassPathXmlApplicationContext("dependency-configuration.xml");
        Controller controller = context.getBean(Controller.class);
        controller.run();    }


}
