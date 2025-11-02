package CrazyCart.service;

import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;


public interface ProfileService {
    Profiles getProfileByUser(Users users);
    Profiles updateProfile(Profiles profile);
}
