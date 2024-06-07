package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import static id.co.astratech.astra.constant.UserConstant.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = qGetLogin, nativeQuery = true)
    User findUserByEmailAndPassword(String username, String password);

}
