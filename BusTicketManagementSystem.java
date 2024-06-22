import java.util.ArrayList;

public class BusTicketManagementSystem {
    private ArrayList<Ticket> ticketList;
    private ArrayList<Bus> busList;
    private ArrayList<Passenger> passengerList;
    private ReportGenerator reportGenerator;

    public BusTicketManagementSystem() {
        ticketList = new ArrayList<>();
        busList = new ArrayList<>();
        passengerList = new ArrayList<>();
        reportGenerator = new ReportGenerator("report.txt");
    }

    public void addTicket(Ticket ticket) {
        ticketList.add(ticket);
    }

    public void addBus(Bus bus) {
        busList.add(bus);
    }

    public void addPassenger(Passenger passenger) {
        passengerList.add(passenger);
    }

    public ArrayList<Ticket> getTicketList() {
        return ticketList;
    }

    public ArrayList<Bus> getBusList() {
        return busList;
    }

    public ArrayList<Passenger> getPassengerList() {
        return passengerList;
    }

    public void generateReport(String reportContent) {
        reportGenerator.saveReport(reportContent);
    }

    public static void showWelcomeMessage() {
        System.out.println("Welcome to the Bus Ticket Management System");
    }

    public Bus findBusById(String busNumber) {
        for (Bus bus : busList) {
            if (bus.getBusNumber().equals(busNumber)) {
                return bus;
            }
        }
        return null;
    }

    public Passenger findPassengerById(String passengerID) {
        for (Passenger passenger : passengerList) {
            if (passenger.getId().equals(passengerID)) {
                return passenger;
            }
        }
        return null;
    }

    public boolean addTicketToBus(String busNumber, Ticket ticket) {
        Bus bus = findBusById(busNumber);
        if (bus != null) {
            return bus.addTicket(ticket);
        }
        return false;
    }

    public void addTicketToPassenger(String passengerID, Ticket ticket) {
        Passenger passenger = findPassengerById(passengerID);
        if (passenger != null) {
            passenger.bookTicket(ticket);
        }
    }

    public void generateBusReport(String busNumber) {
        Bus bus = findBusById(busNumber);
        if (bus != null) {
            reportGenerator.generateBusReport(bus);
        } else {
            ExceptionHandling exception = new ExceptionHandling("Bus not found");
            exception.handleException();
        }
    }

    public void generatePassengerReport(String passengerID) {
        Passenger passenger = findPassengerById(passengerID);
        if (passenger != null) {
            reportGenerator.generatePassengerReport(passenger);
        } else {
            ExceptionHandling exception = new ExceptionHandling("Passenger not found");
            exception.handleException();
        }
    }
}

