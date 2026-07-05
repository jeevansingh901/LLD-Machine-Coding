import java.util.Objects;

public class ParkingSlot {

    private Vehicle vehicle;

    private final String slotNumber;

    private final SlotType slotType;

    public ParkingSlot(String slotNumber,
                       SlotType slotType) {

        this.slotNumber = Objects.requireNonNull(slotNumber);
        this.slotType = Objects.requireNonNull(slotType);
    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean isOccupied() {
        return vehicle != null;
    }

    public void parkVehicle(Vehicle vehicle) {

        Objects.requireNonNull(vehicle, "Vehicle cannot be null");

        if (isOccupied()) {
            throw new IllegalStateException(
                    "Parking slot is already occupied.");
        }

        if (vehicle.getVehicleType() != slotType) {
            throw new IllegalArgumentException(
                    "Vehicle type " + vehicle.getVehicleType()
                            + " cannot be parked in "
                            + slotType + " slot.");
        }

        this.vehicle = vehicle;
    }

    public Vehicle removeVehicle() {

        if (isAvailable()) {
            throw new IllegalStateException(
                    "Parking slot is already empty.");
        }

        Vehicle parkedVehicle = this.vehicle;
        this.vehicle = null;

        return parkedVehicle;
    }

    @Override
    public String toString() {

        return "ParkingSlot{" +
                "slotNumber='" + slotNumber + '\'' +
                ", slotType=" + slotType +
                ", occupied=" + isOccupied() +
                '}';
    }
}