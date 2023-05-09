package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    protected List<ParkingSpot> parkingSpots = new ArrayList<>();
    protected VehicleSize vehicleSize;
    protected int spotsNeeded;

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }
    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }
    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }
}
