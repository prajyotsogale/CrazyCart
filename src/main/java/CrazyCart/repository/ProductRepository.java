package CrazyCart.repository;

import CrazyCart.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
    List<Products> findByCategoryIgnoreCase(String category);
    List<Products> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrCategoryContainingIgnoreCase(
            String name, String brand, String category);

}
