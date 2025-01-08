package ie.atu.final_user;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")

public class UserController {

    private List<User> userList = new ArrayList<>();
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/create")
    public Map<String, Object> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
