package CrazyCart.service;

import CrazyCart.entity.Authorities;
import CrazyCart.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl implements AuthorityService{

    private final AuthoritiesRepository authoritiesRepository;

    @Autowired
    public AuthorityServiceImpl(AuthoritiesRepository authoritiesRepository){
        this.authoritiesRepository = authoritiesRepository;
    }

    @Override
    public Authorities save(Authorities authorities) {
        return authoritiesRepository.save(authorities);
    }
}
