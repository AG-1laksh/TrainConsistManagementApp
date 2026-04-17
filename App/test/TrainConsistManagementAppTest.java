
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Safe assignment
    @Test
    void testCargo_SafeAssignment() {
        Bogie b = new Bogie("Cylindrical");

        boolean result = app.assignCargo(b, "Petroleum");

        assertTrue(result);
        assertEquals("Petroleum", b.getCargo());
    }

    // 2. Unsafe assignment handled
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        Bogie b = new Bogie("Rectangular");

        boolean result = app.assignCargo(b, "Petroleum");

        assertFalse(result);
    }

    // 3. Cargo not assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        Bogie b = new Bogie("Rectangular");

        app.assignCargo(b, "Petroleum");

        assertNull(b.getCargo());
    }

    // 4. Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        Bogie b1 = new Bogie("Rectangular");
        Bogie b2 = new Bogie("Cylindrical");

        boolean r1 = app.assignCargo(b1, "Petroleum"); // fail
        boolean r2 = app.assignCargo(b2, "Petroleum"); // success

        assertFalse(r1);
        assertTrue(r2);
    }

    // 5. Finally block execution (indirect check)
    @Test
    void testCargo_FinallyBlockExecution() {
        Bogie b = new Bogie("Rectangular");

        boolean result = app.assignCargo(b, "Petroleum");

        assertFalse(result); // ensures flow completed
    }
}