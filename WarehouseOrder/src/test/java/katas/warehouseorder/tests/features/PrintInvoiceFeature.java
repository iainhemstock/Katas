package katas.warehouseorder.tests.features;

import katas.warehouseorder.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.inOrder;

@RunWith(MockitoJUnitRunner.class)
public class PrintInvoiceFeature {

    private static final ProductBarcode KENCO_BARCODE = new ProductBarcode("8711000519417");
    private static final ProductName KENCO_PRODUCT_NAME = new ProductName("Kenco Coffee 200g");
    private static final ProductPrice KENCO_UNIT_PRICE = new ProductPrice(450);
    private static final Product KENCO_PRODUCT = new Product(KENCO_PRODUCT_NAME, KENCO_UNIT_PRICE);

    @Mock private Console console;

    private InvoicePrinter invoicePrinter;
    private Order order;
    private InventoryRepository inventoryRepository;
    private Warehouse warehouse;
    private Barcodes barcodes;

    @Before
    public void setup() {
        inventoryRepository = new InMemoryInventoryRepository();
        warehouse = new Warehouse(inventoryRepository);
        invoicePrinter = new InvoicePrinter(console);
        barcodes = new Barcodes();
        order = new Order(invoicePrinter, barcodes);
    }

    @Test
    public void print_invoice_when_no_products_added_to_order() {
        order.print();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  PRODUCT INVOICE                                                |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  QTY | PRODUCT                          | PRICE    | TOTAL      |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|      |                                  |          |            |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  ITEMS: 1                                                       |");
        inOrder.verify(console).printLine("|  BALANCE DUE: £4.50                                             |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
    }

    @Test
    public void print_invoice_when_a_single_product_is_added_to_order() throws InsufficientInventoryException {
        warehouse.addStock(KENCO_BARCODE, KENCO_PRODUCT);

        order.addProduct(KENCO_BARCODE);
        order.fill(warehouse);
        order.print();

        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  PRODUCT INVOICE                                                |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  QTY | PRODUCT                          | PRICE    | TOTAL      |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  1   | Kenco Coffee 200g                | £4.50    | £4.50      |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
        inOrder.verify(console).printLine("|  ITEMS: 1                                                       |");
        inOrder.verify(console).printLine("|  BALANCE DUE: £4.50                                             |");
        inOrder.verify(console).printLine("+ --------------------------------------------------------------- +");
    }

}
