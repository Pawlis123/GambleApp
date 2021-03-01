package gamblenewstart.demo.Repository;


import gamblenewstart.demo.Entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String username);
    //User findByPassword(String password);
}
