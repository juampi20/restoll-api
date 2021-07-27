package github.juampi20.wineshop.repository;

import github.juampi20.wineshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}