package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {

    private String downloadUrl;
    private double fileSizeMB;

    // no-arg constructor - Jackson needs this to build an object from incoming JSON
    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price,
                          String downloadUrl, double fileSizeMB) {
        super(id, name, price);   // sets up the inherited half (id, name, price) in Product
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadUrl() { return downloadUrl; }
    public double getFileSizeMB() { return fileSizeMB; }
}