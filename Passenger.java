import java.util.Vector;

public class Passenger {
    private String id;
    private String name;
    private String phoneNum;
    private Vector<Ticket> tickets;

    public Passenger(String id, String name, String phoneNum) {
        this.id = id;
        this.name = name;
        this.phoneNum = phoneNum;
        this.tickets = new Vector<>();
    }

    public void bookTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void cancelTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public Vector<Ticket> getTickets() {
        return tickets;
    }

    public void displayPassengerInfo() {
        System.out.println("Passenger ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNum);
        System.out.println("Tickets: ");
        for (Ticket ticket : tickets) {
            System.out.println("Ticket ID: " + ticket.getPassengerName() + ", Seat Number: " + ticket.getSeatNum() + ", Fare: " + ticket.calculateFare());
        }
    }
}
