package org.bsim.intern.walletsapp_demo.service.impl;

import org.bsim.intern.walletsapp_demo.io.entity.UserEntity;
import org.bsim.intern.walletsapp_demo.io.entity.WalletsEntity;
import org.bsim.intern.walletsapp_demo.io.irepository.UserRepository;
import org.bsim.intern.walletsapp_demo.io.irepository.WalletsRepository;
import org.bsim.intern.walletsapp_demo.service.iservice.IWalletsService;
import org.bsim.intern.walletsapp_demo.shared.dto.UserDTO;
import org.bsim.intern.walletsapp_demo.shared.dto.WalletsDTO;
import org.bsim.intern.walletsapp_demo.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalletServiceImpl implements IWalletsService {
    @Autowired
    WalletsRepository walletsRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<WalletsDTO> getAllWalletsData(String userid) {
        List<WalletsEntity> walletsData = walletsRepository.findAllByUser(userRepository.findByUserid(userid));
        return new ModelMapper().map(walletsData, new TypeToken<List<WalletsDTO>>(){}.getType());
    }

    @Override
    public long getTotalBalance(String userid) {
        List<WalletsEntity> walletsData = walletsRepository.findAllByUser(userRepository.findByUserid(userid));
        if (walletsData == null)
            return 0L;
        long totalBalance = 0;
        for (WalletsEntity walletsEntity:walletsData){
            totalBalance += walletsEntity.getBalance();
        }
        return totalBalance;
    }

    @Override
    public WalletsDTO addNewWalletData(String userid, WalletsDTO walletsDTO) {

        ModelMapper mapper = new ModelMapper();

        //Generate WalletId
        walletsDTO.setWalletId(generateRandomPublicId.generateUserId(30));
        //Get User
        UserEntity userData = userRepository.findByUserid(userid);
        //Set User
        walletsDTO.setUser(mapper.map(userData, UserDTO.class));
        // LENGKAPIN
        WalletsEntity entity = mapper.map(walletsDTO, WalletsEntity.class);

        //Save data to database (table : walletstbl)
        WalletsEntity storedData = walletsRepository.save(entity);

        return mapper.map(storedData, WalletsDTO.class);
    }

    @Override
    public WalletsDTO updateWalletData(String userid, String walletid, WalletsDTO walletsDTO) {
        WalletsEntity walletData = walletsRepository.findByWalletid(walletid);
        if (walletData == null)
            return null;
        // update nohp (or) balance
        walletData.setNohp(walletsDTO.getNoHP());
        walletData.setBalance(walletsDTO.getBalance());

        WalletsEntity updateData = walletsRepository.save(walletData);
        return new ModelMapper().map(updateData, WalletsDTO.class);
    }
}
