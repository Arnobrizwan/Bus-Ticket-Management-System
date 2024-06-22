import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private BusTicketManagementSystem system;

    public GUI(BusTicketManagementSystem system) {
        this.system = system;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Bus Ticket Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome to the Bus Ticket Management System");
        welcomeLabel.setBounds(10, 20, 300, 25);
        panel.add(welcomeLabel);

        JButton bookTicketButton = new JButton("Book Ticket");
        bookTicketButton.setBounds(10, 50, 150, 25);
        panel.add(bookTicketButton);
        bookTicketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bookTicket();
            }
        });

        JButton generateReportButton = new JButton("Generate Report");
        generateReportButton.setBounds(10, 80, 150, 25);
        panel.add(generateReportButton);
        generateReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateReport();
            }
        });
    }

    private void bookTicket() {
        String passengerName = JOptionPane.showInputDialog(frame, "Enter Passenger Name:");
        String busNumber = JOptionPane.showInputDialog(frame, "Enter Bus Number:");
        String seatNumber = JOptionPane.showInputDialog(frame, "Enter Seat Number:");
        double price = Double.parseDouble(JOptionPane.showInputDialog(frame, "Enter Ticket Price:"));

        Passenger passenger = new Passenger(passengerName, passengerName, "000-000-0000"); // Dummy phone number
        Ticket ticket = new NormalTicket(price, seatNumber, passengerName, 0.1); // Example with 10% insurance tax rate
        Bus bus = system.findBusById(busNumber);
        if (bus == null) {
            bus = new Bus(busNumber, "Default Driver", 50); // Example with default capacity
            system.addBus(bus);
        }

        if (bus.addTicket(ticket)) {
            passenger.bookTicket(ticket);
            system.addPassenger(passenger);
            JOptionPane.showMessageDialog(frame, "Ticket booked successfully!");
        } else {
            JOptionPane.showMessageDialog(frame, "Bus is full!");
        }
    }

    private void generateReport() {
        String busNumber = JOptionPane.showInputDialog(frame, "Enter Bus Number for Report:");
        Bus bus = system.findBusById(busNumber);
        if (bus != null) {
            system.generateBusReport(busNumber);
            JOptionPane.showMessageDialog(frame, "Report generated successfully!");
        } else {
            JOptionPane.showMessageDialog(frame, "Bus not found!");
        }
    }

    public static void main(String[] args) {
        BusTicketManagementSystem system = new BusTicketManagementSystem();
        system.loadBusesFromFile("input.txt"); // Load buses from input file
        new GUI(system);
    }
}
