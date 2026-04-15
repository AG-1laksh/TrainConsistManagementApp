import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Total seat calculation
    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 40)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(90, total);
    }

    // 2. Multiple bogies
    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 40)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(140, total);
    }

    // 3. Single bogie
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 60)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(60, total);
    }

    // 4. Empty list
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(0, total);
    }

    // 5. Correct capacity extraction
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(30, total);
    }

    // 6. All bogies included
    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20),
                new Bogie("First Class", 30)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(60, total);
    }

    // 7. Original list unchanged
    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 50));
        bogies.add(new Bogie("AC Chair", 40));

        int sizeBefore = bogies.size();

        app.getTotalSeatCapacity(bogies);

        assertEquals(sizeBefore, bogies.size());
    }
}