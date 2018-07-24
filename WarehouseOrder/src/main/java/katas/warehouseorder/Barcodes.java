package katas.warehouseorder;

import java.util.ArrayList;
import java.util.List;

public class Barcodes {
    private List<ProductBarcode> products = new ArrayList<>();

    public void append(ProductBarcode productBarcode) {
        this.products.add(productBarcode);
    }

    public ProductBarcode at(int i) {
        return this.products.get(i);
    }
}
