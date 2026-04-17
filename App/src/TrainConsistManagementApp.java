import java.util.Arrays;

public class TrainConsistManagementApp {

    // UC16: Bubble Sort
    public int[] bubbleSort(int[] arr) {

        int n = arr.length;

        // Outer loop (passes)
        for (int i = 0; i < n - 1; i++) {

            // Inner loop (comparison)
            for (int j = 0; j < n - i - 1; j++) {

                // Swap if out of order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }

    // UC17: Sort bogie names using Arrays.sort()
    public String[] sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
        return bogieNames;
    }

    // UC18: Linear Search
    public boolean linearSearch(String[] bogieIds, String key) {

        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // found
            }
        }

        return false; // not found
    }

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

    // UC20: Linear Search with Exception Handling
    public boolean searchBogie(String[] bogieIds, String key) {

        // Fail-fast check
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available for search");
        }

        // Normal search (linear)
        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true;
            }
        }

        return false;
    }
}
