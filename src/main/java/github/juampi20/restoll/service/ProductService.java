package github.juampi20.wineshop.service;

import github.juampi20.wineshop.entity.Product;
import github.juampi20.wineshop.entity.Product;
import github.juampi20.wineshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseGet(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product update(Product newProduct, Long id) {
        return productRepository.findById(id)
                .map(product -> {
                    product.setPrice(newProduct.getPrice());
                    product.setType(newProduct.getType());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return productRepository.save(newProduct);
                });
    }

}
