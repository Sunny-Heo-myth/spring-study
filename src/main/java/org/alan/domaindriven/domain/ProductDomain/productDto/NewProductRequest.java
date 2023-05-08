package org.alan.domaindriven.domain.ProductDomain.productDto;

import org.alan.domaindriven.domain.StoreDomain.StoreId;

public class NewProductRequest {

    StoreId storeId;

    public StoreId getStoreId() {
        return storeId;
    }
}
