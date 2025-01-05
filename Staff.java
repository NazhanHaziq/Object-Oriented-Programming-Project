
package westernrestaurantmain;

import java.util.Scanner;

/**
 *
 * @author nazhan
 */


public class Staff extends User implements MenuOperations {
    private double salary;
    private String job;
    private Management restaurant;

    public Staff(String username, String password, String name, double salary, String job, Management restaurant) {
        super(username, password, name);
        this.salary = salary;
        this.job = job;
        this.restaurant = restaurant;
    }

    
    
//================================== Methods ==================================//
    
    @Override
    public void displayOptions() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n\nStaff Menu:");
            System.out.println("--------------------");
            System.out.println("[1]  View Menu");
            System.out.println("[2]  Add Menu Item");
            System.out.println("[3]  Update Menu Item");
            System.out.println("[4]  Delete Menu Item");
            System.out.println("[5]  View Orders");
            System.out.println("[6]  Update Order Status");
            System.out.println("[7]  Log out");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewMenu();
                    break;
                    
                case 2:
                    addMenuItem();
                    break;
                    
                case 3:
                    updateMenuItem();
                    break;
                    
                case 4:
                    deleteMenuItem();
                    break;
                    
                case 5:
                    restaurant.displayOrders();
                    break;
                    
                case 6:
                    System.out.print("\nEnter order ID to update: ");
                    int orderIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter new order status: ");
                    String newOrderStatus = scanner.nextLine();
                    
                    restaurant.updateOrderStatus(orderIdToUpdate, newOrderStatus);
                    break;
                    
                case 7:
                    exit = true;
                    break;
                    
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
    
    @Override
    public void viewMenu() {
        restaurant.getMenu().displayMenu();
    }
    
    @Override
    public void addMenuItem() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter item name: ");
        String itemName = scanner.nextLine();
        
        System.out.print("Enter item price: ");
        double itemPrice = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter item details: ");
        String itemDetails = scanner.nextLine();
        
        restaurant.getMenu().addItem(new MenuItem(itemName, itemPrice, itemDetails));
    }
    
    @Override
    public void updateMenuItem() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter item ID to update: ");
        int itemIdToUpdate = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("\nEnter new item name: ");
        String newItemName = scanner.nextLine();
        
        System.out.print("Enter new item price: ");
        double newItemPrice = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Enter new item details: ");
        String newItemDetails = scanner.nextLine();
        
        restaurant.getMenu().updateItem(itemIdToUpdate, newItemName, newItemPrice, newItemDetails);
    }
    
    @Override
    public void deleteMenuItem() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nEnter item ID to delete: ");
        int itemIdToDelete = scanner.nextInt();
        scanner.nextLine();
        
        restaurant.getMenu().removeItem(itemIdToDelete);
    }

    
    
//============================== Setter & Getter ==============================//
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Management getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Management restaurant) {
        this.restaurant = restaurant;
    }
    
}