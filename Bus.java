public class Bus {
    private String busNumber;
    private String driverName;
    private int capacity;
    private Ticket[] ticketArray;
    private int ticketCount;

    public Bus(String busNumber, String driverName, int capacity) {
        this.busNumber = busNumber;
        this.driverName = driverName;
        this.capacity = capacity;
        this.ticketArray = new Ticket[capacity];
        this.ticketCount = 0;
    }

    public boolean addTicket(Ticket ticket) {
        if (ticketCount < ticketArray.length) {
            ticketArray[ticketCount++] = ticket;
            return true;
        } else {
            return false; // Bus is full
        }
    }

    public int getAvailableSeats() {
        return capacity - ticketCount;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getCapacity() {
        return capacity;
    }

    public Ticket[] getTicketArray() {
        return ticketArray;
    }

    public void displayBusInfo() {
        System.out.println("Bus Number: " + busNumber);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Available Seats: " + getAvailableSeats());
    }
}

