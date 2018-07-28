package katas.warehouseorder;

public interface InventoryRepository {

    void create(ProductBarcode productBarcode, Product product);
    void delete(ProductBarcode barcode);
    Product get(ProductBarcode barcode);
}
