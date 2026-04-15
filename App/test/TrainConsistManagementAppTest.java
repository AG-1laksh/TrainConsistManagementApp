import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // UC9 - 1. Bogies grouped correctly
    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("AC Chair"),
                new Bogie("Sleeper")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    // UC9 - 2. Multiple bogies in same group
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("Sleeper"),
                new Bogie("Sleeper")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(3, result.get("Sleeper").size());
    }

    // UC9 - 3. Different bogie types
    @Test
    void testGrouping_DifferentBogieTypes() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("AC Chair"),
                new Bogie("First Class")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(3, result.size());
    }

    // UC9 - 4. Empty list
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    // UC9 - 5. Single category
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("Sleeper")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(1, result.size());
        assertTrue(result.containsKey("Sleeper"));
    }

    // UC9 - 6. Map contains correct keys
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("AC Chair"),
                new Bogie("First Class")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
        assertTrue(result.containsKey("First Class"));
    }

    // UC9 - 7. Group size validation
    @Test
    void testGrouping_GroupSizeValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper"),
                new Bogie("Sleeper"),
                new Bogie("AC Chair")
        );

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    // UC9 - 8. Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper"));
        bogies.add(new Bogie("AC Chair"));

        int originalSize = bogies.size();

        app.groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size());
    }

    // UC10 - 1. Total seat calculation
    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 40)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(90, total);
    }

    // UC10 - 2. Multiple bogies
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

    // UC10 - 3. Single bogie
    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 60)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(60, total);
    }

    // UC10 - 4. Empty list
    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(0, total);
    }

    // UC10 - 5. Correct capacity extraction
    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20)
        );

        int total = app.getTotalSeatCapacity(bogies);

        assertEquals(30, total);
    }

    // UC10 - 6. All bogies included
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

    // UC10 - 7. Original list unchanged
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
