package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

// bundle is-a product for the shop list, but also has-a list of products inside it
public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items;
    }

    @Override
    public String getSummary() {
        return getName();
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        this.items.add(item);
    }
}
