import java.util.LinkedHashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC5 ===");

        // 1. Create a LinkedHashSet<String> to represent the train formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // 2. Attach bogies: Engine, Sleeper, Cargo, Guard
        System.out.println("Attaching bogies to the train...");
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        System.out.println("Current Formation: " + trainFormation);

        // 3. Attempt to attach a duplicate bogie intentionally (Sleeper)
        System.out.println("\nAttempting to attach a duplicate 'Sleeper' bogie...");
        boolean isAdded = trainFormation.add("Sleeper");

        System.out.println("-> Was the duplicate Sleeper attached? " + isAdded);

        // 4. Display the final formation order
        // 5. Ensure that duplicates do not appear in the output
        System.out.println("\nFinal Train Formation: " + trainFormation);

        // Program continues...
    }
}