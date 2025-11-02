package CrazyCart.service;

import CrazyCart.entity.Products;

import java.util.List;

public interface ProductService {
    List<Products> getAllProducts();
    List<Products> findByCategory(String category);
    public List<Products> search(String query);
    Products getProductById(int id);
}
