package gamblenewstart.demo.UserService;

import gamblenewstart.demo.Entities.User;
import gamblenewstart.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FundsController {

    private final UserRepository userRepository;

    @Autowired
    public FundsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void fundUpdater(long bet, long prize, User user) {
        if(prize>0)
            user.setBalance(user.getBalance() + (prize- bet));
        else
            user.setBalance(user.getBalance() - bet);

        userRepository.save(user);

    }
}
