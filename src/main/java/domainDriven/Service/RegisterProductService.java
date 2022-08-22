package domainDriven.Service;

import domainDriven.domain.AccountDomain.AccountRepository;
import domainDriven.domain.ProductDomain.ProductId;
import domainDriven.domain.ProductDomain.productDto.NewProductRequest;
import domainDriven.domain.StoreDomain.Store;

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
