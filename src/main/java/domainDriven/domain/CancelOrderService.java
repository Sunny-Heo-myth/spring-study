package domainDriven.domain;

import domainDriven.domain.OrderDomain.Order;
import domainDriven.domain.OrderDomain.OrderId;
import domainDriven.domain.OrderDomain.OrderRepository;

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
