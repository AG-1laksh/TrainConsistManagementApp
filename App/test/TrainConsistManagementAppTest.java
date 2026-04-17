import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // Helper method to generate data (UC13)
    List<Bogie> generateBogies(int n) {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Bogie("Type", "Cargo", i % 100));
        }
        return list;
    }

    // ================= UC15 TEST CASES =================

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

    // ================= UC11 TEST CASES =================

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(app.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(app.isValidTrainID("TRAIN12"));
        assertFalse(app.isValidTrainID("TRN12A"));
        assertFalse(app.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(app.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(app.isValidCargoCode("PET-ab"));
        assertFalse(app.isValidCargoCode("PET123"));
        assertFalse(app.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(app.isValidTrainID("TRN-123"));
        assertFalse(app.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(app.isValidCargoCode("PET-Ab"));
        assertFalse(app.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(app.isValidTrainID(""));
        assertFalse(app.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(app.isValidTrainID("TRN-1234XYZ"));
        assertFalse(app.isValidCargoCode("PET-AB123"));
    }

    // ================= UC12 TEST CASES =================

    @Test
    void testSafety_AllSafe() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Petroleum", 50),
                new Bogie("Box", "Grain", 60)
        );
        assertTrue(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_UnsafeCylindricalBogie() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Cylindrical", "Grain", 50)
        );
        assertFalse(app.isTrainSafe(bogies));
    }

    @Test
    void testSafety_NonCylindricalAnyCargoIsSafe() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Box", "Chemicals", 40)
        );
        assertTrue(app.isTrainSafe(bogies));
    }

    // ================= UC13 TEST CASES =================

    // 1. Loop filtering test
    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", "X", 50),
                new Bogie("B", "X", 70),
                new Bogie("C", "X", 80)
        );

        List<Bogie> result = app.filterBogiesUsingLoop(bogies);

        assertEquals(2, result.size());
    }

    // 2. Stream filtering test
    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("A", "X", 50),
                new Bogie("B", "X", 70),
                new Bogie("C", "X", 80)
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

    // ================= UC14 TEST CASES =================

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
