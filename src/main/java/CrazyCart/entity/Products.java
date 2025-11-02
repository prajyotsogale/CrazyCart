package CrazyCart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="category")
    private String category;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="description")
    private String description;
    @Column(name="image_url")
    private String imageUrl;
    @Column(name="brand")
    private String brand;
    @Column(name="stock")
    private int stock;
    @Column(name="created_at")
    private String createdAt;

    public Products() {
    }

    public Products(String name, String category, BigDecimal price, String description, String imageUrl, String brand, int stock, String createdAt) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.stock = stock;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", brand='" + brand + '\'' +
                ", stock=" + stock +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
