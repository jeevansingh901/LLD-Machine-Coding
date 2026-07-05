abstract class Vehicle {

    private final String vehicleNumber;
    private final VehicleType vehicleType;

    protected Vehicle(String vehicleNumber,
                  VehicleType vehicleType) {
    this.vehicleNumber = vehicleNumber;
    this.vehicleType = vehicleType;
}

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }


}