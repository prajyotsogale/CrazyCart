package CrazyCart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class Users {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name="enabled")
    private final int enabled = 1;

    public Users(String username, String password, String email) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Users() {
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
