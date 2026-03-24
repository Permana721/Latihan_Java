package Java_Generics.ecommerce.repository;
import Java_Generics.ecommerce.domain.product.Product;
import Java_Generics.ecommerce.domain.user.User;

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

    @Override
    public Product findByName(String name) {

        return null;
    }

    @Override
    public List<User> findAll() {
        return allUser;
    }
}
