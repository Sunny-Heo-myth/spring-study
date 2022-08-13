package domainDriven.domain.ProductDomain.productDto;

import domainDriven.domain.StoreDomain.StoreId;

public class NewProductRequest {

    StoreId storeId;

    public StoreId getStoreId() {
        return storeId;
    }
}
