package org.alan.domainDriven.domain.CategoryDomain;

import org.alan.domainDriven.domain.ProductDomain.Product;

import java.util.List;
import java.util.Set;

public class Category {

    private Set<Product> productSet;

    public List<Product> getProducts(int page, int size) {
        List<Product> sortedProducts = sortById(this.productSet);
        return sortedProducts.subList((page - 1) * size, page * size);
    }

    private List<Product> sortById(Set<Product> productSet) {
        return null;
    }
}
