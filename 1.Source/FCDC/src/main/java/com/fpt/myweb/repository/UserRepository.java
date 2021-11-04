package com.fpt.myweb.repository;

import com.fpt.myweb.entity.Role;
import com.fpt.myweb.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUsersByPhone(String phone);



    List<User> findAllUserByRoleId(long roleId);

    List<User> findByRole(Role role);

    List<User> findByUsernameContaining(String text, Pageable pageable);

    List<User> findByUsernameContaining(String text);

    User findByUsername(String username);

    User findByPhone(String username);

    List<User> findByFullnameContaining(String text, Pageable pageable);

    List<User> findByFullnameContaining(String text);

    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4", nativeQuery = true)
    List<User> notSentReport(String time);

}
