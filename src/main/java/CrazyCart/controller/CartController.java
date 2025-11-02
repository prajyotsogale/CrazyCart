package CrazyCart.controller;

import CrazyCart.entity.CartItem;
import CrazyCart.entity.Products;
import CrazyCart.entity.Users;
import CrazyCart.service.CartItemService;
import CrazyCart.service.ProductService;
import CrazyCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@Controller
public class CartController {
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartController(CartItemService cartItemService, ProductService productService,
                          UserService userService){
        this.cartItemService = cartItemService;
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/cart")
    public String viewCart(Model model, Principal principal){
        String username = principal.getName();
        List<CartItem> cartItemList = cartItemService.getUserCart(username);

        BigDecimal subtotal = cartItemList.stream()
                .map(item -> item.getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal shipping = BigDecimal.valueOf(50.0);
        BigDecimal total = subtotal.add(shipping);

        model.addAttribute("subtotal", subtotal);
        model.addAttribute("total", total);
        model.addAttribute("cartItems", cartItemList);

        return "cart-page";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam("productId") int productId, Principal principal){
        Products product = productService.getProductById(productId);
        String username = principal.getName();
        Users user = userService.findByUsername(username);
        cartItemService.addToCart(username, product, user);

        return "redirect:";
    }

    @GetMapping("/increaseQuantity")
    public String increaseQuantity(@RequestParam("productId") int productId, Principal principal){
        Products product = productService.getProductById(productId);
        String username = principal.getName();
        Users user = userService.findByUsername(username);
        cartItemService.addToCart(username, product, user);

        return "redirect:/cart";
    }

    @GetMapping("/removeFromCart")
    public String removeFromCart(@RequestParam("productId") int productId){
        cartItemService.removeFromCart(productId);
        return "redirect:/cart";
    }

    @GetMapping("/decreaseQuantity")
    public String decreaseQuantity(@RequestParam("productId") int productId, Principal principal) {
        String username = principal.getName();
        cartItemService.decreaseQuantity(username, productId);
        return "redirect:/cart";
    }


}
