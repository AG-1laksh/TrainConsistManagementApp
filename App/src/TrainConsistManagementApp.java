
public class TrainConsistManagementApp {

    // UC18: Linear Search
    public boolean linearSearch(String[] bogieIds, String key) {

        for (String id : bogieIds) {
            if (id.equals(key)) {
                return true; // found
            }
        }

        return false; // not found
    }
}