
public class TrainConsistManagementApp {

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