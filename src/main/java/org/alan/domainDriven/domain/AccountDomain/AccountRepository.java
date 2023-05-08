package org.alan.domainDriven.domain.AccountDomain;

import org.alan.domainDriven.domain.StoreDomain.Store;
import org.alan.domainDriven.domain.StoreDomain.StoreId;

public interface AccountRepository {
    Store findStoreById(StoreId storeId);
}
