class Ticket {
    String ticketNo;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    long entryTime;
    long exitTime;

    public Ticket(String ticketNo, Vehicle vehicle, ParkingSlot parkingSlot, long entryTime) {
        this.ticketNo = ticketNo;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = entryTime;
    }   

    public String getTicketNo() {
        return ticketNo;
    }

    public String getVehicleNo() {
        return vehicle.getVehicleNumber();
    }

    public String getParkingslotNo() {
        return parkingSlot.getSlotNumber();
    }

    public String getParkingSlotId() {
        return parkingSlot.getSlotId();
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}