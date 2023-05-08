package org.alan.domaindriven.domain.AccountDomain;

import org.alan.domaindriven.domain.StoreDomain.Store;
import org.alan.domaindriven.domain.StoreDomain.StoreId;

public interface AccountRepository {
    Store findStoreById(StoreId storeId);
}
