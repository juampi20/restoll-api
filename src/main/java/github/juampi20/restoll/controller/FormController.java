package github.juampi20.restoll.controller;

import github.juampi20.restoll.entity.OrderProduct;
import github.juampi20.restoll.service.OrderProductService;
import github.juampi20.restoll.service.OrderService;
import github.juampi20.restoll.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api")
public class FormController {
    @Autowired
    OrderService orderService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderProductService orderProductService;

    @GetMapping("/addProduct")
    public String sendForm(ModelMap model) {
        model.addAttribute("orderProduct", new OrderProduct());
        model.addAttribute("orderList", orderService.getAllOrders());
        model.addAttribute("productList", productService.getAllProducts());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String processForm(@ModelAttribute OrderProduct orderProduct, ModelMap model) {
        orderProduct.getOrder().updateTotalOrderPrice();
        orderProductService.save(orderProduct);
        model.addAttribute("orderProduct", orderProduct);
        return "showMessage";
    }
}
