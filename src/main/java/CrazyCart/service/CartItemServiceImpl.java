package CrazyCart.service;

import CrazyCart.entity.CartItem;
import CrazyCart.entity.Products;
import CrazyCart.entity.Users;
import CrazyCart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService{

    private final CartRepository cartRepository;

    @Autowired
    public CartItemServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public void addToCart(String username, Products products, Users users) {
        Optional<CartItem> existing = cartRepository.findByUsers_UsernameAndProductId(username, products.getId());
        if(existing.isPresent()){
            CartItem item = existing.get();
            item.setQuantity(item.getQuantity()+1);
            cartRepository.save(item);
        }else{
            CartItem newItem = new CartItem();
            newItem.setUsers(users);
            newItem.setProduct(products);
            newItem.setQuantity(1);
            cartRepository.save(newItem);
        }
    }

    @Override
    public List<CartItem> getUserCart(String username) {
        return cartRepository.findByUsers_Username(username);
    }

    @Override
    public void removeFromCart(int id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void decreaseQuantity(String username, int productId) {
        Optional<CartItem> existing = cartRepository.findByUsers_UsernameAndProductId(username, productId);

        if (existing.isPresent()) {
            CartItem item = existing.get();
            if (item.getQuantity() > 1) {
                item.setQuantity(item.getQuantity() - 1);
                cartRepository.save(item);
            } else {
                cartRepository.delete(item);
            }
        }
    }

}
