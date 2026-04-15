import java.util.*;

public class TrainConsistManagementApp {

    // UC12: Safety validation
    public boolean isTrainSafe(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }
}