package CrazyCart.service;

import CrazyCart.entity.Products;
import CrazyCart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Products> findByCategory(String category) {
        return productRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<Products> search(String query) {
        if (query == null || query.isEmpty()) {
            return productRepository.findAll();
        }
        return productRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrCategoryContainingIgnoreCase(
                query, query, query);
    }

    @Override
    public Products getProductById(int id) {
        Optional<Products> theProduct = productRepository.findById(id);
        if(theProduct.isEmpty()){
            throw new RuntimeException("No product exists of id: "+id);
        }
        return theProduct.get();
    }

}
