package Model;

public class Position {
    private int position_id;
    private String posotion_name;

    public Position() {
    }

    public Position(int position_id, String posotion_name) {
        this.position_id = position_id;
        this.posotion_name = posotion_name;
    }

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public String getPosotion_name() {
        return posotion_name;
    }

    public void setPosotion_name(String posotion_name) {
        this.posotion_name = posotion_name;
    }
}
