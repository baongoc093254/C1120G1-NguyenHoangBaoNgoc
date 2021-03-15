package Repository;

import Model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    void  save(User user);

    User findByID(int id);

    void update(int id, User user);

    void  remove(int id);
}
