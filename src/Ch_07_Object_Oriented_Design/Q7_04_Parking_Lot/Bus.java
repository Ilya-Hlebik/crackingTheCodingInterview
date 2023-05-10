package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;


public class Bus extends Vehicle {
    public Bus() {
        vehicleSize = VehicleSize.Large;
    }

    @Override
    public void print() {
        System.out.print("B");
    }
}
