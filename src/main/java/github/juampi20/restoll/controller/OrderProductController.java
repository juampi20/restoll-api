package github.juampi20.restoll.controller;

import github.juampi20.restoll.entity.OrderProduct;
import github.juampi20.restoll.service.OrderProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-products")
public class OrderProductController {

    @Autowired
    OrderProductService orderProductService;

    @GetMapping
    public ResponseEntity<List<OrderProduct>> getAllOrderProducts() {
        return new ResponseEntity<>(orderProductService.getAllOrderProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOrderProduct(@PathVariable Long id) {
        return new ResponseEntity<>(orderProductService.getOrderProduct(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Object> createOrderProduct(@RequestBody OrderProduct orderProduct) {
        orderProductService.save(orderProduct);
        return new ResponseEntity<>("OrderProduct is created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long id) {
        orderProductService.deleteOrderProduct(id);
        return new ResponseEntity<>("OrderProduct is deleted successfully", HttpStatus.OK);
    }
}
