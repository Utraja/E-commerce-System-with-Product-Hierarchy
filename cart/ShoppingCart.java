package cart;

import products.Product;

import java.util.*;

public class ShoppingCart {

    private List<CartItem> items = new ArrayList<>();
    private double totalAmount;

    public void addItem(Product product, int quantity) {

        for(CartItem item:items) {

            if(item.getProduct().getId().equals(product.getId())) {

                item.setQuantity(item.getQuantity()+quantity);
                calculateTotal();
                return;
            }
        }

        items.add(new CartItem(product,quantity));
        calculateTotal();
    }

    public void removeItem(String productId) {

        items.removeIf(item -> item.getProduct().getId().equals(productId));
        calculateTotal();
    }

    public void updateQuantity(String productId,int quantity) {

        for(CartItem item:items) {

            if(item.getProduct().getId().equals(productId)) {

                item.setQuantity(quantity);
                calculateTotal();
                return;
            }
        }
    }

    private void calculateTotal() {

        totalAmount = 0;

        for(CartItem item:items) {

            totalAmount += item.getItemTotal();
        }
    }

    public void displayCart() {

        System.out.println("\n=== SHOPPING CART ===");

        if(items.isEmpty()) {

            System.out.println("Cart is empty!");
            return;
        }

        for(CartItem item:items) {

            Product p = item.getProduct();

            System.out.println(p.getId()+" | "
                    +p.getName()+" | Qty: "
                    +item.getQuantity()+" | Total ₹"
                    +item.getItemTotal());
        }

        System.out.println("Total Amount: ₹"+totalAmount);
    }

    public double getTotalAmount() { return totalAmount; }

    public List<CartItem> getItems() { return items; }
}