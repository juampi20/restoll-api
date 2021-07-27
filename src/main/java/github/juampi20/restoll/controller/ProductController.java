package github.juampi20.wineshop.controller;

import github.juampi20.wineshop.entity.Product;
import github.juampi20.wineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        Product product = productService.findById(id);

        if (product == null) {
            throw new RuntimeException("Product not found:" + id);
        }

        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product newProduct) {
        return productService.update(newProduct, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
