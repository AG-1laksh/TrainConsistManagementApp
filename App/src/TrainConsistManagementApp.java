
public class TrainConsistManagementApp {

    public boolean assignCargo(Bogie bogie, String cargo) {

        try {
            // Unsafe condition
            if (bogie.getType().equalsIgnoreCase("Rectangular")
                    && cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException("Unsafe cargo assignment!");
            }

            // Safe assignment
            bogie.setCargo(cargo);
            return true;

        } catch (CargoSafetyException e) {
            // Handle safely
            System.out.println("Error: " + e.getMessage());
            return false;

        } finally {
            // Always executes
            System.out.println("Assignment attempt completed.");
        }
    }
}