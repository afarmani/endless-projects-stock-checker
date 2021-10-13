package com.endless.projects.stock.checker.dto.bestbuy;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Availabilities {

    private Pickup pickup;
    private Shipping shipping;
    private String sku;
    private String sellerId;
    private String saleChannelExclusivity;
    private Boolean scheduledDelivery;
    private Boolean isGiftCard;
    private Boolean isService;

}
