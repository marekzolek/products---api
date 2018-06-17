package sda.soft.academy.productsapi.entity;


import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "productSequenceGenerator")
    @SequenceGenerator(name = "productSequenceGenerator", sequenceName = "SEQ_PRODUCTS", allocationSize = 1)
    private Integer id;

    private String name;

    @Column(name = "code_ean")
    private String codeEan;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "type")
    private ProductType type;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCodeEan() {
        return codeEan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductType getType() {
        return type;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCodeEan(String codeEan) {
        this.codeEan = codeEan;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Product(Integer id, String name, String codeEan, BigDecimal price, ProductType type) {
        this.id = id;
        this.name = name;
        this.codeEan = codeEan;
        this.price = price;
        this.type = type;
    }

    public Product() {
    }
}
