package hw5.pizza;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class AbstractPizza, the super class of different pizza types.
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
	
	/**
	 * Default constructor
	 * @author hargu
	 */
	protected AbstractPizza() {
		toppingList = new ArrayList<Toppings>();
		pizzaOrderID = ++AbstractPizza.orderIDCounter;
	}
	
	/**
	 * toString method which will be used by the subclasses
	 * @author hargu
	 */
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Toppings:\t\t" + toppingList + "\n";
		pizzaStr += "Price without toppings:\t" + priceWithoutToppings + "\n";
		pizzaStr += "Total Price:\t\t" + totalPrice + "\n";
		pizzaStr += "Order ID:\t\t" + pizzaOrderID + "\n";
		pizzaStr += "Cooking strategy:\t" + cookingStrategy + "\n";
		pizzaStr += "Cooking price:\t\t" + cookingPrice + "\n";
		
		return pizzaStr;
		
	}
	
	//getters and setters

	public List<Toppings> getToppingList() {
		return toppingList;
	}

	public void setToppingList(List<Toppings> toppingList) {
		this.toppingList = toppingList;
	}

	public double getPriceWithoutToppings() {
		return priceWithoutToppings;
	}

	public void setPriceWithoutToppings(double priceWithoutToppings) {
		this.priceWithoutToppings = priceWithoutToppings;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getPizzaOrderID() {
		return pizzaOrderID;
	}

	public void setPizzaOrderID(int pizzaOrderID) {
		this.pizzaOrderID = pizzaOrderID;
	}

	public ICookingStrategy getCookingStrategy() {
		return cookingStrategy;
	}

	public void setCookingStrategy(ICookingStrategy cookingStrategy) {
		this.cookingStrategy = cookingStrategy;
	}

	public double getCookingPrice() {
		return cookingPrice;
	}

	public void setCookingPrice(double cookingPrice) {
		this.cookingPrice = cookingPrice;
	}

	public static int getOrderIDCounter() {
		return orderIDCounter;
	}
	
	
	// Methods to be inherited by subclasses (no need to override):
	
	//This method calculates the total price of the pizza using priceWithoutToppings
	//and the prices of each topping in the toppingsList. 
	public double addToppingsToPrice(double priceWithoutToppings) {
		//first get total price of all toppings:
		double toppingsPrice = 0.0;
		for (Toppings topping : toppingList) {
			toppingsPrice += topping.getToppingPrice();
		}
		
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = this.priceWithoutToppings + toppingsPrice;
		return this.totalPrice;
	}
	
	//This method calculates and updates the totalPrice of the pizza using the
	//priceWithoutToppings attribute and the price of each topping in toppingsList.
	public double updatePizzaPrice() {
		return addToppingsToPrice(priceWithoutToppings);
	}
	
}
