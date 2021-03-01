package gamblenewstart.demo.Controllers;


import gamblenewstart.demo.Entities.LoginRequest;
import gamblenewstart.demo.Entities.LoginResponse;
import gamblenewstart.demo.Entities.User;
import gamblenewstart.demo.Repository.MyUserDetails;
import gamblenewstart.demo.Repository.UserRepository;
import gamblenewstart.demo.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/authenticate")
public class LoginController {

    private final MyUserDetails myUserDetails;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtTokenUtil;

    @Autowired
    public LoginController(MyUserDetails myUserDetails, AuthenticationManager authenticationManager, JwtUtil jwtTokenUtil) {
        this.myUserDetails = myUserDetails;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception{
        try{
            authenticationManager // muis być tworzony ten token
                    .authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getLogin(),authenticationRequest.getPassword()));
        } catch(BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails = myUserDetails
                .loadUserByUsername(authenticationRequest.getLogin());
        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new LoginResponse(jwt));
    }
}
