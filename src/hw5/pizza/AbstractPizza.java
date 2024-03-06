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
		
		pizzaStr = "Toppings:\t\t" + toppingList + "\n";
		pizzaStr += "Price without toppings:\t" + priceWithoutToppings + "\n";
		pizzaStr += "Total Price:\t\t" + totalPrice + "\n";
		pizzaStr += "Order ID:\t\t" + pizzaOrderID + "\n";
		pizzaStr += "Cooking strategy:\t" + cookingStrategy + "\n";
		pizzaStr += "Cooking price:\t\t" + cookingPrice + "\n";
		
		return pizzaStr;
		
	}
	
	//getters and setters
	//as of this version, all getters are public and all setters are protected
	//the access modifier is subject to change
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
	
	
	// Abstract methods to be implemented in subclasses:
	
	//This method calculates the total price of the pizza using priceWithoutToppings
	//and the prices of each topping in the toppingsList. 
	protected abstract double addToppingsToPrice(double priceWithoutToppings);
	
	//This method calculates and updates the totalPrice of the pizza using 
	//priceWithoutToppings attribute and the prices of each topping in toppingsList.
	public abstract double updatePizzaPrice();
		
}
