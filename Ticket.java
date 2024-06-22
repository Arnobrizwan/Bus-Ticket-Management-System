public abstract class Ticket implements Fare {
    protected double price;
    protected String seatNum;
    protected String passengerName;

    public Ticket(double price, String seatNum, String passengerName) {
        this.price = price;
        this.seatNum = seatNum;
        this.passengerName = passengerName;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public abstract double calculateFare();
}

