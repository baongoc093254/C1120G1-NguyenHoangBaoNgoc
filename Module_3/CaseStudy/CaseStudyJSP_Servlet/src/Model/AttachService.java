package Model;

public class AttachService {
    private int attact_service_id;
    private String attact_service_name;
    private double attact_service_cost;
    private int attact_service_unit;
    private String attact_service_status;

    public AttachService() {
    }

    public AttachService(int attact_service_id, String attact_service_name, double attact_service_cost, int attact_service_unit, String attact_service_status) {
        this.attact_service_id = attact_service_id;
        this.attact_service_name = attact_service_name;
        this.attact_service_cost = attact_service_cost;
        this.attact_service_unit = attact_service_unit;
        this.attact_service_status = attact_service_status;
    }

    public int getAttact_service_id() {
        return attact_service_id;
    }

    public void setAttact_service_id(int attact_service_id) {
        this.attact_service_id = attact_service_id;
    }

    public String getAttact_service_name() {
        return attact_service_name;
    }

    public void setAttact_service_name(String attact_service_name) {
        this.attact_service_name = attact_service_name;
    }

    public double getAttact_service_cost() {
        return attact_service_cost;
    }

    public void setAttact_service_cost(double attact_service_cost) {
        this.attact_service_cost = attact_service_cost;
    }

    public int getAttact_service_unit() {
        return attact_service_unit;
    }

    public void setAttact_service_unit(int attact_service_unit) {
        this.attact_service_unit = attact_service_unit;
    }

    public String getAttact_service_status() {
        return attact_service_status;
    }

    public void setAttact_service_status(String attact_service_status) {
        this.attact_service_status = attact_service_status;
    }
}
