package katas.warehouseorder;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInventoryRepository implements InventoryRepository {

    private Map<ProductBarcode, DataRow> map = new HashMap<>();

    private class DataRow {
        public ProductName productName;
        public ProductPrice productPrice;
        public int quantity = 0;
    }

    @Override
    public void create(ProductBarcode productBarcode, Product product) {
        DataRow row = this.fetchRow(productBarcode);
        int newQuantity = row.quantity + 1;
        row = initializeRow(row, product, newQuantity);
        this.map.put(productBarcode, row);
    }

    @Override
    public void delete(ProductBarcode productBarcode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Product get(ProductBarcode barcode) {
        DataRow row = this.map.get(barcode);
        return new Product(row.productName, row.productPrice);
    }

    public int getQuantity(ProductBarcode barcode) {
        return this.map.get(barcode).quantity;
    }

    private DataRow fetchRow(ProductBarcode productBarcode) {
        DataRow row = null;
        if (this.map.containsKey(productBarcode)) row = this.map.get(productBarcode);
        else row = new DataRow();
        return row;
    }

    private DataRow initializeRow(DataRow row, Product product, int newQuantity) {
        row.productName = product.name();
        row.productPrice = product.price();
        row.quantity = newQuantity;
        return row;
    }
}
