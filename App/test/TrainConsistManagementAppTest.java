import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;
    private List<Bogie> bogieList;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        bogieList = new ArrayList<>();

        // Arrange: Adding a mix of bogies (2 Sleepers, 1 AC, 1 First Class)
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 24));
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        // Act
        Map<String, List<Bogie>> grouped = app.groupBogiesByType(bogieList);

        // Assert
        assertNotNull(grouped);
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size(), "Should have 2 Sleeper bogies");
        assertEquals(1, grouped.get("AC Chair").size(), "Should have 1 AC Chair bogie");
    }

    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        Map<String, List<Bogie>> result = app.groupBogiesByType(emptyList);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGrouping_OriginalListUnchanged() {
        int originalSize = bogieList.size();
        app.groupBogiesByType(bogieList);
        assertEquals(originalSize, bogieList.size(), "The source list should not be modified");
    }
}