package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

// bundle is-a product for the shop list, but also has-a list of products inside it
// stretch task: 0 lines changed in getAllSummaries() bc of polymorphism
// implements Discountable: discount could be on bundle price or each item inside (composite pattern)
public class BundleProduct extends Product
        implements Discountable {

    private List<Product> items = new ArrayList<>();
    private double discountedPrice;

    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Bundle: " + getName()
                + " | Items: " + items.size();
    }

    @Override
    public void applyDiscount(double rate) {
        // apply discount to the overall bundle price
        this.discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        this.items.add(item);
    }
}
