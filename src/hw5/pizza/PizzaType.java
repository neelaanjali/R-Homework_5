package hw5.pizza;

/**
 * @author hargu
 */
public enum PizzaType {
	HAWAIIAN(3.00),
	MARGHERITA(2.50),
	SUPREME(3.50),
	VEGETARIAN(1.50);
	
	private double toppingPrice;
	
	public double getToppingPrice() {
		return toppingPrice;
	}
	
	PizzaType(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
}
