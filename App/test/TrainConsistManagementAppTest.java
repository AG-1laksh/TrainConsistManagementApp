import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

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
}
