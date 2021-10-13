package com.endless.projects.stock.checker.dto.bestbuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.IOException;

public class BestBuyDtoTest {

    @Test
    public void parseAvailabiltiesJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        BestBuyDto bestBuyDto = objectMapper.readValue(new File("src/test/resources/availabilities-1.json"),BestBuyDto.class);

        Assert.assertEquals(24, bestBuyDto.getAvailabilities().length);

        Assert.assertEquals("ComingSoon", bestBuyDto.getAvailabilities()[0].getPickup().getStatus());
        Assert.assertTrue(bestBuyDto.getAvailabilities()[0].getPickup().isPurchasable());
        Assert.assertEquals("ComingSoon", bestBuyDto.getAvailabilities()[0].getShipping().getStatus());
        Assert.assertTrue(bestBuyDto.getAvailabilities()[0].getPickup().isPurchasable());
        Assert.assertEquals("15463567", bestBuyDto.getAvailabilities()[0].getSku());
        Assert.assertEquals("bbyca", bestBuyDto.getAvailabilities()[0].getSellerId());
        Assert.assertEquals("InStoreAndOnline", bestBuyDto.getAvailabilities()[0].getSaleChannelExclusivity());
        Assert.assertTrue(bestBuyDto.getAvailabilities()[0].getScheduledDelivery());
        Assert.assertTrue(bestBuyDto.getAvailabilities()[0].getIsGiftCard());
        Assert.assertTrue(bestBuyDto.getAvailabilities()[0].getIsService());

    }
}
