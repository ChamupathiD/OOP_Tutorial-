package uk.ac.westminster.products_api;

public interface Discountable {

    // contract only - no fields or method bodies
    void applyDiscount(double rate);

    double getDiscountedPrice();
}
