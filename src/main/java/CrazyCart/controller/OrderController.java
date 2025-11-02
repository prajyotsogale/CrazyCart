package CrazyCart.controller;

import CrazyCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String viewOrders(Model model, Principal principal) {
        String username = principal.getName();
        model.addAttribute("orders", orderService.getOrdersByUsername(username));
        return "orders"; // Thymeleaf page
    }

    @PostMapping("/placeOrder")
    public String placeOrder(Principal principal) {
        String username = principal.getName();
        orderService.placeOrder(username);
        return "redirect:/orders";
    }
}
