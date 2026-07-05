class ParkingFloor{

    int floorNo;
    List<ParkingSlot> parkingSlots;

    public ParkingFloor(int floorNo, List<ParkingSlot> parkingSlots) {
        this.floorNo = floorNo;
        this.parkingSlots = parkingSlots;
    }

    public int getFloorNo() {
        return floorNo;
    }
    
    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(List<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

}