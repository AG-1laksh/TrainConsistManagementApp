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

    // 6. Basic alphabetical sorting
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 7. Unsorted input
    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 8. Duplicate names
    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 9. Single element (string)
    @Test
    void testSort_SingleStringElement() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

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
