package westernrestaurantmain;
//latest
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextOrderID = 1;
    private int orderID;
    private List<MenuItem> cart;
    private double totalPrice;
    private String status;
    private Customer customer;

    public Order(Customer customer) {
        this.orderID = nextOrderID++;
        this.cart = new ArrayList<>();
        this.totalPrice = 0.0;
        this.status = "Pending";
        this.customer = customer;
    }
    
    
    
//================================== Methods ==================================//
    
    public void addToCart(MenuItem item) {
        cart.add(item);
        totalPrice += item.getItemPrice();
    }

    public void displayCart() {
        System.out.println("\n===========================");
        System.out.println("Cart Contents:");
        for (MenuItem item : cart) {
            System.out.println("[" + item.getItemID() + "]  " + item.getItemName() + " - RM " + item.getItemPrice());
        }
        System.out.println("\nTotal Price: RM " + totalPrice);
        System.out.println("---------------------------\n");
    }
    
    public void generateReceipt() {
        System.out.println("\n===========================");
        System.out.println("Receipt for Order ID: " + orderID);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Table Number: " + customer.getTable());
        System.out.println("---------------------------");
        for (MenuItem item : cart) {
            System.out.println("[" + item.getItemID() + "]  " + item.getItemName() + " - RM " + item.getItemPrice());
        }
        System.out.println("Total Price: RM " + totalPrice);
        System.out.println("---------------------------\n");
    }

    
    
//============================== Setter & Getter ==============================//

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List<MenuItem> getCart() {
        return cart;
    }

    public void setCart(List<MenuItem> cart) {
        this.cart = cart;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
