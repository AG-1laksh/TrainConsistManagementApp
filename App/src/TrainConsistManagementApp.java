import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// 1. Create a Bogie class with fields such as name and capacity
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

    // Overriding toString() to format the output nicely
    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC7 ===");

        // 2. Create a List<Bogie> to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // 3. Add bogies like Sleeper, AC Chair, and First Class with capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 24));

        System.out.println("--- Unsorted Bogies ---");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        // 4. Use Comparator.comparingInt() to define sorting based on capacity
        // This sorts the list in ascending order (lowest capacity to highest)
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // 5. Sort the list and display the sorted bogies
        System.out.println("\n--- Sorted Bogies by Capacity (Ascending) ---");
        for (Bogie bogie : passengerBogies) {
            System.out.println(bogie);
        }

        // Program continues...
    }
}