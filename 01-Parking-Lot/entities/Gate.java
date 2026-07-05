public abstract class Gate {

    private final int gateId;

    private final String gateName;

    protected Gate(int gateId,
                   String gateName) {

        this.gateId = gateId;
        this.gateName = gateName;
    }

    public int getGateId() {
        return gateId;
    }

    public String getGateName() {
        return gateName;
    }
}