package com.fpt.myweb.repository;

import com.fpt.myweb.entity.New;
import com.fpt.myweb.entity.Role;
import com.fpt.myweb.entity.User;
import com.fpt.myweb.entity.Village;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    public User findUsersByPhone(String phone);

    List<User> findAllByVillage(Village village);

    //findAllPatientForStaff
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = 'F0' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllPatientForStaff(Long village,String key,String search ,Pageable pageable);
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = 'F0' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllPatientForStaff(Long village,String key,String search );

    //searchTextForStaff
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = 'F0' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllTextForStaff(Long village ,String text,Pageable pageable);

    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = 'F0' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllTextForStaff(Long village ,String text);

    //searchTextWithRol
    @Query(value = "SELECT u FROM User u where role_id = ?1 and is_active = 1 and fullname like %?2% ORDER BY id desc ")
    List<User> findAllTextWithRole(Long role_id ,String text,Pageable pageable);

    @Query(value = "SELECT u FROM User u where role_id = ?1 and is_active = 1 and fullname like %?2% ORDER BY id desc ")
    List<User> findAllTextWithRole(Long role_id ,String text);

    //getAllPatientsCuredForStaff
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = '-' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllPatientsCuredForStaff(Long village,String key,String search ,Pageable pageable);

    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = '-' and fullname like %?2% ORDER BY id DESC ")
    List<User> findAllPatientsCuredForStaff(Long village,String key,String search );
    //searchAllPatientsCuredForStaff
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = '-' and fullname like %?2% ORDER BY id DESC ")
    List<User> searchAllPatientsCuredForStaff(Long village ,String text,Pageable pageable);

    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 4 and result = '-' and fullname like %?2% ORDER BY id DESC ")
    List<User> searchAllPatientsCuredForStaff(Long village ,String text);

    //notsentreport
    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and result = 'F0' and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> UserNotSentReport(String time,Long village,String text,String key,Pageable pageable);

    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and result = 'F0' and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> UserNotSentReport(String time,Long village,String text,String key);


    //notsentreport
    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and " +
            "result = 'F0'  and result = 'F0' and datediff((SELECT STR_TO_DATE(?4,'%d/%m/%Y')),u.created_date)>=0 and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> UserNotSentReports(String time,Long village,String key,String time1,Pageable pageable);

    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and result = 'F0'" +
            " and result = 'F0' and datediff((SELECT STR_TO_DATE(?4,'%d/%m/%Y')),u.created_date)>=0 and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> UserNotSentReports(String time,Long village,String key,String time1);


    //sentreport
    @Query( value = "SELECT * FROM user as u WHERE u.id    IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and result = 'F0'and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> userSentReport(String time,Long village,String text,String key,Pageable pageable);

    @Query( value = "SELECT * FROM user as u WHERE u.id    IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4 and is_active = 1 and village_id = ?2 and result = 'F0' and fullname like %?3% ORDER BY id DESC ", nativeQuery = true)
    List<User> userSentReport(String time,Long village,String text,String key);

    //getAllPatientForDoctor
    @Query(value = "SELECT u FROM User u where typeTakeCare = ?1 and fullname like %?2% and is_active = 1 and role_id = 4 and result = 'F0' ORDER BY id desc ")
    List<User> findAllPatientForDoctor(String doctor_id,String key,Pageable pageable);
    @Query(value = "SELECT u FROM User u where typeTakeCare = ?1 and fullname like %?2% and is_active = 1 and role_id = 4 and result = 'F0' ORDER BY id desc ")
    List<User> findAllPatientForDoctor(String doctor_id,String key);

    //getdoctorbyvillaId
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 3 ORDER BY id desc ")
    List<User> findAllDoctorbyvillaId(Long village,Pageable pageable);
    @Query(value = "SELECT u FROM User u where village_id = ?1 and is_active = 1 and role_id = 3 ORDER BY id desc ")
    List<User> findAllDoctorbyvillaId(Long village);

    List<User> findAllUserByRoleId(long roleId);

    @Query(value = "SELECT u FROM User u where role_id = ?1 and is_active = 1 and fullname like %?2% ORDER BY id desc ")
    List<User> findAllUserByRoleId( Long roleId,String text,Pageable pageable);

    @Query(value = "SELECT u FROM User u where role_id = ?1 and is_active = 1 and fullname like %?2% ORDER BY id desc ")
    List<User> findAllUserByRoleId( Long roleId,String text);


    @Query( value = "SELECT * FROM user as u WHERE (datediff((SELECT STR_TO_DATE(?1 ,'%d/%m/%Y')),u.date_start) = 14 or datediff((SELECT STR_TO_DATE(?3 ,'%d/%m/%Y')),u.date_start) = 21) and  is_active = 1 and role_id = 4 and village_id = ?2 and result = 'F0' ORDER BY id DESC ", nativeQuery = true)
    List<User> toTestCovidForPatient(String time,Long village,String timeTwo,Pageable pageable);

    List<User> findByRoleId(Long id);

    List<User> findByRole(Role role);

    List<User> findByUsernameContaining(String text, Pageable pageable);

    List<User> findByUsernameContaining(String text);

    User findByUsername(String username);

    @Query(value = "SELECT u FROM User u ORDER BY id desc ")
    List<User> findAllUserWithPagination(Pageable pageable);

    User findByPhone(String username);

    @Query(value = "SELECT u FROM User u where id like ?1 and phone like ?2  ORDER BY id")
    User findByPhoneLogout(Long id,String username);

    List<User> findByFullnameContaining(String text, Pageable pageable);

    List<User> findByFullnameContaining(String text);

    @Query( value = "SELECT * FROM user as u WHERE u.id   NOT IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4", nativeQuery = true)
    List<User> notSentReport(String time);

    @Query( value = "SELECT * FROM user as u WHERE u.id    IN (SELECT user_id FROM daily_report as d  WHERE date_time LIKE ?1) and u.role_id =4", nativeQuery = true)
    List<User> sentReport(String time);

    @Query(value = "SELECT count(*) FROM fcdc.user where village_id = ?1 and is_active = 1 and result like 'F0' and role_id =4",nativeQuery = true)
    int totalCurrentF0(Long villageId);


    @Query(value = "SELECT count(*) FROM fcdc.user where is_active = 1 and result like 'F0' and role_id = 4 and type_take_care like ?1",nativeQuery = true)
    int totalPatientForOneDoctor(String doctorId);
}
