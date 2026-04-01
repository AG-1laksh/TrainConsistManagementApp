import java.util.ArrayList;
import java.util.List;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC2 ===");

        // 1. Create an ArrayList<String> for passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // 2. Add bogies: Sleeper, AC Chair, First Class
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // 3. Print the list after insertion
        System.out.println("Train consist after initial additions: " + passengerBogies);

        // 4. Remove one bogie (AC Chair)
        passengerBogies.remove("AC Chair");
        System.out.println("-> Detached 'AC Chair' bogie.");

        // 5. Use contains() to check if Sleeper exists
        boolean hasSleeper = passengerBogies.contains("Sleeper");
        System.out.println("Is 'Sleeper' bogie still attached? " + hasSleeper);

        // 6. Print final list state
        System.out.println("Final train consist state: " + passengerBogies);

        // Program continues...
    }
}