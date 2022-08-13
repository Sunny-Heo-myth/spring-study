package domainDriven.domain.OrderDomain;

public enum OrderState {

    PAYMENT_WAITING(0),
    PREPARING(1),
    SHIPPED(2),
    DELIVERING(3),
    DELIVERY_COMPLETED(4),
    CANCELED(5);

    private final int orderStateCode;

    OrderState(int orderStateCode) {
        this.orderStateCode = orderStateCode;
    }

    public boolean isShippingChangeable() {
        return this.orderStateCode == 0 || this.orderStateCode == 1;
    }
}
