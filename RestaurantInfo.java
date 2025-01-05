
package westernrestaurantmain;

/**
 *
 * @author nazhan
 */

public class RestaurantInfo {
    private static RestaurantInfo instance;
    private Management restaurant;

    private RestaurantInfo() {
        restaurant = new Management("UMPSA Western Delight", "UMPSA");
    }

    public static RestaurantInfo getInstance() {
        if (instance == null) {
            instance = new RestaurantInfo();
        }
        return instance;
    }
    
    

//============================== Setter & Getter ==============================//

    public Management getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Management restaurant) {
        this.restaurant = restaurant;
    }
}