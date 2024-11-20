package com.dsorder.desafio.services;

import com.dsorder.desafio.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    private static final double BASIC_THRESHOLD_LOW = 100.00;
    private static final double BASIC_THRESHOLD_HIGH = 200.00;
    private static final double SHIPPING_COST_LOW = 20.00;
    private static final double SHIPPING_COST_MEDIUM = 12.00;
    private static final double SHIPPING_COST_FREE = 0.0;

    public Double shipment(Order order) {
        Double basic = order.getBasic();

        if(basic < BASIC_THRESHOLD_LOW) {
            return SHIPPING_COST_LOW;
        }

        if(basic >= BASIC_THRESHOLD_LOW && basic <= BASIC_THRESHOLD_HIGH) {
            return SHIPPING_COST_MEDIUM;
        }

        return SHIPPING_COST_FREE;
    }
}
