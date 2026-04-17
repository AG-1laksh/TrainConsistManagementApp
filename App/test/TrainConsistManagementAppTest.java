import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Basic sorting
    @Test
    void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, app.bubbleSort(input));
    }

    // 2. Already sorted
    @Test
    void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};

        assertArrayEquals(expected, app.bubbleSort(input));
    }

    // 3. Duplicate values
    @Test
    void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};

        assertArrayEquals(expected, app.bubbleSort(input));
    }

    // 4. Single element
    @Test
    void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};

        assertArrayEquals(expected, app.bubbleSort(input));
    }

    // 5. All equal values
    @Test
    void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};

        assertArrayEquals(expected, app.bubbleSort(input));
    }
}