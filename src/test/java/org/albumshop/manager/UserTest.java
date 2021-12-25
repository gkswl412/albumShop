package org.albumshop.manager;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.albumshop.domain.User;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;

@SpringBootTest
@Commit
public class UserTest {

    @Autowired
    UserRepository userRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "id");

    //@Test
    public void UserInsertTest() {
        for (int i = 0; i < 20; i++) {
            long ii = i;
            User user = User.builder()
                .id("userTestId" + i)
                .address("userTestAddress" + i)
                .birth(LocalDate.of(1990, 1, 1).plusDays(ii))
                .gender("man")
                .grade("userTestgrade")
                .email("aa@test.com" + i)
                .pass("1111")
                .nickName("userInsertTest" + i)
                .score(1)
                .phone("010-test-1111" + i)
                .photo("photo")
                .name("userTestName" + i)
                .build();
            userRepo.save(user);
        }
    }
    @Test
    public void userFindAllTest(){
        Page<User> allUsers = userRepo.findAll(paging);
        List<User> allUsersList = allUsers.getContent();
        allUsersList.forEach(u -> System.out.println(u));
    }
    //@Test
    public void userFindByIdTest(){
        Optional<User> optionalUser = userRepo.findById("userTestId0");
        optionalUser.ifPresent(u-> {
            System.out.println(u);
        });
    }
    @Test
    public void userDeleteByIdTest(){
        String[] x = {"zzzz", "xxxx", "vvvvv"};
        for (String string : x) {
            userRepo.deleteById(string);
        }
        userRepo.deleteById("userTestId0");
        Optional<User> optionalUser = userRepo.findById("userTestId0");
        optionalUser.ifPresent(u-> {
            System.out.println(u);
        });
    }
}
