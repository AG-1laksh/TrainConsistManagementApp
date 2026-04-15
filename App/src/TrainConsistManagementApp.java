import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getType));
    }
}