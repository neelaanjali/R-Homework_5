package hw5.pizza.types;

import java.util.ArrayList;

import hw5.pizza.AbstractPizza;
import hw5.pizza.Toppings;

/**
 * concrete class extended from AbstractPizza
 * @author hargu
 */
public class SupremePizza extends AbstractPizza {
	
	/**
	 * default constructor
	 * @author hargu
	 */
	public SupremePizza() {
		super();
		
		//add default toppings:
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.BELL_PEPPER);
		toppingList.add(Toppings.ITALIAN_SAUSAGE);
		toppingList.add(Toppings.PEPPERONI);
		toppingList.add(Toppings.BLACK_OLIVE);
		toppingList.add(Toppings.MUSHROOM);
		
		//set default price without toppings:
		this.priceWithoutToppings = 3.50;
	}
	
	/**
	 * get instance as a string
	 */
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Type:\t\t\tSupreme\n";
		pizzaStr += super.toString();
		
		return pizzaStr;
	}
	
	/**
	 * copy constructor
	 * @param oldPizza - the pizza to copy
	 */
	public SupremePizza(SupremePizza oldPizza) {
		toppingList = new ArrayList<Toppings>();
		toppingList = oldPizza.toppingList;
		priceWithoutToppings = oldPizza.priceWithoutToppings;
		totalPrice = oldPizza.totalPrice;
		pizzaOrderID = ++MargheritaPizza.orderIDCounter;
		cookingStrategy = oldPizza.cookingStrategy;
		cookingPrice = oldPizza.cookingPrice;
	}

	
}
