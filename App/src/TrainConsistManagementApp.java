import java.util.HashMap;
import java.util.Map;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC6 ===");

        // 1. Create a HashMap<String, Integer> to store bogie-capacity information
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // 2 & 3. Insert capacity values using the put() method
        System.out.println("Mapping bogie types to their operational capacities...");
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 24);

        System.out.println("\n--- Bogie Capacity Directory ---");

        // 4 & 5. Iterate over the map using entrySet() and display each key-value pair
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogieType = entry.getKey();
            Integer capacity = entry.getValue();

            System.out.println("Bogie Type: " + bogieType + " | Capacity: " + capacity);
        }

        // Program continues...
    }
}