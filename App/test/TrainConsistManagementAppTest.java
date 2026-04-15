import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Bogies grouped correctly
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

    // 2. Multiple bogies in same group
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

    // 3. Different bogie types
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

    // 4. Empty list
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> result = app.groupBogiesByType(bogies);

        assertTrue(result.isEmpty());
    }

    // 5. Single category
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

    // 6. Map contains correct keys
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

    // 7. Group size validation
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

    // 8. Original list unchanged
    @Test
    void testGrouping_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper"));
        bogies.add(new Bogie("AC Chair"));

        int originalSize = bogies.size();

        app.groupBogiesByType(bogies);

        assertEquals(originalSize, bogies.size());
    }
}