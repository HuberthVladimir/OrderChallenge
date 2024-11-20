package com.dsorder.desafio.services;

import com.dsorder.desafio.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private ShippingService shippingService;

    private static final double FULL_PERCENTAGE = 100.0;
    private static final double PERCENTAGE_CONVERSION_FACTOR = 100.0;

    private Double discount(Double basic, Double discount) {
        Double discountedPercentage = (FULL_PERCENTAGE - discount) / PERCENTAGE_CONVERSION_FACTOR;
        return discountedPercentage * basic;
    }

    public Double total(Order order) {
        Double discountedValue = discount(order.getBasic(), order.getDiscount());
        Double shipmentIncrement = shippingService.shipment(order);
        return discountedValue + shipmentIncrement;
    }
}
