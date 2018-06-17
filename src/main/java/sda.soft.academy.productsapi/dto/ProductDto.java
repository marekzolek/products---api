package sda.soft.academy.productsapi.dto;

import java.math.BigDecimal;

public class ProductDto {

    private Integer id;

    private String EAN;

    private String name;

    private BigDecimal price;

    private Integer type;

    public ProductDto(Integer id, String EAN, String name, BigDecimal price, Integer type) {
        this.id = id;
        this.EAN = EAN;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getEAN() {
        return EAN;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", EAN='" + EAN + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
