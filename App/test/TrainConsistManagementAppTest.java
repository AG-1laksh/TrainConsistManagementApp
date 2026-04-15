
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    // 1. Valid capacity
    @Test
    void testException_ValidCapacityCreation() throws Exception {
        bogie bogie = new bogie("Sleeper", 50);
        assertNotNull(bogie);
    }

    // 2. Negative capacity
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new bogie("Sleeper", -10);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // 3. Zero capacity
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new bogie("Sleeper", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // 4. Exception message validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception ex = assertThrows(InvalidCapacityException.class, () -> {
            new bogie("AC Chair", 0);
        });

        assertEquals("Capacity must be greater than zero", ex.getMessage());
    }

    // 5. Object integrity
    @Test
    void testException_ObjectIntegrityAfterCreation() throws Exception {
        bogie bogie = new bogie("First Class", 100);

        assertEquals("First Class", bogie.getType());
        assertEquals(100, bogie.getCapacity());
    }

    // 6. Multiple valid bogies
    @Test
    void testException_MultipleValidBogiesCreation() throws Exception {
        bogie b1 = new bogie("Sleeper", 50);
        bogie b2 = new bogie("AC Chair", 60);

        assertNotNull(b1);
        assertNotNull(b2);
    }
}