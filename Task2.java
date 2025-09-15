import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Airplane {
    private String flightNumber;
    private String destination;
    private LocalTime scheduledDeparture;
    private int delayTime; // in minutes

    // Constructor
    public Airplane(String flightNumber, String destination, LocalTime scheduledDeparture) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.scheduledDeparture = scheduledDeparture;
        this.delayTime = 0;
    }

    // Getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public LocalTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public int getDelayTime() {
        return delayTime;
    }

    // Setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setScheduledDeparture(LocalTime scheduledDeparture) {
        this.scheduledDeparture = scheduledDeparture;
    }

    // Method to delay the flight
    public void delayFlight(int minutes) {
        this.delayTime += minutes;
        this.scheduledDeparture = this.scheduledDeparture.plusMinutes(minutes);
    }

    // Method to check flight status
    public String checkFlightStatus() {
        if (delayTime > 0) {
            return "Flight " + flightNumber + " is delayed by " + delayTime + " minutes.";
        } else {
            return "Flight " + flightNumber + " is on time.";
        }
    }

    // Display flight details
    public void displayInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        System.out.println("Flight: " + flightNumber);
        System.out.println("Destination: " + destination);
        System.out.println("Scheduled Departure: " + scheduledDeparture.format(formatter));
        System.out.println(checkFlightStatus());
        System.out.println();
    }
}

public class Task2 {
    public static void main(String[] args) {
        // Create flight object
        Airplane flight1 = new Airplane("VN123", "Tokyo", LocalTime.of(10, 30));
        Airplane flight2 = new Airplane("VN456", "Paris", LocalTime.of(15, 45));

        // Show details
        System.out.println("=== Before Delay ===");
        flight1.displayInfo();
        flight2.displayInfo();

        // Delay flight1
        flight1.delayFlight(45);

        System.out.println("=== After Delay ===");
        flight1.displayInfo();
        flight2.displayInfo();
    }
}
