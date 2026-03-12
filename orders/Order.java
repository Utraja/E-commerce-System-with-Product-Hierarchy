package orders;

import java.util.Date;
import cart.ShoppingCart;

public class Order {

    private static int orderCounter = 1000;

    private String orderId;
    private Date orderDate;
    private ShoppingCart cart;
    private double finalAmount;

    public Order(ShoppingCart cart) {

        this.orderId = "ORD" + (orderCounter++);
        this.orderDate = new Date();
        this.cart = cart;
        this.finalAmount = calculateFinalAmount();
    }

    private double calculateFinalAmount() {

        double total = cart.getTotalAmount();
        return total * 1.18;
    }

    public void displayOrder() {

        System.out.println("\n=== ORDER DETAILS ===");

        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);

        cart.displayCart();

        System.out.println("Subtotal: ₹" + cart.getTotalAmount());
        System.out.println("GST: ₹" + (cart.getTotalAmount()*0.18));
        System.out.println("Final Amount: ₹" + finalAmount);
    }
}