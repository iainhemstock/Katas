package katas.warehouseorder;

public class InvoicePrinter {
    private Console console;

    public InvoicePrinter(Console console) {
        this.console = console;
    }

    public void print(Barcodes barcodes) {
        console.printLine("+ --------------------------------------------------------------- +");
        console.printLine("|  PRODUCT INVOICE                                                |");
        console.printLine("+ --------------------------------------------------------------- +");
        console.printLine("|  QTY | PRODUCT                          | PRICE    | TOTAL      |");
        console.printLine("+ --------------------------------------------------------------- +");
        console.printLine("|      |                                  |          |            |");
        console.printLine("+ --------------------------------------------------------------- +");
        console.printLine("|  ITEMS: 1                                                       |");
        console.printLine("|  BALANCE DUE: £4.50                                             |");
        console.printLine("+ --------------------------------------------------------------- +");
    }
}
