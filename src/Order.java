/**
 * 
 */

/**
 * @author Akhil
 *
 */
public class Order {
	private String state;
    private int orderNumber;

    public Order(String state, int orderNumber) {
        this.state = state;
        this.orderNumber = orderNumber;
    }

    public Order(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

}
