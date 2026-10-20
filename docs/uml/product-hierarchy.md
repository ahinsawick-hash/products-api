# Product Hierarchy – UML Class Diagram (Tutorial 4)

```mermaid
classDiagram
    class Product {
        -Long id
        -String name
        -double price
        +Product()
        +Product(Long id, String name, double price)
        +getId() Long
        +getName() String
        +getPrice() double
        +setId(Long id) void
        +setName(String name) void
        +setPrice(double price) void
    }
    class DigitalProduct {
        -String downloadUrl
        -double fileSizeMB
        +DigitalProduct()
        +DigitalProduct(Long id, String name, double price, String downloadUrl, double fileSizeMB)
        +getDownloadUrl() String
        +getFileSizeMB() double
    }
    class PhysicalProduct {
        -double weightKg
        -String dimensions
        +PhysicalProduct()
        +PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions)
        +getWeightKg() double
        +getDimensions() String
    }
    Product <|-- DigitalProduct
    Product <|-- PhysicalProduct
```