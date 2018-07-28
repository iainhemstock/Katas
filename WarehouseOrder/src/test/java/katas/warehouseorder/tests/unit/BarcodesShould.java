package katas.warehouseorder.tests.unit;

import katas.warehouseorder.ProductBarcode;
import katas.warehouseorder.Barcodes;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BarcodesShould {

    private Barcodes barcodes;

    @Before
    public void setup() {
        this.barcodes = new Barcodes();
    }

    @Test
    public void can_append_a_product_barcode() {
        ProductBarcode barcode = new ProductBarcode("8711000519417");
        this.barcodes.append(barcode);
        assertThat(this.barcodes.at(0), is(equalTo(barcode)));
    }

}
