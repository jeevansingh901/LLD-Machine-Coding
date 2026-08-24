public class ParkingFloor {

    private final int floorNumber;

    private final List<ParkingSlot> parkingSlots;

    public ParkingFloor(
        int floorNumber,
        Map<SlotType, Integer> slotConfiguration) {

    this.floorNumber = floorNumber;
    this.parkingSlots = new ArrayList<>();

    initializeSlots(slotConfiguration);
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

    private void initializeSlots(
        Map<SlotType, Integer> slotConfiguration) {

    for (Map.Entry<SlotType, Integer> entry
            : slotConfiguration.entrySet()) {

        SlotType slotType = entry.getKey();
        int count = entry.getValue();

        for (int i = 1; i <= count; i++) {

            String slotNumber =
                    slotType.name().charAt(0) + "-" + i;

            parkingSlots.add(
                    new ParkingSlot(slotNumber, slotType)
            );
        }
    }
  }
}