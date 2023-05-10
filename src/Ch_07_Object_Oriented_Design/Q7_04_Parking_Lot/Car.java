package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

public class Car extends Vehicle {
    public Car() {
        vehicleSize = VehicleSize.Compact;
    }

    @Override
    public void print() {
        System.out.print("C");
    }
}
