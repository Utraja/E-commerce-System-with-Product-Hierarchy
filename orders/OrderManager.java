package orders;

import java.util.*;

public class OrderManager {

    private List<Order> orders = new ArrayList<>();

    public void placeOrder(Order order) {

        orders.add(order);

        System.out.println("Order placed successfully!");
        order.displayOrder();
    }

    public void viewOrders() {

        if(orders.isEmpty()) {

            System.out.println("No orders found.");
            return;
        }

        for(Order order:orders) {

            order.displayOrder();
        }
    }
}