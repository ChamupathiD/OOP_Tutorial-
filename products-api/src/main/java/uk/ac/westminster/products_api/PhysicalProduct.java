package uk.ac.westminster.products_api;

// physical product is-a product bc it has id, name, price like others
// shopping cart is not a product, it just has-a list of products
public class PhysicalProduct extends Product {

    private double weightKg;
    private String dimensions;

    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
