package org.alan.domainDriven.domain.ProductDomain.productDto;

import org.alan.domainDriven.domain.StoreDomain.StoreId;

public class NewProductRequest {

    StoreId storeId;

    public StoreId getStoreId() {
        return storeId;
    }
}
