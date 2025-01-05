
package westernrestaurantmain;

/**
 *
 * @author nazhan
 */

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String menuName;
    private List<MenuItem> items;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.items = new ArrayList<>();
    }
    
    
    
//================================== Methods ==================================//
    
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(int itemId) {
        items.removeIf(item -> item.getItemID() == itemId);
        System.out.println("Item removed.");
    }

    public void updateItem(int itemId, String newItemName, double newItemPrice, String newItemDetails) {
        for (MenuItem item : items) {
            if (item.getItemID() == itemId) {
                item.setItemName(newItemName);
                item.setItemPrice(newItemPrice);
                item.setItemDetails(newItemDetails);
                System.out.println("Item updated: " + item.getItemName());
                return;
            }
        }
    }

    public MenuItem getItem(int itemId) {
        for (MenuItem item : items) {
            if (item.getItemID() == itemId) {
                return item;
            }
        }
        return null;
    }

    public void displayMenu() {
        System.out.println("\n==============================");
        System.out.println("Menu: " + menuName);
        System.out.println("------------------------------");
        for (MenuItem item : items) {
            System.out.println("[" + item.getItemID() + "]  " + item.getItemName() + "  - RM " + item.getItemPrice());
            System.out.println("\tDetails: " + item.getItemDetails());
            System.out.println();
        }
    }
    
    
    
//============================== Setter & Getter ==============================//

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public void setItems(List<MenuItem> items) {
        this.items = items;
    }
    
}
