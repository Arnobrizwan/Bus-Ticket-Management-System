import java.io.FileWriter;
import java.io.IOException;

public class ReportGenerator {
    private String reportFileName;

    public ReportGenerator(String reportFileName) {
        this.reportFileName = reportFileName;
    }

    public void generateBusReport(Bus bus) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("Bus Number: ").append(bus.getBusNumber()).append("\n");
        reportContent.append("Driver Name: ").append(bus.getDriverName()).append("\n");
        reportContent.append("Capacity: ").append(bus.getCapacity()).append("\n");
        reportContent.append("Tickets:\n");
        for (Ticket ticket : bus.getTicketArray()) {
            if (ticket != null) {
                reportContent.append("Passenger Name: ").append(ticket.getPassengerName())
                        .append(", Seat Number: ").append(ticket.getSeatNum())
                        .append(", Fare: ").append(ticket.calculateFare()).append("\n");
            }
        }
        saveReport(reportContent.toString());
    }

    public void generatePassengerReport(Passenger passenger) {
        StringBuilder reportContent = new StringBuilder();
        reportContent.append("Passenger ID: ").append(passenger.getId()).append("\n");
        reportContent.append("Name: ").append(passenger.getName()).append("\n");
        reportContent.append("Phone Number: ").append(passenger.getPhoneNum()).append("\n");
        reportContent.append("Tickets:\n");
        for (Ticket ticket : passenger.getTickets()) {
            reportContent.append("Passenger Name: ").append(ticket.getPassengerName())
                    .append(", Seat Number: ").append(ticket.getSeatNum())
                    .append(", Fare: ").append(ticket.calculateFare()).append("\n");
        }
        saveReport(reportContent.toString());
    }

    public void saveReport(String reportContent) {
        try (FileWriter writer = new FileWriter(reportFileName)) {
            writer.write(reportContent);
        } catch (IOException e) {
            ExceptionHandling exception = new ExceptionHandling(e.getMessage());
            exception.handleException();
        }
    }
}


