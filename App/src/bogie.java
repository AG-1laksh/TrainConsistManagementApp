public class bogie {
    private String type;
    private int capacity;

    public bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    // This is the method your App is looking for!
    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return type + " (Capacity: " + capacity + ")";
    }
}