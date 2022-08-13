package domainDriven.domain.AccountDomain;

import domainDriven.domain.StoreDomain.Store;
import domainDriven.domain.StoreDomain.StoreId;

public interface AccountRepository {
    Store findStoreById(StoreId storeId);
}
