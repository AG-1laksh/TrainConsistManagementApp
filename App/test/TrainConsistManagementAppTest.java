
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Exception when empty
    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] ids = {};

        Exception ex = assertThrows(IllegalStateException.class, () -> {
            app.searchBogie(ids, "BG101");
        });

        assertEquals("No bogies available for search", ex.getMessage());
    }

    // 2. Allows search when data exists
    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] ids = {"BG101","BG205"};

        assertDoesNotThrow(() -> {
            app.searchBogie(ids, "BG101");
        });
    }

    // 3. Found after validation
    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};

        assertTrue(app.searchBogie(ids, "BG205"));
    }

    // 4. Not found after validation
    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] ids = {"BG101","BG205","BG309"};

        assertFalse(app.searchBogie(ids, "BG999"));
    }

    // 5. Single element case
    @Test
    void testSearch_SingleElementValidCase() {
        String[] ids = {"BG101"};

        assertTrue(app.searchBogie(ids, "BG101"));
    }
}