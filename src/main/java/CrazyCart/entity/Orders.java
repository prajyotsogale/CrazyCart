package CrazyCart.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private Users users;

    private BigDecimal total;

    @Column(name = "order_date")
    private LocalDateTime orderDate;;

    private String status = "Pending";

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public Orders() {
    }

    public Orders(BigDecimal total, LocalDateTime orderDate, String status) {
        this.total = total;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Orders(Users users, BigDecimal total, LocalDateTime orderDate, String status, List<OrderItem> orderItems) {
        this.users = users;
        this.total = total;
        this.orderDate = orderDate;
        this.status = status;
        this.orderItems = orderItems;
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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", users=" + users +
                ", total=" + total +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                ", orderItems=" + orderItems +
                '}';
    }
}
