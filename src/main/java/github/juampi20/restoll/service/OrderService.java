package github.juampi20.restoll.service;

import github.juampi20.restoll.entity.Order;
import github.juampi20.restoll.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(Long id) {
        return orderRepository.findById(id);
    }

    public void updateOrder(Long id, Order newOrder) {
        orderRepository.findById(id)
                .map(order -> {
                    order.setOrderProducts(newOrder.getOrderProducts());
                    return orderRepository.save(order);
                });

    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
