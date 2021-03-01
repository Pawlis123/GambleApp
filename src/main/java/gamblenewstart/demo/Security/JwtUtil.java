package gamblenewstart.demo.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtUtil {

    private final String SECRET_KEY= "1C7518BACDC421EFD64DB246FCE47s8A528C34126E466D58C9C74931F8D";

    //meotdy korzystające z  extract claims
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
    }


    //metoda do wyciąganie claims z tokenu
    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    // pobieramy username z bazy użtykowników
    // towrzymy psutą mape claims żeby użyć metody createToken
    // to nie musi być pusta mapa, ustawiamy ją w zależności od potrzeb,  KONEICZNIE DOCZYTAC
    public String generateToken(UserDetails userDetails){
        Map<String,Object> claims = new HashMap<>();
        return createToken(claims,userDetails.getUsername());
    }

    //Ta metoda wywołuje API JWT
    // ustawiamy konieczne, rzeczy, ustawiamy zawartosc claims w tokenie, subject ktorego dotyczy  token, date wygasniecia
    // podpisujemy token syganturą, która weryfikuje czy wiadomość z tokena nie zostala zmieniona w drodze do odbiorcy, może również wyeryfkować czy użtykonwik jest tym za którego się podaje
    //compact zwraca juz ostatewczny token
    public String createToken(Map<String,Object> claims, String subject){
        return Jwts
                .builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY).compact();
    }

    //metoda zbędna, bo extractclaims już robi to co ta metoda ma zrobić
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return(username.equals(userDetails.getUsername())&& !isTokenExpired(token));
    }
}
