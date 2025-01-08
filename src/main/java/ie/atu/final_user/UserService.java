package ie.atu.final_user;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
@Service
public class UserService {
    private UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public Map<String, Object> createUser(User user) {
        User savedUser = userRepo.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "User successfully created");
        response.put("userId", savedUser.getId());
        return response;
    }


    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);
        user.setUsername(updatedUser.getUsername());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        return userRepo.save(user);
    }

    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }
}