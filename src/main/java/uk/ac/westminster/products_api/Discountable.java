package uk.ac.westminster.products_api;

// A contract: no bodies, no fields. Any class that implements this promises to provide both methods.
public interface Discountable {
    void applyDiscount(double rate);
    double getDiscountedPrice();
}