import lk.ijse.thogakade.entity.Customer;
import lk.ijse.thogakade.entity.Item;
import lk.ijse.thogakade.entity.Order;
import lk.ijse.thogakade.entity.OrderDetail;
import lk.ijse.thogakade.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class AppInitializer {
    public static void main(String[] args) {
        Customer c1 = new Customer();
        c1.setcId("C001");
        c1.setName("Nimal");
        c1.setSalary(20000);
        c1.setAddress("Kalutara");

        Customer c2 = new Customer();
        c2.setcId("C002");
        c2.setName("Kamal");
        c2.setSalary(30000);
        c2.setAddress("Panadura");

        Item i1 = new Item();
        i1.setCode("I001");
        i1.setDescription("Biscuit");
        i1.setPrice(50);
        i1.setQtyOnHand(100);

        Item i2 = new Item();
        i2.setCode("I002");
        i2.setDescription("Chocolate");
        i2.setPrice(100);
        i2.setQtyOnHand(60);

        Order o1 = new Order();
        o1.setoId("O001");
        o1.setCustomer(c1);

        Order o2 = new Order();
        o2.setoId("O002");
        o2.setCustomer(c2);

        OrderDetail od1 = new OrderDetail();
        od1.setId("OD001");
        od1.setOrder(o1);
        od1.setItem(i1);
        od1.setQty(5);

        OrderDetail od2 = new OrderDetail();
        od2.setId("OD002");
        od2.setOrder(o2);
        od2.setItem(i2);
        od2.setQty(2);

        ArrayList<Order> orderList = new ArrayList<>();
        orderList.add(o1);
        orderList.add(o2);

        c1.setOrderList(orderList);
        c2.setOrderList(orderList);

        ArrayList<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(od1);
        orderDetailList.add(od2);

        i1.setOrderDetailList(orderDetailList);
        i2.setOrderDetailList(orderDetailList);

        o1.setOrderDetailList(orderDetailList);
        o2.setOrderDetailList(orderDetailList);



        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


        //save customer
        session.save(c1);
        session.save(c2);

        /*//update customer
        session.update(c1);

        //load customer
        Customer customer1 = session.get(Customer.class, "C001");
        System.out.println(customer1);

        //delete customer
        Customer customer2 = session.get(Customer.class, "C002");
        session.delete(customer2);*/


        //save Item
        session.save(i1);
        session.save(i2);

       /* //update Item
        session.update(i1);

        //load Item
        Item item1 = session.get(Item.class, "I001");
        System.out.println(item1);

        //delete Item
        Item item2 = session.get(Item.class, "I002");
        session.delete(item2);*/



        //save Order
        session.save(o1);
        session.save(o2);

        //save OrderDetail
        session.save(od1);
        session.save(od2);

        transaction.commit();

        session.close();
    }
}
