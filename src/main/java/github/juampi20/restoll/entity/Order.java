package github.juampi20.restoll.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "total_price")
    private Double totalPrice;

    @JsonManagedReference
    @OneToMany(mappedBy = "order", targetEntity = OrderProduct.class)
    private Set<OrderProduct> orderProducts;

    @JsonManagedReference
    @OneToOne(mappedBy = "order", optional = false, targetEntity = Client.class)
    private Client client;

    public Order() {
    }

    public Order(Long id, Double totalPrice, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.orderProducts = orderProducts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void updateOrderProducts(OrderProduct orderProduct) {
        this.getOrderProducts().add(orderProduct);
    }

    public void updateTotalOrderPrice() {
        double sum = 0D;
        Set<OrderProduct> orderProducts = getOrderProducts();
        for (OrderProduct op : orderProducts) {
            sum += op.getTotalPrice();
        }
        this.totalPrice = sum;
    }

}
