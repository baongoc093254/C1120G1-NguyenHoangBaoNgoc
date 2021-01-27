package bai15_IO_BinaryFile_Serialization.baitap;


public class Product {
    private String id;
    private String name;
    private String manufacter;
    private float price;
    private String anotherInfor;

    public Product(String id, String name, String manufacter, float price, String anotherInfor) {
        this.id = id;
        this.name = name;
        this.manufacter = manufacter;
        this.price = price;
        this.anotherInfor = anotherInfor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacter() {
        return manufacter;
    }

    public void setManufacter(String manufacter) {
        this.manufacter = manufacter;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAnotherInfor() {
        return anotherInfor;
    }

    public void setAnotherInfor(String anotherInfor) {
        this.anotherInfor = anotherInfor;
    }

    @Override
    public String toString() {
        return "InforProduct: " +
                "Id = " + id +
                ", name = '" + name + '\'' +
                ", manufacter = '" + manufacter + '\'' +
                ", price = " + price +
                ", anotherInfor = '" + anotherInfor + '\'';
    }
    public String getInfor() {
        return id + "," + name + "," + manufacter +  "," + price + "," + anotherInfor;
    }
}
