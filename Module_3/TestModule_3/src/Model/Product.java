package Model;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;
    private int discount;
    private int stock;

    public Product() {
    }

    public Product(String nameProduct, double price, int discount, int stock) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public Product(int idProduct, String nameProduct, double price, int discount, int stock) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.discount = discount;
        this.stock = stock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
