package gamblenewstart.demo.GamesAPI;



import gamblenewstart.demo.Entities.SlotsRequest;
import gamblenewstart.demo.Entities.SlotsResponse;
import gamblenewstart.demo.Entities.User;
import gamblenewstart.demo.Exceptions.NegativeBetValueException;
import gamblenewstart.demo.Exceptions.NotEnoughFunds;
import gamblenewstart.demo.Repository.UserRepository;
import gamblenewstart.demo.Security.JwtUtil;
import gamblenewstart.demo.SlotsGame.SlotsResultGenerator;
import gamblenewstart.demo.UserService.FundsController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slots/play")
public class SlotsService {

    private final SlotsResultGenerator slotsResultGenerator;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final FundsController fundsController;

    @Autowired
    public SlotsService(SlotsResultGenerator slotsResultGenerator, JwtUtil jwtUtil, UserRepository userRepository, FundsController fundsController) {
        this.slotsResultGenerator = slotsResultGenerator;
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
        this.fundsController = fundsController;
    }

    @PostMapping
    public SlotsResponse play(@RequestBody SlotsRequest request, @RequestHeader(value="Authorization") String jwt){
        if(request.getBet()<=0)
            throw new NegativeBetValueException("The value of bet cannot be lower than 0: " + request.getBet());

        String extractedJwt = jwt.substring(7);
        String username = jwtUtil.extractUsername(extractedJwt);

        User user = userRepository.findByLogin(username);
        if(user.getBalance() < request.getBet())
            throw new NotEnoughFunds("Your funds are to low to make a bet: " + user.getBalance() + " Bet: " + request.getBet());


        SlotsResponse gameResult = slotsResultGenerator.gameResult(request.getBet(), request.getSlotsType());
        fundsController.fundUpdater(request.getBet(), gameResult.getPrize(), user);


        return gameResult;
    }
}
