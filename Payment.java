
package westernrestaurantmain;

import java.util.Scanner;

/**
 *
 * @author nazhan
 */

public class Payment {
    private int paymentType;
    private Order order;

    public Payment(int paymentType, Order order) {
        this.paymentType = paymentType;
        this.order = order;
    }

    
    
//================================== Methods ==================================//
    
    public void processPayment() {
        Scanner scanner = new Scanner(System.in);

        if (paymentType == 1) {
            System.out.println("\nPayment processed successfully for order ID: " + order.getOrderID());
            System.out.println("Please pay at the counter.");
        } else if (paymentType == 2) {
            System.out.print("Enter card number: ");
            String cardNumber = scanner.nextLine();

            System.out.print("Enter card expiration date (MM/YY): ");
            String cardExpiry = scanner.nextLine();

            System.out.print("Enter card CVC: ");
            String cardCVC = scanner.nextLine();

            if (validateCardDetails(cardNumber, cardExpiry, cardCVC)) {
                System.out.println("\nPayment processed successfully for order ID: " + order.getOrderID());
            } else {
                System.out.println("\nInvalid card details. Please try again.");
            }
        }
    }

    public boolean validateCardDetails(String cardNumber, String cardExpiry, String cardCVC) {
        return !cardNumber.isEmpty() && !cardExpiry.isEmpty() && !cardCVC.isEmpty();
    }

    
    
//============================== Setter & Getter ==============================//
    
    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
