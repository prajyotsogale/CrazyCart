package CrazyCart.service;

import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;
import CrazyCart.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository){
        this.profileRepository = profileRepository;
    }

    @Override
    public Profiles getProfileByUser(Users users) {
        return profileRepository.findByUsers(users);
    }

    @Override
    public Profiles updateProfile(Profiles profile) {
        return profileRepository.save(profile);
    }
}
