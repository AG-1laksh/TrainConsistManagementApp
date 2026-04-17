
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    TrainConsistManagementApp app = new TrainConsistManagementApp();

    // 1. Basic alphabetical sorting
    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] expected = {"AC Chair","First Class","General","Luxury","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 2. Unsorted input
    @Test
    void testSort_UnsortedInput() {
        String[] input = {"Luxury","General","Sleeper","AC Chair"};
        String[] expected = {"AC Chair","General","Luxury","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 3. Already sorted
    @Test
    void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair","First Class","General"};
        String[] expected = {"AC Chair","First Class","General"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 4. Duplicate names
    @Test
    void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper","AC Chair","Sleeper","General"};
        String[] expected = {"AC Chair","General","Sleeper","Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }

    // 5. Single element
    @Test
    void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};

        assertArrayEquals(expected, app.sortBogieNames(input));
    }
}