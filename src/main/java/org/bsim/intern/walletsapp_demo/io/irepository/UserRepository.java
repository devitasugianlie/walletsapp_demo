package org.bsim.intern.walletsapp_demo.io.irepository;

import org.bsim.intern.walletsapp_demo.io.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
    UserEntity findByUserid(String userid);
}
