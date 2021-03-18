package Service;

import Model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    void save(User user);

    void update(int id, User user);

    void remove(int id);

    User findByID(int id);

}
