package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        DigitalProduct ebook = new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2);

        PhysicalProduct monitor = new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm");

        products.add(ebook);
        products.add(monitor);

        // seed bundle product for stretch task
        products.add(new BundleProduct(
                nextId++, "Starter Dev Bundle", 259.99,
                List.of(ebook, monitor)));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    // p.applyDiscount(0.10) wont compile bc p is Product not Discountable (need instanceof first)
    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();
        for (Product p : products) {
            summaries.add(p.getSummary());
        }
        return summaries;
    }
}
