package org.bsim.intern.walletsapp_demo.io.irepository;

import org.bsim.intern.walletsapp_demo.io.entity.UserEntity;
import org.bsim.intern.walletsapp_demo.io.entity.WalletsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WalletsRepository extends JpaRepository<WalletsEntity, Long> {
    List<WalletsEntity> findAllByUser(UserEntity userEntity);
    WalletsEntity findByWalletid(String walletid);
}
