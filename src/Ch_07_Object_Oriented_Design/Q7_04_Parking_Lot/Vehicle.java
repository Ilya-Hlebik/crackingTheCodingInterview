package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    protected List<ParkingSpot> parkingSpots = new ArrayList<>();
    protected VehicleSize vehicleSize;
    protected int spotsNeeded;

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }
    public void clearSpots() {
        for (ParkingSpot parkingSpot : parkingSpots) {
            parkingSpot.removeVehicle();
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

    public abstract void print();
}
