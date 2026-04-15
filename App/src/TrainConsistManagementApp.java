import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }

    // UC10: Total seat calculation using reduce
    public int getTotalSeatCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }
}
