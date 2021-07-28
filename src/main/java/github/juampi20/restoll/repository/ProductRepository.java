package github.juampi20.restoll.repository;

import github.juampi20.restoll.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}