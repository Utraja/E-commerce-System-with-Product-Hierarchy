package products;

public abstract class Product {

            protected String id;
            protected String name;
            protected double price;
            protected String description;
            protected int stockQuantity;

            public Product(String id, String name, double price,
                           String description, int stockQuantity) {

                this.id = id;
                this.name = name;
                this.price = price;
                this.description = description;
                this.stockQuantity = stockQuantity;
            }

            public abstract double calculateDiscount();

            public double getFinalPrice() {
                return price - calculateDiscount();
            }

            public String getId() { return id; }
            public String getName() { return name; }
            public double getPrice() { return price; }
            public String getDescription() { return description; }
            public int getStockQuantity() { return stockQuantity; }

            public void setStockQuantity(int quantity) {
                this.stockQuantity = quantity;
            }

            public void displayInfo() {
                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Price: ₹" + price);
                System.out.println("Description: " + description);
                System.out.println("Stock: " + stockQuantity);
                System.out.println("Discount: ₹" + calculateDiscount());
                System.out.println("Final Price: ₹" + getFinalPrice());
            }
        }
