class ParkingSlot {
    
    private int slotId;
    private boolean isOccupied;
    private Vehicle vehicle;
    private String slotNo;
    private String slotType;

    public ParkingSlot(int slotId, String slotNo, String slotType) {
        this.slotId = slotId;
        this.slotNo = slotNo;
        this.slotType = slotType;
        this.isOccupied = false;
        this.vehicle = null;
    }

    public int getSlotId() {
        return slotId;
    }

    public String getSlotNo() {
        return slotNo;
    }

    public String getSlotType() {
        return slotType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}