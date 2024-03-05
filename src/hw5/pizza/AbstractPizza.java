package hw5.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hargu
 */
public abstract class AbstractPizza {
	
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCounter = 0;
	protected ICookingStrategy cookingStrategy;
	protected double cookingPrice;
	
	//default constructor
	protected AbstractPizza() {
		toppingList = new ArrayList<Toppings>();
		pizzaOrderID = ++AbstractPizza.orderIDCounter;
	}
	
	//toString method which will be used by the subclasses
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Toppings:\n" + toppingList + "\n";
		pizzaStr += "Price without toppings:\t" + priceWithoutToppings + "\n";
		pizzaStr += "Total Price:\t" + totalPrice + "\n";
		pizzaStr += "Order ID\t" + pizzaOrderID + "\n";
		pizzaStr += "Cooking strategy:\t" + cookingStrategy.toString() + "\n";
		pizzaStr += "Cooking price:\t" + cookingPrice + "\n";
		
		return pizzaStr;
		
	}

	
	//getters and setters
	//as of this version, all getters are public and all setters are protected
	//the access modifier is subject to change
	public List<Toppings> getToppingList() {
		return toppingList;
	}

	protected void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}

	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}

	protected void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	protected void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPizzaOrderID() {
		return pizzaOrderID;
	}

	protected void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}

	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	protected void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}

	public double getCookingPrice() {
		return cookingPrice;
	}

	protected void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}

	public static int getOrderIDCounter() {
		return orderIDCounter;
	}
	
	
		
}
