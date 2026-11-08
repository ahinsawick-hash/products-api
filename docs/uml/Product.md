# Product Hierarchy – UML Class Diagram (Tutorial 5)

```mermaid
classDiagram
    class Product {
        <<abstract>>
        -Long id
        -String name
        -double price
        +Product()
        +Product(Long id, String name, double price)
        +getSummary()* String
        +getId() Long
        +getName() String
        +getPrice() double
        +setId(Long id) void
        +setName(String name) void
        +setPrice(double price) void
    }
    class Discountable {
        <<interface>>
        +applyDiscount(double rate) void
        +getDiscountedPrice() double
    }
    class DigitalProduct {
        -String downloadUrl
        -double fileSizeMB
        -double discountedPrice
        +DigitalProduct()
        +DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB)
        +getSummary() String
        +applyDiscount(double rate) void
        +getDiscountedPrice() double
        +getDownloadUrl() String
        +getFileSizeMB() double
    }
    class PhysicalProduct {
        -double weightKg
        -String dimensions
        -double discountedPrice
        +PhysicalProduct()
        +PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions)
        +getSummary() String
        +applyDiscount(double rate) void
        +getDiscountedPrice() double
        +getWeightKg() double
        +getDimensions() String
    }
    Product <|-- DigitalProduct
    Product <|-- PhysicalProduct
    Discountable <|.. DigitalProduct
    Discountable <|.. PhysicalProduct
```