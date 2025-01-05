
package westernrestaurantmain;

import java.util.Scanner;

/**
 *
 * @author Ahmad Nazhan Haziq bin Ahmad Fuad (CA21060)
 */

public class WesternRestaurantMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        User staff = new Staff("staff", "staff2024", "Alice", 5000.00, "Manager", RestaurantInfo.getInstance().getRestaurant());

        // Add staff to restaurant
        RestaurantInfo.getInstance().getRestaurant().hireStaff((Staff) staff);

        
        
//============================= Main Menu Display =============================//
        
        while (!exit) {
            System.out.println("\n\n==================================================");
            System.out.println("||     Welcome to the UMPSA Western Delight     ||");
            System.out.println("==================================================");
            System.out.println("\nLogin Menu:");
            System.out.println("----------------------------");
            System.out.println("[1]  Staff Login");
            System.out.println("[2]  Customer Login");
            System.out.println("[3]  Exit");
            System.out.print("\nPlease enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nEnter username: ");
                    String staffUsername = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String staffPassword = scanner.nextLine();

                    if (staff.getUsername().equals(staffUsername) && staff.validatePassword(staffPassword)) {
                        staff.displayOptions();
                    } else {
                        System.out.println("\nInvalid credentials. Please try again.");
                    }
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter table number: ");
                    int tableNumber = scanner.nextInt();
                    scanner.nextLine();
                    User customer = new Customer("customer", "password", customerName, tableNumber, 4);
                    customer.displayOptions();
                    break;

                case 3:
                    System.out.println("\nThank you for using our System!\n\n");
                    exit = true;
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}
