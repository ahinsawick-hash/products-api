package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    // Spring creates the ProductService and hands it over - we never write "new ProductService()"
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // One call, one line per product - each subclass answers with its own getSummary()
    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }

    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    // Product is now abstract, so Jackson can't create one from JSON.
    // Temporary fix: accept a concrete subclass. Proper fix comes in Lectures 6-7.
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}