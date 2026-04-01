import java.util.HashSet;
import java.util.Set;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC3 ===");

        // 1. Create a HashSet<String> for bogie IDs using the Set interface
        Set<String> uniqueBogieIDs = new HashSet<>();

        // 2. Add bogie IDs
        System.out.println("Adding bogie ID: BG101");
        uniqueBogieIDs.add("BG101");

        System.out.println("Adding bogie ID: BG102");
        uniqueBogieIDs.add("BG102");

        System.out.println("Adding bogie ID: BG103");
        uniqueBogieIDs.add("BG103");

        // 3. Add a duplicate value intentionally
        System.out.println("Attempting to add duplicate bogie ID: BG101...");
        boolean isAdded = uniqueBogieIDs.add("BG101");

        // The add() method returns false if the element is already present
        System.out.println("-> Was duplicate BG101 successfully added? " + isAdded);

        // 4. Print the final set to observe automatic deduplication
        System.out.println("\nFinal registered bogie IDs: " + uniqueBogieIDs);

        // Program continues...
    }
}