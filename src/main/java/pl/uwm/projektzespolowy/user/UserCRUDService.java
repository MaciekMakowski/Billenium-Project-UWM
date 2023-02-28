package pl.uwm.projektzespolowy.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserCRUDService {

    private final UserCreator userCreator;
    private final UserReader userReader;
    private final UserUpdater userUpdater;
    private final UserDeleter userDeleter;

    public User createUser(User user) {
        return userCreator.createUser(user);
    }

    public List<User> getAllUsers() {
        return userReader.getAllUsers();
    }

    public User getUserById(Long id) {
        return userReader.getUserById(id);
    }

    public void deleteUser(Long id) {
        userDeleter.deleteUserById(id);
    }

}