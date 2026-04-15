import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // UC10: Get total seat capacity
    public int getTotalSeatCapacity(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, Integer::sum);
    }

    // UC11: Validate Train ID
    public boolean isValidTrainID(String trainId) {
        Pattern pattern = Pattern.compile("TRN-\\d{4}");
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    // UC11: Validate Cargo Code
    public boolean isValidCargoCode(String cargoCode) {
        Pattern pattern = Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    // UC12: Safety validation
    public boolean isTrainSafe(List<Bogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        !b.getType().equalsIgnoreCase("Cylindrical") ||
                                b.getCargo().equalsIgnoreCase("Petroleum")
                );
    }

    // UC13: Loop-based filtering
    public List<Bogie> filterBogiesUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // UC13: Stream-based filtering
    public List<Bogie> filterBogiesUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // UC13: Loop timing
    public long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();

        filterBogiesUsingLoop(bogies);

        long end = System.nanoTime();
        return end - start;
    }

    // UC13: Stream timing
    public long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();

        filterBogiesUsingStream(bogies);

        long end = System.nanoTime();
        return end - start;
    }
}
