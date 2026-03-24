package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.user.User;

import java.util.List;

public interface UserService {
    void register(String name, String email);
    void deleteUser(int id);
    List<User> getAllUsers();
}
