package domainDriven.domain.AccountDomain;

public class Account {

    private AccountId accountId;
    private boolean blocked;

    public boolean isBlocked() {
        return this.blocked;
    }
}
