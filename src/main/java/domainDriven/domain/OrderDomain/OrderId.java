package domainDriven.domain.OrderDomain;

public class OrderId {
    private String value;
    private String email;

    public OrderId(String value, String email) {
        this.value = value;
        this.email = email;
    }

    public String getValue() {
        return value;
    }

    public String getEmail() {
        return email;
    }
}
