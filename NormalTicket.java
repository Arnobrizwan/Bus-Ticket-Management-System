public class NormalTicket extends Ticket {
    private double insuranceTaxRate;

    public NormalTicket(double price, String seatNum, String passengerName, double insuranceTaxRate) {
        super(price, seatNum, passengerName);
        this.insuranceTaxRate = insuranceTaxRate;
    }

    @Override
    public double calculateFare() {
        return price + (price * insuranceTaxRate);
    }

    public double getInsuranceTaxRate() {
        return insuranceTaxRate;
    }

    public void displayInfo() {
        System.out.println("Normal Ticket Info:");
        System.out.println("Price: " + price);
        System.out.println("Seat Number: " + seatNum);
        System.out.println("Passenger Name: " + passengerName);
        System.out.println("Insurance Tax Rate: " + insuranceTaxRate);
    }
}
