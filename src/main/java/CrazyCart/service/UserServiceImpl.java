package CrazyCart.service;

import CrazyCart.entity.Authorities;
import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;
import CrazyCart.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UsersRepository usersRepository;
    private final AuthorityService authorityService;
    private final PasswordEncoder passwordEncoder;
    private final ProfileService profileService;

    @Autowired
    public UserServiceImpl(UsersRepository usersRepository, AuthorityService authorityService,
                           PasswordEncoder passwordEncoder, ProfileService profileService){
        this.profileService = profileService;
        this.usersRepository = usersRepository;
        this.authorityService = authorityService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Users save(Users users) {
        System.out.println("inside the service");
        System.out.println("password is: " +users.getPassword());
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);
        System.out.println("Encoded password: "+encodedPassword);
        System.out.println("saving user with encoded password");
        Users newUser = usersRepository.save(users);
        Authorities authorities = new Authorities(users.getUsername(),"ROLE_EMPLOYEE");
        System.out.println("saving authorities");
        authorityService.save(authorities);
        Profiles profile = new Profiles();
        profile.setEmail(users.getEmail());
        profile.setUsers(users);
        System.out.println("saving profile");
        System.out.println("the user is: "+users);
        System.out.println("the profile is:" + profile);
        profileService.updateProfile(profile);
        return newUser;
    }

    @Override
    public Users findByUsername(String username) {
        return usersRepository.findByUsername(username);
    }
}
