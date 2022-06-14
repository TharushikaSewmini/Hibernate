package lk.ijse.thogakade.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    private String cId;
    private String name;
    private double salary;
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<>();

    public Customer() {
    }

    public Customer(String cId, String name, double salary, String address) {
        this.cId = cId;
        this.name = name;
        this.salary = salary;
        this.address = address;
    }

    public Customer(String cId, String name, double salary, String address, List<Order> orderList) {
        this.cId = cId;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.orderList = orderList;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cId='" + cId + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
