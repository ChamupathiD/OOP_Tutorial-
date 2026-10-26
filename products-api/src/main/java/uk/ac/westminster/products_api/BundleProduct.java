package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

// Stretch Task — Is BundleProduct really an IS-A Product, or a HAS-A hiding inside an extends?
// Both answers are defensible (and together they form the classic GoF Composite design pattern):
// 1. Defending IS-A (extends Product): To the shop catalogue, search endpoint, and checkout, a bundle IS-A Product
//    because it has its own catalogue id, name, and bundle price, and can sit inside List<Product> alongside single items.
// 2. Defending HAS-A (composition): Internally, a bundle is a collection of other products (private List<Product> items),
//    meaning it HAS-A list of Products. Extending Product while holding a List<Product> combines inheritance (for uniform
//    catalogue treatment) with composition (for storing the bundled items).
public class BundleProduct extends Product {

    private List<Product> items = new ArrayList<>();

    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items;
    }

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product item) {
        this.items.add(item);
    }
}
