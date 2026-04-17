
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Found
    @Test
    void testBinarySearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.binarySearch(ids, "BG309"));
    }

    // 2. Not found
    @Test
    void testBinarySearch_BogieNotFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(app.binarySearch(ids, "BG999"));
    }

    // 3. First element
    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.binarySearch(ids, "BG101"));
    }

    // 4. Last element
    @Test
    void testBinarySearch_LastElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.binarySearch(ids, "BG550"));
    }

    // 5. Single element
    @Test
    void testBinarySearch_SingleElementArray() {
        String[] ids = {"BG101"};

        assertTrue(app.binarySearch(ids, "BG101"));
    }

    // 6. Empty array
    @Test
    void testBinarySearch_EmptyArray() {
        String[] ids = {};

        assertFalse(app.binarySearch(ids, "BG101"));
    }

    // 7. Unsorted input handled
    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] ids = {"BG309","BG101","BG550","BG205","BG412"};

        assertTrue(app.binarySearch(ids, "BG205"));
    }
}