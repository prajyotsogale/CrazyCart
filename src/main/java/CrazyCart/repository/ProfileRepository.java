package CrazyCart.repository;

import CrazyCart.entity.Profiles;
import CrazyCart.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profiles, Long> {
    Profiles findByUsers(Users users);
}
