package Service;

import Model.User;
import Repository.UserRepository;
import Repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepositoryImpl();
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(int id, User user) {
        userRepository.update(id,user);
    }

    @Override
    public void remove(int id) {
        userRepository.remove(id);
    }

    @Override
    public User findByID(int id) {
      return   userRepository.findByID(id);
    }
}
