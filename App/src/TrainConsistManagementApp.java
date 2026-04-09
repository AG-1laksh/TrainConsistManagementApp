import java.util.List;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // UC8: Filter high-capacity passenger bogies
    public List<bogie> filterHighCapacityBogies(List<bogie> bogies, int threshold) {
        return bogies.stream()                         // 1. Create Stream
                .filter(b -> b.getCapacity() > threshold) // 2. Apply Condition
                .collect(Collectors.toList());        // 3. Collect to new List
    }
}