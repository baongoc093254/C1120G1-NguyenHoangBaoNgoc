package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private Integer id;

    @Pattern(regexp = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])",message = " Right format YYYY-MM-DD")
    @Column(name = "contract_date_buy", columnDefinition = "DATE")
    private String date_buy;

//    @Pattern(regexp = "^[0-9]*[1-9][0-9]*(\\.[0-9]+)?$", message = "Deposit invalid")
    @Column(name = "quantity", columnDefinition = "int not null")
    private String quantity;


    @Column(name = "total")
    private Double total;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate_buy() {
        return date_buy;
    }

    public void setDate_buy(String date_buy) {
        this.date_buy = date_buy;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
