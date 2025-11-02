package CrazyCart.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Products product;


    @Column(name = "quantity")
    private int quantity;
    @Column(name = "added_at")
    private LocalDateTime addedAt = LocalDateTime.now();

    public CartItem() {
    }

    public CartItem(int quantity, LocalDateTime addedAt) {
        this.quantity = quantity;
        this.addedAt = addedAt;
    }

    public CartItem(Users users, Products product, int quantity, LocalDateTime addedAt) {
        this.users = users;
        this.product = product;
        this.quantity = quantity;
        this.addedAt = addedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", users=" + users +
                ", product=" + product +
                ", quantity=" + quantity +
                ", addedAt=" + addedAt +
                '}';
    }
}
