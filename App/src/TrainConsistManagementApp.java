import java.util.*;

public class TrainConsistManagementApp {

    // UC10: Total seat calculation using reduce
    public int getTotalSeatCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }
}