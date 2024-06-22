public class HandicappedTicket extends Ticket {
    private double discountRate;

    public HandicappedTicket(double price, String seatNum, String passengerName, double discountRate) {
        super(price, seatNum, passengerName);
        this.discountRate = discountRate;
    }

    @Override
    public double calculateFare() {
        return price * (1 - discountRate);
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void displayInfo() {
        System.out.println("Handicapped Ticket Info:");
        System.out.println("Price: " + price);
        System.out.println("Seat Number: " + seatNum);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Discount Rate: " + discountRate);
    }
}
