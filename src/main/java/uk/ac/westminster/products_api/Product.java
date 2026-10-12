package uk.ac.westminster.products_api;

public class Product {

    private Long id;
    private String name;
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Jackson needs a public getter for each private field to include it in the JSON
    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}
