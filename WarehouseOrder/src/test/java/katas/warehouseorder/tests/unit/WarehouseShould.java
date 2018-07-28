package katas.warehouseorder.tests.unit;

import katas.warehouseorder.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WarehouseShould {

    @Mock private InMemoryInventoryRepository inventoryRepository;
    private Warehouse warehouse;

    @Before
    public void setup() {
        this.warehouse = new Warehouse(inventoryRepository);
    }

    @Test
    public void create_and_store_a_product() {
        ProductBarcode productBarcode = new ProductBarcode();
        Product product = new Product(new ProductName(), new ProductPrice());
        this.warehouse.addStock(productBarcode, product);
        verify(inventoryRepository).create(productBarcode, product);
    }

    @Test
    public void remove_a_single_product_from_inventory() {
        ProductBarcode barcode = new ProductBarcode();
        this.warehouse.removeStock(barcode);
        verify(inventoryRepository).delete(barcode);
    }
}
