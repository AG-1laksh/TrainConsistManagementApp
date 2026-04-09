import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UC9: Group Bogies by Type
 * This application demonstrates how to use the Stream API to categorize
 * flat data into a structured Map for easier reporting.
 */

// 1. Bogie class (keeping it in the same file as per your setup)
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {

    /**
     * UC9 Logic: Groups the list of bogies by their name using Collectors.groupingBy.
     * Returns a Map where the Key is the Bogie Name and the Value is a List of those Bogies.
     */
    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    public static void main(String[] args) {
        TrainConsistManagementApp app = new TrainConsistManagementApp();

        System.out.println("=== Train Consist Management App: UC9 ===");

        // 2. Setup the data (The 'Consist')
        List<Bogie> passengerBogies = new ArrayList<>();
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("First Class", 24));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("Sleeper", 72));

        System.out.println("Total bogies in consist: " + passengerBogies.size());

        // 3. Execute Grouping
        Map<String, List<Bogie>> groupedResult = app.groupBogiesByType(passengerBogies);

        // 4. Display Structured Output
        System.out.println("\n--- Structured Composition Report ---");
        groupedResult.forEach((type, list) -> {
            System.out.println("Category: [" + type.toUpperCase() + "]");
            System.out.println("  Count: " + list.size());
            list.forEach(bogie -> System.out.println("  - " + bogie));
            System.out.println("-------------------------");
        });

        System.out.println("\nGrouping successful. Program continues...");
    }
}