package id.co.astratech.astra.repository;

import id.co.astratech.astra.model.User;
import id.co.astratech.astra.vo.LoginVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import static id.co.astratech.astra.constant.UserConstant.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = qGetLogin, nativeQuery = true)
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query(value = qGetEmailUser, nativeQuery = true)
    String getExistingEmail(@Param("email") String email);

    @Query(value = qGetUserByEmail, nativeQuery = true)
    User findUserByEmail(@Param("email") String email);

    @Query(value = qGetUserByPassword, nativeQuery = true)
    User findUserByPassword(@Param("password") String password);

}
