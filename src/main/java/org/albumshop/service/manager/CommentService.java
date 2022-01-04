package org.albumshop.service.manager;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;
import org.albumshop.domain.Delivery;
import org.albumshop.domain.User;
import org.albumshop.persistence.DeliveryRepository;
import org.albumshop.persistence.ReviewReplyRepository;
import org.albumshop.persistence.ReviewRepository;
import org.albumshop.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    ReviewReplyRepository reviewReplyRepository;

}
