package fv.monster.repository;

import fv.monster.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fvsaddam - fvmonster.corp@gmail.com
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findOneByEmail(String email);

    User findOneByActivationHash(String activationHash);
}
