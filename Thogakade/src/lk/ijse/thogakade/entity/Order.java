package lk.ijse.thogakade.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    private String oId;
    @CreationTimestamp
    private Date date;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public Order() {
    }

    public Order(String oId, List<OrderDetail> orderDetailList) {
        this.oId = oId;
        this.orderDetailList = orderDetailList;
    }

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oId='" + oId + '\'' +
                '}';
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
