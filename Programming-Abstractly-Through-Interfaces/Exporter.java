interface Exporter {
    void export(String data);

    default void exportToJSON(String data) {
        System.out.println("Exporting data as JSON: { \"data\": \"" + data + "\" }");
    }
}

class CSVExporter implements Exporter {
    public void export(String data) {
        System.out.println("Exporting data as CSV: " + data);
    }
}

class PDFExporter implements Exporter {
    public void export(String data) {
        System.out.println("Exporting data as PDF: " + data);
    }
}

public class DataExport {
    public static void main(String[] args) {
        Exporter csv = new CSVExporter();
        Exporter pdf = new PDFExporter();

        csv.export("Report Data");
        csv.exportToJSON("Report Data");

        pdf.export("Report Data");
        pdf.exportToJSON("Report Data");
    }
}
