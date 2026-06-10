package com.Repostory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.User;
import com.enumclasses.Role;


@Repository
public interface User_Repository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
     Optional<User> findById(Long id);

    Optional<User> findByRole(Role role);
   List<User> findByStore_IdIn(List<Long> storeIds);
   
  

}