package org.albumshop.manager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
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


import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Commit
public class DeliveryTest {

    @Autowired
    DeliveryRepository deliRepo;

    @Autowired
    UserRepository userRepo;

    Pageable paging = PageRequest.of(0, 10, Sort.Direction.ASC, "id");

    //@Test
    public void insertDeliverytest() throws IllegalArgumentException {
        for(int i = 0; i < 10; i++) {
            long ii = i;
            User user = User.builder()
                .id("asdf1112" + i)
                .address("jeju" + i)
                .birth(LocalDate.of(1990, 1, 1).plusDays(ii))
                .gender("man")
                .grade("testgold")
                .email("aa@aa" + i)
                .pass("1111")
                .nickName("sunny" + i)
                .score(1)
                .phone("010-1111-1111" + i)
                .photo("photo")
                .name("sunnytest" + i)
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
    }

    //@Test
    public void findDeliveryByIdTest() {
        Optional<Delivery> result = deliRepo.findById(1l);
        result.ifPresent(object -> {
            System.out.println("size : " + object);
        });
    }

    //@Test
    public void findAllDeliveryTest() {
        Page<Delivery> result = deliRepo.findAll(paging);
        List<Delivery> list = result.getContent();

        list.forEach(delivery2 -> System.out.println(delivery2));
    }

    //@Test
    public void findDeliveriesByOrderStateTest(){
        Page<Delivery> result = deliRepo.findByOrderState("started", paging);
        List<Delivery> list = result.getContent();

        list.forEach(delivery2 -> System.out.println(delivery2));
    }

    //@Test
//    public void findDeliveriesByUserIdTest(){
//        Page<Delivery> result = deliRepo.findDeliveriesByUser("asdf1111", paging);
//        List<Delivery> list = result.getContent();
//
//        list.forEach(delivery2 -> System.out.println(delivery2));
//    }


//    @Transactional
//    @Test
//    public void updateOrderStateTest() {
//        LocalDate date = LocalDate.now();
//        Long id = 1l;
//        deliRepo.updateDelivery(id, date, "changed");
//    }

    //@Test
    public void update(){
        Optional<Delivery> deli = deliRepo.findById(1L);
        DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        deli.ifPresent(deliObject ->{
            LocalDateTime from_localDate = LocalDateTime.parse("2021-12-12 00:00:00",formatDateTime);
            deliObject.setDeliveryUpdateDate(Timestamp.valueOf(from_localDate));
            deliObject.setOrderState("changed");
            Delivery deliDone = deliRepo.save(deliObject);
            System.out.println("changedObject : " + deliDone);
        });
    }

    //@Transactional
    //@Test
    public void update2(){
        deliRepo.updateDelivery(11l, "changed");
    }

    //@Test
    public void selectAll(){
       deliRepo.findAll().forEach(deli -> System.out.println(deli));
    }

    @Test
    public void select(){
        System.out.println(deliRepo.findById(11l).get()); // Optional.get()
    }



}
