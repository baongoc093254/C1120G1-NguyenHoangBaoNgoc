package Model;

public class Division {
    private int division_id;
    private String divison_name;

    public Division() {
    }

    public Division(int division_id, String divison_name) {
        this.division_id = division_id;
        this.divison_name = divison_name;
    }

    public int getDivision_id() {
        return division_id;
    }

    public void setDivision_id(int division_id) {
        this.division_id = division_id;
    }

    public String getDivison_name() {
        return divison_name;
    }

    public void setDivison_name(String divison_name) {
        this.divison_name = divison_name;
    }
}
