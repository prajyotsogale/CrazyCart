package CrazyCart.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="full_name")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="profile_image")
    private String profileImage;

    @OneToOne
    @JoinColumn(name="username")
    private Users users;

    public Profiles() {
    }

    public Profiles(String fullName, String email, String phone, String address,String profileImage) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.profileImage = profileImage;
    }

    public Profiles(String fullName, String email, String phone, String address, Users users,String profileImage) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.profileImage = profileImage;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Profiles{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", profileImage='" + profileImage + '\'' +
                ", users=" + users +
                '}';
    }
}
