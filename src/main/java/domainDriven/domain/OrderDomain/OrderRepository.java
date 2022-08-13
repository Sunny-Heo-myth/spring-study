package domainDriven.domain.OrderDomain;

public interface OrderRepository {
    Order findById(OrderId orderId);
    void save(Order order);
    void delete(Order order);
}
