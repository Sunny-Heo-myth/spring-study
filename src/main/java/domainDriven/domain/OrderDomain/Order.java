package domainDriven.domain.OrderDomain;

import domainDriven.domain.Money;
import domainDriven.domain.ShippingInfo;

import java.util.List;

// domain entity
// aggregate root entity
public class Order {

    private OrderId orderId;    // Connecting with id between domains.
    private Orderer orderer;
    private OrderState state;
    private ShippingInfo shippingInfo;
    private List<OrderLine> orderLineList;
    private Money totalAmounts;

    public Order(Orderer orderer, List<OrderLine> orderLineList, ShippingInfo shippingInfo, OrderState orderState) {
        setOrderer(orderer);
        setOrderLineList(orderLineList);
        setShippingInfo(shippingInfo);
        setOrderState();
    }

    // domain features

    public void changeShippingInfo(ShippingInfo newShippingInfo) {
        checkShippingInfoChangeable();
        verifyNotShippedYet();
        this.shippingInfo = newShippingInfo;
    }

    private void checkShippingInfoChangeable() {
        // Check whether shipping information changeable.
    }

    public void changeShipped() {
        // sth...
        this.state = OrderState.SHIPPED;
    }

    public void cancel() {
        verifyNotShippedYet();
        this.state = OrderState.CANCELED;
    }

    public void completePayment() {

    }

    private void verifyAtLeastOneOrderLines(List<OrderLine> orderLineList) {
        if (orderLineList == null || orderLineList.isEmpty()) {
            throw new IllegalArgumentException("There is no orderLine element in domainDriven.Order.Order " + this.orderId + ".");
        }
    }

    private void calculateTotalAmounts() {
        int sum = this.orderLineList.stream()
                .mapToInt(orderLine -> orderLine.getPrice().getValue() * orderLine.getQuantity())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    private void verifyNotShippedYet() {
        if (this.state != OrderState.PAYMENT_WAITING && this.state != OrderState.PREPARING) {
            throw new IllegalStateException("The order already shipped.");
        }
    }

    private void setOrderState() {
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) {
            throw new IllegalArgumentException("domainDriven.Order.Orderer in domainDriven.Order.Order "  + orderId + "is null.");
        }
        this.orderer = orderer;
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null) {
            throw new IllegalArgumentException("domainDriven.domain.ShippingInfo is null.");
        }
        this.shippingInfo = shippingInfo;
    }

    private void setOrderLineList(List<OrderLine> orderLineList) {
        verifyAtLeastOneOrderLines(orderLineList);
        this.orderLineList = orderLineList;
        calculateTotalAmounts();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (object.getClass() != Order.class) {
            return false;
        }

        Order other = (Order) object;
        if (this.orderId == null) {
            return false;
        }
        return this.orderId.equals(other.orderId);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + ((this.orderId == null) ? 0 : orderId.hashCode());
    }
}
