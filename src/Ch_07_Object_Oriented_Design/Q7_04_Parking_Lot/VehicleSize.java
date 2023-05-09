package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

public enum  VehicleSize {
    Moto(0), Compact(1), Large(2);
    int index;

    VehicleSize(int index) {
        this.index = index;
    }
}
