package katas.warehouseorder;

public class Order {

    private Barcodes barcodes;
    private InvoicePrinter invoicePrinter;

    public Order(InvoicePrinter invoicePrinter, Barcodes barcodes) {
        this.invoicePrinter = invoicePrinter;
        this.barcodes = barcodes;
    }

    public void print() {
        this.invoicePrinter.print(barcodes);
    }

    public void addProduct(ProductBarcode barcode) {
        this.barcodes.append(barcode);
    }

    public void fill(Warehouse warehouse)  {
        throw new UnsupportedOperationException();
    }
}
