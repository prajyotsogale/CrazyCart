package CrazyCart.controller;

import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;
import CrazyCart.service.ProfileService;
import CrazyCart.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

@ControllerAdvice
public class GlobalController {
    private final UserService userService;
    private final ProfileService profileService;

    public GlobalController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @ModelAttribute
    public void addProfileToModel(Model model, Principal principal) {
        if (principal != null) {
            Users user = userService.findByUsername(principal.getName());
            if (user != null) {
                Profiles profile = profileService.getProfileByUser(user);
                model.addAttribute("theUserProfile", profile);
            }
        }
    }
}
