package CrazyCart.controller;

import CrazyCart.entity.Users;
import CrazyCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage(){
        return "login-page";
    }

    @GetMapping("/showMyRegistrationPage")
    public String showMyRegistrationPage(Model model){
        Users users = new Users();
        model.addAttribute("users",users);
        return "registration-page";
    }
    @PostMapping("/registerTheUser")
    public String registerTheUser(@ModelAttribute("users") Users newUser,
                                  @RequestParam("confirmPassword") String confirmPassword){
        System.out.println("password: "+newUser.getPassword());
        System.out.println("Confirmpassword: "+confirmPassword);

        if(!newUser.getPassword().equals(confirmPassword)){
            System.out.println("password do not match");
            return "redirect:/showMyRegistrationPage?error=password_mismatch";
        }
        System.out.println("saving the user"+newUser);
        userService.save(newUser);
        System.out.println("done");
        return "redirect:/showMyLoginPage";
    }
}
