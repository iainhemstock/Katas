package katas.shoppingcart;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.inOrder;

public class FeaturePrintInvoice {

    private Warehouse warehouse = new Warehouse();
    private Order order = new Order();

    @Test
    public void printBlankInvoiceWhenNoProductsOrdered() {
        order.fill(warehouse);
        Invoice invoice = order.invoice();
        invoice.print();

        InOrder order = inOrder(console);
        order.verify(console).print("+ ------------------------------------------ +");
        order.verify(console).print("|  PRODUCT INVOICE                           |");
        order.verify(console).print("+ -------------------------------=---------- +");
        order.verify(console).print("|  QTY | PRODUCT           | PRICE | TOTAL   |");
        order.verify(console).print("+ ------------------------------------------ +");
        order.verify(console).print("|      |                   |       |         |");
        order.verify(console).print("+ ------------------------------------------ +");
        order.verify(console).print("|  ITEMS: 0                    TOTAL: £0.00  |");
        order.verify(console).print("+ ------------------------------------------ +");
    }
}
/*



NO PRODUCTS INVOICE

+ ------------------------------------------ +
|  PRODUCT INVOICE                           |
+ -------------------------------=---------- +
|  QTY | PRODUCT           | PRICE | TOTAL   |
+ ------------------------------------------ +
|      |                   |       |         |
+ ------------------------------------------ +
|  ITEMS: 0                    TOTAL: £0.00  |
+ ------------------------------------------ +



SINGLE PRODUCT INVOICE

+ ------------------------------------------ +
|  PRODUCT INVOICE                           |
+ -------------------------------=---------- +
|  QTY | PRODUCT           | PRICE | TOTAL   |
+ ------------------------------------------ +
|  1   | Choc Mints 270g   | £1.50 |  £1.50  |
+ ------------------------------------------ +
|  ITEMS: 1                    TOTAL: £1.50  |
+ ------------------------------------------ +



TWO IDENTICAL PRODUCTS INVOICE

+ ------------------------------------------ +
|  PRODUCT INVOICE                           |
+ -------------------------------=---------- +
|  QTY | PRODUCT           | PRICE | TOTAL   |
+ ------------------------------------------ +
|  2   | Choc Mints 270g   | £1.50 |  £3.00  |
+ ------------------------------------------ +
|  ITEMS: 2                    TOTAL: £3.00  |
+ ------------------------------------------ +



TWO PRODUCTS WITH PRICING RULE INVOICE

+ ------------------------------------------ +
|  PRODUCT INVOICE                           |
+ -------------------------------=---------- +
|  QTY | PRODUCT           | PRICE | TOTAL   |
+ ------------------------------------------ +
|  2   | Choc Mints 270g   | £1.50 |  £3.00  |
|      | Mints offer       |       | -£1.50  |
+ ------------------------------------------ +
|  ITEMS: 2                    TOTAL: £1.50  |
+ ------------------------------------------ +


//    private static final String     KENCO_BARCODE = "8711000519417";
//    private static final String     KENCO_PRODUCT_NAME = "Kenco Coffee 200g";
//    private static final int        KENCO_UNIT_PRICE = 350;
//    private static final String     MINTS_BARCODE = "1000031652000";
//    private static final String     MINTS_PRODUCT_NAME = "Choc Mints 270g";
//    private static final int        MINTS_UNIT_PRICE = 150;
//
//}
*/