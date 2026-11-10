package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {

    private String downloadUrl;
    private double fileSizeMB;

    // empty constructor for jackson json
    public DigitalProduct() {
    }

    public DigitalProduct(Long id, String name, double price,
                          String downloadUrl, double fileSizeMB) {
        super(id, name, price);
        this.downloadUrl = downloadUrl;
        this.fileSizeMB = fileSizeMB;
    }

    // summary field in json comes from here bc jackson checks getters
    @Override
    public String getSummary() {
        return "Digital: " + getName()
                + " | Download: " + downloadUrl;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }
}
