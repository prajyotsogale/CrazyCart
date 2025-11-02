package CrazyCart.service;

import CrazyCart.entity.CartItem;
import CrazyCart.entity.OrderItem;
import CrazyCart.entity.Orders;
import CrazyCart.entity.Users;
import CrazyCart.repository.CartRepository;
import CrazyCart.repository.OrderItemRepository;
import CrazyCart.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Override
    public void placeOrder(String username) {
        Users user = userService.findByUsername(username);
        List<CartItem> cartItems = cartRepository.findByUsers_Username(username);

        if (cartItems.isEmpty()) return;

        Orders order = new Orders();
        order.setUsers(user);
        Date date = new Date();
        order.setOrderDate(LocalDateTime.now());

        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : cartItems) {
            total = total.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
        }
        order.setTotal(total);
        orderRepository.save(order);

        for (CartItem item : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(item.getProduct());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setPrice(item.getProduct().getPrice());
            orderItemRepository.save(orderItem);
        }

        cartRepository.deleteAll(cartItems);
    }

    @Override
    public List<Orders> getOrdersByUsername(String username) {
        return orderRepository.findByUsers_Username(username);
    }
}