import java.util.LinkedList;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App: UC4 ===");

        // 1. Create a LinkedList<String> for the consist
        // We use the concrete LinkedList class here to access specific methods like removeFirst()
        LinkedList<String> trainConsist = new LinkedList<>();

        // 2. Add bogies: Engine, Sleeper, AC, Cargo, Guard
        // By default, add() appends to the end of the list (like addLast)
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist: " + trainConsist);

        // 3. Insert a Pantry Car at position 2
        // In Java, lists are zero-indexed. Index 2 means it will be inserted after Engine (0) and Sleeper (1)
        trainConsist.add(2, "Pantry Car");
        System.out.println("-> Inserted 'Pantry Car' at position 2.");
        System.out.println("Consist after insertion: " + trainConsist);

        // 4. Remove the first and last bogie
        String removedHead = trainConsist.removeFirst();
        String removedTail = trainConsist.removeLast();

        System.out.println("-> Detached head bogie: " + removedHead);
        System.out.println("-> Detached tail bogie: " + removedTail);

        // 5. Display the final ordered train consist
        System.out.println("\nFinal ordered train consist: " + trainConsist);

        // Program continues...
    }
}