package org.alan.domaindriven.domain;

import org.alan.domaindriven.domain.OrderDomain.Order;
import org.alan.domaindriven.domain.OrderDomain.OrderId;
import org.alan.domaindriven.domain.OrderDomain.OrderRepository;

import java.util.NoSuchElementException;

public class CancelOrderService {
    private OrderRepository orderRepository;

    public void cancel(OrderId orderId) {
        Order order = orderRepository.findById(orderId);
        if (order == null) {
            throw new NoSuchElementException("There is no order with id : " + orderId + ".");
        }
        order.cancel();
    }
}
