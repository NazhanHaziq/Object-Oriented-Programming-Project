
package westernrestaurantmain;

/**
 *
 * @author nazhan
 */

public abstract class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
    
    

//================================== Methods ==================================//
    
    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
    
    public abstract void displayOptions();
    
    public void updateAccount(String name) {
        this.name = name;
    }
    
    
    
//============================== Setter & Getter ==============================//
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}