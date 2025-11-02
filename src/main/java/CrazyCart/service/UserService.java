package CrazyCart.service;

import CrazyCart.entity.Users;

public interface UserService {
    Users save(Users users);
    Users findByUsername(String username);
}
