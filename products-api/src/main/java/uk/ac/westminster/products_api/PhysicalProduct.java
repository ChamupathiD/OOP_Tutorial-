package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because every shipped item is a catalogue product that shares an id, name, and price with all other products.
// A ShoppingCart would NOT pass this test because a cart is not a product sold in the shop; instead, a ShoppingCart HAS-A list of Products (composition).
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
