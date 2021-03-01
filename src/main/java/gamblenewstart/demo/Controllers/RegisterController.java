package gamblenewstart.demo.Controllers;


import gamblenewstart.demo.Entities.RegisterRequest;
import gamblenewstart.demo.Entities.User;
import gamblenewstart.demo.Exceptions.UsernameIsBeingAlreadyUsedException;
import gamblenewstart.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RegisterController(UserRepository userRepo, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepo = userRepo;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public User saveNewUser(@RequestBody RegisterRequest newUser){
        if(userRepo.findByLogin(newUser.getUsername()) != null)
            throw new UsernameIsBeingAlreadyUsedException("Username is already being used - " + newUser.getUsername());

        User user = new User();
        user.setLogin(newUser.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        user.setBalance(30000);
        userRepo.save(user);
        return user;
    }
}
