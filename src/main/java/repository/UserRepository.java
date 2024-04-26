package repository;

import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
//                                                 entity , data type
public interface UserRepository extends JpaRepository<User, Long> {

}
