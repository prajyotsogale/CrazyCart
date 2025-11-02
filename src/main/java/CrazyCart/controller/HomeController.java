package CrazyCart.controller;

import CrazyCart.entity.Products;
import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;
import CrazyCart.service.ProductService;
import CrazyCart.service.ProfileService;
import CrazyCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
    private final UserService userService;
    private final ProfileService profileService;

    @Autowired
    public HomeController(ProductService productService, UserService userService,
                          ProfileService profileService){
        this.productService = productService;
        this.userService =userService;
        this.profileService = profileService;
    }


    @GetMapping("/")
    public String showPage(){
        return "redirect:/homepage";
    }

    @GetMapping("/homepage")
    public String homePage(Model model){

        List<Products> allList = productService.getAllProducts();

        // Limit to first 5 products
        List<Products> limitedProducts = allList.stream()
                .limit(15)
                .toList();

        model.addAttribute("products", limitedProducts);
        return "home-page";
    }

    @GetMapping("/category")
    public String categoryPage(Model model){
        List<Products> allList = productService.getAllProducts();
        model.addAttribute("products", allList);
        return "category-page";
    }

    @GetMapping("/products")
    public String showAllProducts(@RequestParam(value = "category" , required=false) String category,
                                  Model model){
        List<Products> products;
        if(category !=null && !category.isEmpty()){
            products = productService.findByCategory(category);
            model.addAttribute("products", products);
        }else{
            products = productService.getAllProducts();
            model.addAttribute("products", products);;
        }
        return "all-products";
    }

    @GetMapping("/profile")
    public String getProfile(Model model, Principal principal){
        Users users = userService.findByUsername(principal.getName());
        Profiles profile = profileService.getProfileByUser(users);
        model.addAttribute("profile", profile);

        return "profile-page";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@ModelAttribute("profile") Profiles profile, Principal principal){
        Users users = userService.findByUsername(principal.getName());
        System.out.println("got the user"+users);
        profile.setUsers(users);
        System.out.println("the details of profile is:"+profile);
        profileService.updateProfile(profile);
        return "redirect:/profile";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam("query") String query, Model model) {
        model.addAttribute("products", productService.search(query));
        model.addAttribute("query", query);
        return "all-products";
    }

}
