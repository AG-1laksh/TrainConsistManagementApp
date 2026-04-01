import java.util.ArrayList;
import java.util.List;

// A minimal placeholder class for Bogies to be expanded in future Use Cases
class Bogie {
    // Properties like type, capacity, and cargo will be added here later
}

public class TrainConsistManagementApp {

    // Entry point of the Java application
    // FIXED: Changed method name from TrainConsistApp to main
    public static void main(String[] args) {

        // 1. Application prints welcome message
        System.out.println("=== Train Consist Management App ===");

        // 2. Train consist is initialized using the List interface and ArrayList implementation
        List<Bogie> trainConsist = new ArrayList<>();
        System.out.println("Train consist initialized successfully.");

        // 3. Initial bogie count is displayed using the size() method
        System.out.println("Initial bogie count: " + trainConsist.size());

        // Program continues... (Future use cases will be added below)
    }
}