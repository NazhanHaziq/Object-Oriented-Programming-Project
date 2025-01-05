
package westernrestaurantmain;

/**
 *
 * @author nazhan
 */

public class MenuItem {
    private static int nextId = 1;
    private int itemID;
    private String itemName;
    private double itemPrice;
    private String itemDetails;

    public MenuItem(String itemName, double itemPrice, String itemDetails) {
        this.itemID = nextId++;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDetails = itemDetails;
    }
    
    
    
//============================== Setter & Getter ==============================//

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }
    
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(String itemDetails) {
        this.itemDetails = itemDetails;
    }
}