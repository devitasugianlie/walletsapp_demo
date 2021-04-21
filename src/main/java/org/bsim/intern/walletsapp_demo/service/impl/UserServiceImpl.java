package org.bsim.intern.walletsapp_demo.service.impl;

import org.bsim.intern.walletsapp_demo.io.entity.UserEntity;
import org.bsim.intern.walletsapp_demo.io.irepository.UserRepository;
import org.bsim.intern.walletsapp_demo.service.iservice.IUserInterface;
import org.bsim.intern.walletsapp_demo.shared.dto.UserDTO;
import org.bsim.intern.walletsapp_demo.shared.utils.GenerateRandomPublicId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserInterface {
    @Autowired
    UserRepository userRepository;
    @Autowired
    GenerateRandomPublicId generateRandomPublicId;

    @Override
    public List<UserDTO> getListUser() {
        List<UserDTO> value = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        // Get all users from database
        List<UserEntity> users = userRepository.findAll();
        // List<UserEntity> --> List<UserDTO>
        for(UserEntity userEntity : users){
            value.add(mapper.map(userEntity, UserDTO.class));
        }
        return value;
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        UserEntity getUser = userRepository.findByUsername(username);
        if(getUser == null)
            return null;

        return new ModelMapper().map(getUser, UserDTO.class);
    }

    @Override
    public UserDTO addNewData(UserDTO user) {
        user.setUserId(generateRandomPublicId.generateUserId(30)); //generate user id
        ModelMapper mapper = new ModelMapper();

        // User DTO --> UserEntity
        UserEntity entity = mapper.map(user, UserEntity.class);
        UserEntity storedData = userRepository.save(entity);

        //UserEntity --> UserDTO (return value)
        UserDTO value = mapper.map(storedData, UserDTO.class);

        return value;
    }
}


