package org.alan.domainDriven.Service;

import org.alan.domainDriven.domain.AccountDomain.AccountRepository;
import org.alan.domainDriven.domain.ProductDomain.ProductId;
import org.alan.domainDriven.domain.ProductDomain.productDto.NewProductRequest;
import org.alan.domainDriven.domain.StoreDomain.Store;

public class RegisterProductService {

    AccountRepository accountRepository;

    public ProductId registerNewProduct(NewProductRequest request) {
        Store account = accountRepository.findStoreById(request.getStoreId());
        checkNull(account);
        return null;
    }

    private void checkNull(Store account) {

    }
}
