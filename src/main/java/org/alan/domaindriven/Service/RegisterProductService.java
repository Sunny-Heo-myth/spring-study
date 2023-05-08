package org.alan.domaindriven.Service;

import org.alan.domaindriven.domain.AccountDomain.AccountRepository;
import org.alan.domaindriven.domain.ProductDomain.ProductId;
import org.alan.domaindriven.domain.ProductDomain.productDto.NewProductRequest;
import org.alan.domaindriven.domain.StoreDomain.Store;

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
