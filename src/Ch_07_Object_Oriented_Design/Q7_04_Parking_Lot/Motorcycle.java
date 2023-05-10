package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

public class Motorcycle extends Vehicle {
    public Motorcycle(){
        vehicleSize = VehicleSize.Moto;
    }

    @Override
    public void print() {
        System.out.print("M");
    }
}
