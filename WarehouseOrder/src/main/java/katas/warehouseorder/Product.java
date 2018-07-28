package katas.warehouseorder;

import java.util.Objects;

public class Product {

    private ProductName productName;
    private ProductPrice productPrice;

    public Product(ProductName productName, ProductPrice productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public ProductName name() {
        return this.productName;
    }

    public ProductPrice price() {
        return this.productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName) &&
                Objects.equals(productPrice, product.productPrice);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productName, productPrice);
    }
}
