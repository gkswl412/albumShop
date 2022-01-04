/*
 * package org.albumshop;
 * 
 * import static org.assertj.core.api.Assertions.assertThat;
 * 
 * import java.time.LocalDate;
 * 
 * import org.albumshop.controller.UserInfoController; import
 * org.albumshop.domain.User; import org.albumshop.persistence.UserRepository;
 * import org.albumshop.service.UserDetailService; import
 * org.junit.jupiter.api.AfterEach; import org.junit.jupiter.api.BeforeEach;
 * import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * @SpringBootTest public class UserDetailTest {
 * 
 * String id = "park"; String name = " park"; String nickName = "park"; String
 * pass = "1234"; String address = "경기도"; String email = "25@naver.com"; String
 * phone = "01099184859"; String photo = "aadd"; String grade = "Gold"; Integer
 * score = 100; LocalDate birth = LocalDate.now(); String gender = "남자";
 * 
 * @Autowired UserInfoController userInfoController;
 * 
 * @Autowired UserRepository userRepository;
 * 
 * @Autowired UserDetailService userDetailService;
 * 
 * @BeforeEach public void userSave() {
 * 
 * User user =
 * User.builder().id(id).name(name).nickName(nickName).pass(pass).address(
 * address).email(email)
 * .phone(phone).photo(photo).grade(grade).score(score).birth(birth).gender(
 * gender).build();
 * 
 * userRepository.save(user); }
 * 
 * @AfterEach public void deleteUser() { userRepository.deleteById("park"); }
 * 
 * // @Test // public void userDetailTest() { // // User user =
 * userDetailService.findByUserId(id); //
 * assertThat(user.getEmail()).isEqualTo(email); // }
 * 
 * }
 */