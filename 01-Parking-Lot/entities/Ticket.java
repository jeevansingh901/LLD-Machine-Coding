class Ticket {
    String ticketNo;
    String vehicleNo;
    String parkingslotNo;
    String parkingSlotId;
    long entryTime;
    long exitTime;

    public Ticket(String ticketNo, String vehicleNo, String parkingslotNo, String parkingSlotId, long entryTime) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
        this.parkingslotNo = parkingslotNo;
        this.parkingSlotId = parkingSlotId;
        this.entryTime = entryTime;
    }   

    public String getTicketNo() {
        return ticketNo;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public String getParkingslotNo() {
        return parkingslotNo;
    }

    public String getParkingSlotId() {
        return parkingSlotId;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }
}