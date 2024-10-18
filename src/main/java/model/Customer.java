package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;

    // dua tren thang customer, customer ra doi truoc, roi moi sinh ra thang order
    @OneToMany(mappedBy = "customer")
    private List<My_Order> orders;

    public Customer() {
    }

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Customer(String id, String name, String email, List<My_Order> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<My_Order> getOrders() {
        return orders;
    }

    public void setOrders(List<My_Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", orders=" + orders.stream().map(My_Order::getOrder_id).collect(Collectors.toList()) +
                '}';
    }
}
