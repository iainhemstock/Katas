package katas.warehouseorder.tests.unit;

import katas.warehouseorder.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class OrderShould {

    @Mock private InvoicePrinter invoicePrinter;
    @Mock private Barcodes barcodes;
    @Mock private Warehouse warehouse;
    private Order order;

    @Before
    public void setup() {
        this.order = new Order(invoicePrinter, barcodes );
    }

    @Test
    public void append_a_product_to_the_order() {
        ProductBarcode barcode = new ProductBarcode();
        this.order.addProduct(barcode);
        verify(barcodes).append(barcode);
    }

}
