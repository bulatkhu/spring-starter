package startproject.demo.repository;

import org.springframework.data.repository.CrudRepository;
import startproject.demo.entity.UserEntity;

public interface UserRepo extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
