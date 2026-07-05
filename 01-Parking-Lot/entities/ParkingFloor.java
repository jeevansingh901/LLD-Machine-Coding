public class ParkingFloor {

    private final int floorNumber;

    private final List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNumber,
                        List<ParkingSlot> parkingSlots) {

        this.floorNumber = floorNumber;
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSlot> getParkingSlots() {
        return Collections.unmodifiableList(parkingSlots);
    }

    public ParkingSlot findAvailableSlot(SlotType slotType) {

        for (ParkingSlot slot : parkingSlots) {

            if (slot.isAvailable()
                    && slot.getSlotType() == slotType) {

                return slot;
            }
        }

        return null;
    }

    public boolean hasAvailableSlot(SlotType slotType) {
        return findAvailableSlot(slotType) != null;
    }
}