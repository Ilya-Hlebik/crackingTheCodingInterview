package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

public class ParkingSpot {
    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int rowNumber;
    private int spotNumber;
    private boolean empty = true;
    private Level level;

    public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {
        level = lvl;
        rowNumber = r;
        spotNumber = n;
        spotSize = sz;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public void setSpotSize(VehicleSize spotSize) {
        this.spotSize = spotSize;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void removeVehicle() {
        setEmpty(true);
        setVehicle(null);
        level.spotFreed();
    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.Compact) {
                System.out.print("c");
            } else if (spotSize == VehicleSize.Large) {
                System.out.print("l");
            } else if (spotSize == VehicleSize.Moto) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }
}
