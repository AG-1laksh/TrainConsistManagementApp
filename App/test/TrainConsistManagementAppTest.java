
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Bogie found
    @Test
    void testSearch_BogieFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.linearSearch(ids, "BG309"));
    }

    // 2. Bogie not found
    @Test
    void testSearch_BogieNotFound() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertFalse(app.linearSearch(ids, "BG999"));
    }

    // 3. First element match
    @Test
    void testSearch_FirstElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.linearSearch(ids, "BG101"));
    }

    // 4. Last element match
    @Test
    void testSearch_LastElementMatch() {
        String[] ids = {"BG101","BG205","BG309","BG412","BG550"};

        assertTrue(app.linearSearch(ids, "BG550"));
    }

    // 5. Single element array
    @Test
    void testSearch_SingleElementArray() {
        String[] ids = {"BG101"};

        assertTrue(app.linearSearch(ids, "BG101"));
    }
}