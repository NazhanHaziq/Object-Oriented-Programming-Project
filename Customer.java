
package westernrestaurantmain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author nazhan
 */

public class Customer extends User {
    private int table;
    private int pax;
    private List<Order> orders;

    public Customer(String username, String password, String name, int table, int pax) {
        super(username, password, name);
        this.table = table;
        this.pax = pax;
        this.orders = new ArrayList<>();
    }

    
    
//================================== Methods ==================================//
    
    @Override
    public void displayOptions() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Order currentOrder = new Order(this);

        while (!exit) {
            System.out.println("\n\n\tOrder Page:");
            System.out.println("---------------------------");
            System.out.println("[1]   View Menu");
            System.out.println("[2]   Add Item to Cart");
            System.out.println("[3]   View Cart");
            System.out.println("[4]   Finalize Order");
            System.out.println("[5]   Update Information");
            System.out.println("[6]   Log out");
            System.out.println("---------------------------");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    RestaurantInfo.getInstance().getRestaurant().getMenu().displayMenu();
                    break;

                case 2:
                    System.out.print("\nEnter item ID to add: ");
                    int itemIdToAdd = scanner.nextInt();
                    scanner.nextLine();
                    MenuItem itemToAdd = RestaurantInfo.getInstance().getRestaurant().getMenu().getItem(itemIdToAdd);
                    if (itemToAdd != null) {
                        currentOrder.addToCart(itemToAdd);
                        System.out.println("\nItem added to cart.");
                        System.out.println("---------------------------");
                    } else {
                        System.out.println("\nItem not found.");
                    }
                    break;

                case 3:
                    currentOrder.displayCart();
                    break;

                case 4:
                    orders.add(currentOrder);
                    RestaurantInfo.getInstance().getRestaurant().addOrder(currentOrder);
                    System.out.println("\nOrder finalized.");
                    System.out.println("---------------------------");
                    System.out.println("\nHere is your receipt for your Order:");
                    currentOrder.displayCart();
                    System.out.println("---------------------------");
                    System.out.println("Customer Name: " + getName());
                    System.out.println("Table Number: " + table);
                    System.out.println("Total Price: RM " + currentOrder.getTotalPrice());
                    System.out.println("===========================");

                    // Payment process
                    System.out.println("\nPayment Method:");
                    System.out.println("[1]   Cash");
                    System.out.println("[2]   Card");
                    System.out.print("Enter your choice: ");
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();

                    Payment payment = new Payment(paymentChoice, currentOrder);
                    payment.processPayment();

                    currentOrder = new Order(this);
                    break;

                case 5:
                    updateInformation();
                    break;

                case 6:
                    exit = true;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    public void updateInformation() {
        Scanner scanner = new Scanner(System.in);
        boolean exitUpdate = false;

        while (!exitUpdate) {
            System.out.println("\n\n\tUpdate Information:");
            System.out.println("---------------------------");
            System.out.println("[1]   Change Name");
            System.out.println("[2]   Change Table Number");
            System.out.println("[3]   Exit");
            System.out.println("---------------------------");
            System.out.print("\nEnter your choice: ");
            int updateChoice = scanner.nextInt();
            scanner.nextLine();

            switch (updateChoice) {
                case 1:
                    System.out.print("\nEnter new name: ");
                    String newName = scanner.nextLine();
                    setName(newName);
                    System.out.println("Name updated successfully.");
                    break;

                case 2:
                    System.out.print("\nEnter new table number: ");
                    int newTable = scanner.nextInt();
                    scanner.nextLine();
                    setTable(newTable);
                    System.out.println("Table number updated successfully.");
                    break;

                case 3:
                    exitUpdate = true;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    
    
//============================== Setter & Getter ==============================//
    
    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public int getPax() {
        return pax;
    }

    public void setPax(int pax) {
        this.pax = pax;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
