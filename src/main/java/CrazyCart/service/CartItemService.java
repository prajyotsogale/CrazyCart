package CrazyCart.service;

import CrazyCart.entity.CartItem;
import CrazyCart.entity.Products;
import CrazyCart.entity.Users;

import java.util.List;

public interface CartItemService {
    void addToCart(String username, Products products, Users users);
    List<CartItem> getUserCart(String username);
    void removeFromCart(int id);
    void decreaseQuantity(String username, int productId);
}
