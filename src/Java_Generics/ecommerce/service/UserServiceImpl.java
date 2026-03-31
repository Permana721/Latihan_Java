package Java_Generics.ecommerce.service;

import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;
import Java_Generics.ecommerce.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepo;
    private int nextId = 1;
    private int balance = 0;

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
    public User login(String name, String email) {

        if (name == null || name.isEmpty() || email == null || email.isEmpty()) {
            throw new InvalidUserException("Nama dan email tidak boleh kosong");
        }
        if (!email.contains("@")) {
            throw new InvalidUserException("Format email tidak valid");
        }

        for (User user : userRepo.findAll()) {
            if (user.getName().equalsIgnoreCase(name) && user.getEmail().equals(email)) {
                System.out.println("✓ Login berhasil! Selamat datang, " + user.getName());
                return user;
            }
        }

        throw new InvalidUserException("Nama atau email salah");
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

    @Override
    public void tambahSaldo(int userId, int jumlah) {
        User user = userRepo.findUserById(userId);

        user.setSaldo(user.getSaldo() + jumlah);
        System.out.println("Saldo berhasil ditambah: Rp." + jumlah + "\nSaldo sekarang: Rp." + user.getSaldo() + "\n");
    }

}
