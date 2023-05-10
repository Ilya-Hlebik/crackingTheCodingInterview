package Ch_07_Object_Oriented_Design.Q7_04_Parking_Lot;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Level {
    private int floor;
    private List<List<ParkingSpot>> parkingSpots;
    private int availableSpots;
    private static final int SPOTS_PER_ROW = 10;

    public Level(int flr, int numberSpots) {
        floor = flr;
        parkingSpots = new ArrayList<>();
        int largeSpots = numberSpots / 4;
        int bikeSpots = numberSpots / 4;
        int compactSpots = numberSpots - largeSpots - bikeSpots;
        for (int i = 0; i < numberSpots / SPOTS_PER_ROW; i++) {
            parkingSpots.add(new ArrayList<>());
        }
        for (int i = 0, j = 0; i < numberSpots; i++, j = i / 10) {
            VehicleSize sz = VehicleSize.Moto;
            if (i < largeSpots) {
                sz = VehicleSize.Large;
            } else if (i < largeSpots + compactSpots) {
                sz = VehicleSize.Compact;
            }
            int row = i / SPOTS_PER_ROW;
            parkingSpots.get(j).add(new ParkingSpot(this, row, i, sz));
        }
        availableSpots = numberSpots;
    }

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

    private void assignCarToSpot(Vehicle vehicle, ParkingSpot spot) {
        spot.setVehicle(vehicle);
        spot.setEmpty(false);
        availableSpots--;
        vehicle.parkInSpot(spot);
    }

    public void spotFreed() {
        availableSpots++;
    }

    public void print() {
        AtomicInteger lastRow = new AtomicInteger(-1);
        parkingSpots
                .stream()
                .flatMap(Collection::stream)
                .forEach(parkingSpot -> {
                    if (parkingSpot.getRowNumber() != lastRow.get()) {
                        System.out.print("  ");
                        lastRow.set(parkingSpot.getRowNumber());
                    }
                    parkingSpot.print();
                });
    }
}
