package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepo;
    private int nextId = 1;
    private int balance = 500_000;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public void register(String name, String email) {
        if (name == null || name.isEmpty()) {
            throw new InvalidUserException("Nama tidak boleh kosong");
        }
        if (!email.contains("@")) {
            throw new InvalidUserException("Format email tidak valid");
        }

        for (User u : userRepo.findAll()) {
            if (u.getName().equals(name)) {
                throw new InvalidUserException("Username '" + name + "' sudah dipakai");
            }
        }

        User user = new User(nextId++, name, email, balance);
        userRepo.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepo.delete(id);
        System.out.println("✓ User id=" + id + " dihapus");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
