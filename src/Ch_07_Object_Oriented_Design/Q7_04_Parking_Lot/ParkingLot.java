package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.List;

public class ParkingLot {
    private List<Level> levels;

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.parkVehicle(vehicle)){

            }
        }
        return false;
    }
}
