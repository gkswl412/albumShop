package org.albumshop.vo;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDetailVO {
    private Long deliveryId;
    private String userId;
    private String orderState;
    private String destinationAddress;
    private Timestamp deliveryRegDate;
    private Timestamp deliverUpdateDate;
    private String deliveryRequest;
    private Long albumId;
    private int orderAmount;
    private String albumTitle;
}
