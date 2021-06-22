package com.example.demo_hql.repository;

import com.example.demo_hql.dto.UserDTO;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRepository extends JpaRepository<UserDTO, Long> {


    @Query("select user from UserDTO user")
    List<UserDTO> findAllUsers();

    @Query("select user from UserDTO user where user.username like :s%")
    List<UserDTO> findAllByNameContains(@Param("s") String s);

    @Query("select user from UserDTO user where user.id= :id")
     UserDTO findUserById(@Param("id") Long id);

    // UserDTO createUser(UserDTO userDTO);

    @Transactional
    @Modifying
    @Query("delete from UserDTO user where user.id= :id")
     Integer deleteUser(@Param("id") Long id);

//    @Query(value = "update UserDTO user set user.password=:newPassword where user.id=:id")
//     UserDTO updateUserPassword(Long id, String newPassword);

}
