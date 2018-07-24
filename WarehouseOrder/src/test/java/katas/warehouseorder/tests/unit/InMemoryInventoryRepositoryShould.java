package katas.warehouseorder.tests.unit;

import katas.warehouseorder.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class InMemoryInventoryRepositoryShould {

    private static final ProductBarcode KENCO_BARCODE = new ProductBarcode("8711000519417");
    private static final ProductName KENCO_PRODUCT_NAME = new ProductName("Kenco Coffee 200g");
    private static final ProductPrice KENCO_UNIT_PRICE = new ProductPrice(450);
    private InMemoryInventoryRepository inventoryRepository;

    @Before
    public void setup() {
        this.inventoryRepository = new InMemoryInventoryRepository();
    }

    @Test
    public void store_a_new_product_by_its_barcode() {
        Product product = new Product(KENCO_PRODUCT_NAME, KENCO_UNIT_PRICE);
        this.inventoryRepository.create(KENCO_BARCODE, product);
        assertThat(this.inventoryRepository.get(KENCO_BARCODE), is(equalTo(product)));
        assertThat(this.inventoryRepository.getQuantity(KENCO_BARCODE), is(equalTo(1)));
    }

    @Test
    public void increase_quantity_when_storing_more_of_existing_inventory() {
        Product product = new Product(KENCO_PRODUCT_NAME, KENCO_UNIT_PRICE);
        this.inventoryRepository.create(KENCO_BARCODE, product);
        this.inventoryRepository.create(KENCO_BARCODE, product);
        assertThat(this.inventoryRepository.getQuantity(KENCO_BARCODE), is(equalTo(2)));
    }

}
