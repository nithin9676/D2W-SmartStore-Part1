package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.LoginRequestDTO;
import com.DTO.LoginResponseDTO;
import com.DTO.UserRequestDTO;
import com.Entity.Store;
import com.Entity.User;
import com.Repostory.StoreRepository;

import com.Repostory.User_Repository;

@Service
public class UserService {

    @Autowired
    private User_Repository userRepository;

    @Autowired
    private StoreRepository storeRepository;



    public String createUser(UserRequestDTO requestDTO) {


        boolean emailExists =userRepository.findByEmail(requestDTO.getEmail()).isPresent();

        if(emailExists)
        {
            return "Email Already Exists";
        }


        Store store = null;

        if(requestDTO.getStoreId() != null)
        {

            store = storeRepository.findById(requestDTO.getStoreId()).orElseThrow(() ->
                        new RuntimeException( "Store Not Found" ) );
        }



        User user =
            new User();

        user.setName(
            requestDTO.getName()
        );

        user.setEmail(
            requestDTO.getEmail()
        );

        user.setPhone(
            requestDTO.getPhone()
        );

        user.setPassword(
            requestDTO.getPassword()
        );

        user.setRole(
            requestDTO.getRole()
        );

        user.setStore(store);

        user.setIsActive(true);

        userRepository.save(user);

        return "User Created Successfully";
    }



    public List<User> getAllUsers() {

        return userRepository.findAll();
    }



    public LoginResponseDTO login(LoginRequestDTO requestDTO) {



        if(requestDTO.getEmail() == null || requestDTO.getEmail().trim().isEmpty())
        {
            throw new RuntimeException( "Email Is Required" );
        }

   

        if(requestDTO.getPassword() == null
                ||
           requestDTO.getPassword().trim().isEmpty())
        {
            throw new RuntimeException(
                "Password Is Required"
            );
        }

    

        User user =
            userRepository
                .findByEmail(requestDTO.getEmail())
                .orElseThrow(() ->
                    new RuntimeException(
                        "Invalid Email"
                    )
                );


        if(!user.getIsActive())
        {
            throw new RuntimeException(
                "User Account Disabled"
            );
        }

       

        if(!user.getPassword().equals(requestDTO.getPassword()))
        {
            throw new RuntimeException(
                "Invalid Password"
            );
        }

      

        LoginResponseDTO responseDTO =
            new LoginResponseDTO();

        responseDTO.setUserId(
            user.getId()
        );

        responseDTO.setName(
            user.getName()
        );

        responseDTO.setEmail(
            user.getEmail()
        );

        responseDTO.setRole(
            user.getRole().name()
        );

       

        if(user.getStore() != null)
        {

            responseDTO.setStoreId(
                user.getStore().getId()
            );

            responseDTO.setStoreName(
                user.getStore().getStoreName()
            );
        }

        return responseDTO;
    }
}