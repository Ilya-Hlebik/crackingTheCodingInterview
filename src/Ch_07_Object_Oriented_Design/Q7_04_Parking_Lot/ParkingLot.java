package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private final int NUM_LEVELS = 5;

    public ParkingLot() {
        levels = new ArrayList<>();
        for (int i = 0; i < NUM_LEVELS; i++) {
            levels.add(new Level(i, 30));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for (int i = 0; i < levels.size(); i++) {
            System.out.print("Level" + i + ": ");
            levels.get(i).print();
            System.out.println("");
        }
        System.out.println("");
    }
}
