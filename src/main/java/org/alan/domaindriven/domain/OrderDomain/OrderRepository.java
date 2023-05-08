package org.alan.domaindriven.domain.OrderDomain;

public interface OrderRepository {
    Order findById(OrderId orderId);
    void save(Order order);
    void delete(Order order);
}
