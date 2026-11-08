package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it has an id, name and price like every product, and can be used anywhere a Product is expected.
// A ShoppingCart would NOT pass this test: a cart HAS products, it is not itself a product, so it should hold a List<Product> field instead of extending Product.

public class PhysicalProduct extends Product implements Discountable {

    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    // no-arg constructor - Jackson needs this to build an object from incoming JSON
    public PhysicalProduct() {
    }

    public PhysicalProduct(Long id, String name, double price,
                           double weightKg, String dimensions) {
        super(id, name, price);   // sets up the inherited id, name, price in Product
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + getWeightKg() + " kg";
    }

    @Override
    public void applyDiscount(double rate) {
        // Shipping is never discounted, so the discount is capped at 20%
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }
}