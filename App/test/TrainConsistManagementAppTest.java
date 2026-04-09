import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {
    private TrainConsistManagementApp app;
    private List<bogie> bogieList;

    @BeforeEach
    void setUp() {
        app = new TrainConsistManagementApp();
        bogieList = new ArrayList<>();
        // Adding sample bogies for testing
        bogieList.add(new bogie("Sleeper", 72));
        bogieList.add(new bogie("AC Chair", 60));
        bogieList.add(new bogie("First Class", 24));
        bogieList.add(new bogie("General", 80));
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        // Testing threshold of 70
        List<bogie> result = app.filterHighCapacityBogies(bogieList, 70);
        assertEquals(2, result.size(), "Should return 2 bogies (72 and 80)");
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        // Threshold is 60. AC Chair is 60, so it should be EXCLUDED (using >)
        List<bogie> result = app.filterHighCapacityBogies(bogieList, 60);
        assertTrue(result.stream().noneMatch(b -> b.getCapacity() == 60), "60 should be excluded");
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        int initialSize = bogieList.size();
        app.filterHighCapacityBogies(bogieList, 50);
        assertEquals(initialSize, bogieList.size(), "The original list--------- must not be modified");
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<bogie> result = app.filterHighCapacityBogies(bogieList, 100);
        assertTrue(result.isEmpty(), "List should be empty if no bogies match");
    }
}
