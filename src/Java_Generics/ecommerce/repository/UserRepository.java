package Java_Generics.ecommerce.repository;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;
import Java_Generics.ecommerce.exception.InvalidUserException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository implements Repository<User> {
    private ArrayList<User> allUser = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void save(User item) {
        item.setId(nextId++);
        allUser.add(item);
    }

    @Override
    public void delete(int id) {
        allUser.removeIf(p -> p.getId() == id);
    }


    public Product findProductByName(String name) {
        return null;
    }

    @Override
    public User findUserById(int id) throws InvalidUserException {
        if (id <= 0) {
            throw new InvalidUserException("Id tidak valid: " + id);
        }

        if (allUser == null || allUser.isEmpty()) {
            throw new InvalidUserException("Belum ada user yang terdaftar");
        }

        for (User user : allUser) {
            if (user.getId() == id) {
                return user;
            }
        }

        throw new InvalidUserException("User dengan id=" + id + " tidak ada");
    }


    @Override
    public List<User> findAll() {
        return allUser;
    }
}
