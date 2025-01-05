
package westernrestaurantmain;

/**
 *
 * @author nazhan
 */

import java.util.ArrayList;
import java.util.List;

public class Management {
    private String restaurantName;
    private String location;
    private Menu menu;
    private List<Staff> staffList;
    private List<Order> orders;

    public Management(String restaurantName, String location) {
        this.restaurantName = restaurantName;
        this.location = location;
        this.menu = new Menu("Western Delight");
        this.staffList = new ArrayList<>();
        this.orders = new ArrayList<>();
        
        menu.addItem(new MenuItem("Chicken Chop", 8.0, "Grilled boneless chicken breast with flavorful sauce and sides like mashed potatoes, coleslaw, and steamed vegetables."));
        menu.addItem(new MenuItem("Lamb Chop", 15.0, "Tender seasoned lamb, grilled or pan-seared, served with mint sauce."));
        menu.addItem(new MenuItem("Chicken Grill", 12.0, "Marinated bone-in chicken, grilled until they’re juicy and smoky. Serve with a side salad or roasted potatoes."));
        menu.addItem(new MenuItem("Fish and Chips", 10.0, "Battered fish fillets served with thick-cut fries – a British favorite."));
        menu.addItem(new MenuItem("Cheese Burger", 7.0, "Juicy beef patty topped with melted cheese, lettuce, tomato, and condiments, all sandwiched in a soft bun."));
        menu.addItem(new MenuItem("Spaghetti Carbonara", 10.0, "Pasta tossed with crispy chicken, eggs, Parmesan, and black pepper – a creamy delight."));
        menu.addItem(new MenuItem("Lasagna", 10.0, "Layers of pasta, rich meat sauce, creamy béchamel, and melted cheese."));
        menu.addItem(new MenuItem("Caesar Salad", 5.0, "Fresh romaine lettuce, croutons, Parmesan cheese, and Caesar dressing – a classic choice."));
        menu.addItem(new MenuItem("Wedges", 5.0, "Thick-cut potato wedges seasoned with herbs and spices, served with dipping sauces."));
        menu.addItem(new MenuItem("Fries", 5.0, "Crispy, golden potato fries, perfect as a side or snack."));
    }
    
    
    
//================================== Methods ==================================//
    
    public void hireStaff(Staff staff) {
        staffList.add(staff);
    }

    public void fireStaff(Staff staff) {
        staffList.remove(staff);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void displayOrders() {
        System.out.println("\nOrders:");
        for (Order order : orders) {
            System.out.println("Order ID: " + order.getOrderID() + "  |  Status: " + order.getStatus());
        }
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        for (Order order : orders) {
            if (order.getOrderID() == orderId) {
                order.setStatus(newStatus);
                System.out.println("\nOrder ID: " + orderId + "\nStatus updated to " + newStatus);
                return;
            }
        }
        System.out.println("\nOrder not found.");
    }
    
    
    
//============================== Setter & Getter ==============================//

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
