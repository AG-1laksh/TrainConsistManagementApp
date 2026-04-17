public class Bogie {
    private String type;
    private String cargo;
    private int capacity;

    public Bogie(String type, String cargo, int capacity) {
        this.type = type;
        this.cargo = cargo;
        this.capacity = capacity;
    }

    public Bogie(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getCapacity() {
        return capacity;
    }
}
