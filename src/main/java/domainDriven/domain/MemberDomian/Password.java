package domainDriven.domain.MemberDomian;

import java.util.Objects;

public class Password {
    private String value;

    public Password(String value) {
        this.value = value;
    }

    public boolean match(String password) {
        if (!Objects.equals(this.value, password)) {
            return false;
        }
        return true;
    }

    public String getValue() {
        return value;
    }
}
