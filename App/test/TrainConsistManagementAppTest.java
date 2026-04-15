
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // Helper method to generate data
    List<Bogie> generateBogies(int n) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Bogie("Type", i % 100));
        }
        return list;
    }

    // 1. Loop filtering test
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 80)
        );

        List<Bogie> result = app.filterBogiesUsingLoop(bogies);

        assertEquals(2, result.size());
    }

    // 2. Stream filtering test
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", 50),
                new Bogie("B", 70),
                new Bogie("C", 80)
        );

        List<Bogie> result = app.filterBogiesUsingStream(bogies);

        assertEquals(2, result.size());
    }

    // 3. Results match
    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = generateBogies(100);

        List<Bogie> loopResult = app.filterBogiesUsingLoop(bogies);
        List<Bogie> streamResult = app.filterBogiesUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    // 4. Execution time test
    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = generateBogies(1000);

        long loopTime = app.measureLoopTime(bogies);
        long streamTime = app.measureStreamTime(bogies);

        assertTrue(loopTime > 0);
        assertTrue(streamTime > 0);
    }

    // 5. Large dataset
    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = generateBogies(10000);

        List<Bogie> result = app.filterBogiesUsingStream(bogies);

        assertNotNull(result);
    }
}