package katas.warehouseorder;

public class Warehouse {

    private InventoryRepository inventoryRepository;

    public Warehouse(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void addStock(ProductBarcode barcode, Product product) {
        this.inventoryRepository.create(barcode, product);
    }

    public void removeStock(ProductBarcode barcode) {
        this.inventoryRepository.delete(barcode);
    }

    public boolean hasStock(ProductBarcode barcode) {
        return true;
    }
}
