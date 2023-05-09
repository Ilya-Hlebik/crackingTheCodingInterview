package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.*;

public class Level {
    private int floor;
    private List<List<ParkingSpot>> parkingSpots;
    private int availableSpots;
    private static final int SPOTS_PER_ROW = 10;

    public boolean parkVehicle(Vehicle vehicle) {
        if (availableSpots == 0) {
            return false;
        }
        if (vehicle.getVehicleSize() == VehicleSize.Moto) {
            Optional<ParkingSpot> firstMotoPriority = parkingSpots.stream()
                    .flatMap(Collection::stream)
                    .filter(ParkingSpot::isEmpty)
                    .min(Comparator.comparing(ParkingSpot::getSpotSize));
            firstMotoPriority.ifPresent(parkingSpot -> assignCarToSpot(vehicle, parkingSpot));
            return true;
        } else if (vehicle.getVehicleSize() == VehicleSize.Compact) {
            Optional<ParkingSpot> firstCompactPriority = parkingSpots.stream()
                    .flatMap(Collection::stream)
                    .filter(parkingSpot -> parkingSpot.getSpotSize() != VehicleSize.Moto)
                    .filter(ParkingSpot::isEmpty)
                    .min(Comparator.comparing(ParkingSpot::getSpotSize));
            if (firstCompactPriority.isPresent()) {
                assignCarToSpot(vehicle, firstCompactPriority.get());
                return true;
            }
            firstCompactPriority.ifPresent(parkingSpot -> assignCarToSpot(vehicle, parkingSpot));
        } else {
            for (List<ParkingSpot> parkingSpotList : parkingSpots) {
                List<ParkingSpot> largeSpotList = new ArrayList<>();
                for (ParkingSpot spot : parkingSpotList) {
                    if (spot.getSpotSize() == VehicleSize.Large && spot.isEmpty()) {
                        largeSpotList.add(spot);
                    } else {
                        largeSpotList.clear();
                    }
                    if (largeSpotList.size() == 5) {
                        break;
                    }
                }
                if (largeSpotList.size() == 5) {
                    largeSpotList.forEach(parkingSpot -> assignCarToSpot(vehicle, parkingSpot));
                    return true;
                }
            }
        }
        return false;
    }

    private void assignCarToSpot(Vehicle vehicle, ParkingSpot firstCompactPriority) {
        firstCompactPriority.setVehicle(vehicle);
        firstCompactPriority.setEmpty(false);
        availableSpots--;
        vehicle.
    }

    public void spotFreed() {
        availableSpots++;
    }
}
