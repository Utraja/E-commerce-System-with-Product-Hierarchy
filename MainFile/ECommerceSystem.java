package MainFile;
import java.util.*;

import products.*;
import cart.*;
import orders.*;

public class ECommerceSystem {

    static List<Product> products = new ArrayList<>();
    static ShoppingCart cart = new ShoppingCart();
    static OrderManager manager = new OrderManager();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        loadProducts();

        int choice;

        do {

            System.out.println("\n=== E COMMERCE SYSTEM ===");

            System.out.println("1 View Products");
            System.out.println("2 Add To Cart");
            System.out.println("3 View Cart");
            System.out.println("4 Checkout");
            System.out.println("5 Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1: viewProducts(); break;

                case 2: addToCart(); break;

                case 3: cart.displayCart(); break;

                case 4: checkout(); break;

                case 5: System.out.println("Thank you"); break;

                default: System.out.println("Invalid choice");
            }

        } while(choice!=5);
    }

    static void loadProducts() {

        products.add(new ElectronicsProduct(
                "E001","Smartphone",50000,
                "Latest smartphone",50,
                "TechBrand",24));

        products.add(new ClothingProduct(
                "C001","T Shirt",1200,
                "Cotton shirt",100,
                "M","Blue","Cotton"));

        products.add(new BookProduct(
                "B001","Java Programming",800,
                "Learn Java",75,
                "John Doe","9783161484100",400));
    }

    static void viewProducts() {

        for(Product p:products) {

            p.displayInfo();
        }
    }

    static Product findProduct(String id) {

        for(Product p:products) {

            if(p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }

        return null;
    }

    static void addToCart() {

        System.out.print("Enter product id: ");
        String id = sc.next();

        Product product = findProduct(id);

        if(product==null) {

            System.out.println("Product not found");
            return;
        }

        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        cart.addItem(product,qty);

        System.out.println("Added to cart");
    }

    static void checkout() {

        if(cart.getItems().isEmpty()) {

            System.out.println("Cart is empty");
            return;
        }

        Order order = new Order(cart);
        manager.placeOrder(order);
    }
}