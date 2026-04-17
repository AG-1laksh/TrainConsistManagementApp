
import java.util.Arrays;

public class TrainConsistManagementApp {

    // UC19: Binary Search
    public boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds.length == 0) {
            return false;
        }

        // Sort first (important)
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = bogieIds[mid].compareTo(key);

            if (compare == 0) {
                return true; // found
            }
            else if (compare < 0) {
                low = mid + 1; // search right
            }
            else {
                high = mid - 1; // search left
            }
        }

        return false; // not found
    }
}