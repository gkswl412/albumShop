package org.albumshop.manager;

import lombok.experimental.StandardException;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class DeliveryTest {

    @Autowired
    DeliveryRepository deliRepo;

    @Autowired
    UserRepository userRepo;

    //@Test
    public void insertDeliverytest() {

        User user = User.builder()
                .id("asdf1111")
                .address("jeju")
                .birth(LocalDate.of(1990, 1, 1))
                .gender("man")
                .grade("testgold")
                .email("aa@aa")
                .pass("1111")
                .nickName("sunny")
                .score(1)
                .phone("010-1111-1111")
                .photo("photo")
                .name("sunnytest")
                .build();
        userRepo.save(user);

        Delivery delivery = Delivery.builder()
                .id(1111L)
                .destinationAddress("TestAddress")
                .deliveryRegDate(Timestamp.from(Instant.now()))
                .deliveryRequest("test")
                .deliveryUpdateDate(Timestamp.from(Instant.now()))
                .orderState("delivered")
                .user(user)
                .build();

        deliRepo.save(delivery);
    }

    //@Test
    public void findDeliveryTest() {
        Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "id");
        Page<Delivery> result = deliRepo.findDeliveryById(1l, paging);
        System.out.println("size : " + result.getSize());
        System.out.println("total pages : " + result.getTotalPages());
        List<Delivery> list = result.getContent();

        list.forEach(delivery2 -> System.out.println(delivery2));

    }

    @Test
    public void updateOrderStateTest() {
        deliRepo.updateOrderState(1, "started");
    }
}
