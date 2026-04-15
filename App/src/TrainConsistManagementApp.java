
import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistManagementApp {

    // Loop-based filtering
    public List<Bogie> filterBogiesUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }

        return result;
    }

    // Stream-based filtering
    public List<Bogie> filterBogiesUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    // Loop timing
    public long measureLoopTime(List<Bogie> bogies) {
        long start = System.nanoTime();

        filterBogiesUsingLoop(bogies);

        long end = System.nanoTime();
        return end - start;
    }

    // Stream timing
    public long measureStreamTime(List<Bogie> bogies) {
        long start = System.nanoTime();

        filterBogiesUsingStream(bogies);

        long end = System.nanoTime();
        return end - start;
    }
}