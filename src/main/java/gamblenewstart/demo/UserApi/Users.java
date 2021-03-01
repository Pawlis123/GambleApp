package gamblenewstart.demo.UserApi;

import gamblenewstart.demo.Entities.User;
import gamblenewstart.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
@RestController
public class Users {

    private final UserRepository userRepository;

    @Autowired
    public Users(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userRepository.findByLogin(username);
    }

}
