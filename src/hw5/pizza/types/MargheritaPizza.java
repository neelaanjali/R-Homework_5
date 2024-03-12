package hw5.pizza.types;

import java.util.ArrayList;

import hw5.pizza.AbstractPizza;
import hw5.pizza.Toppings;

/**
 * concrete class that extends AbstractPizza
 * @author hargu
 */
public class MargheritaPizza extends AbstractPizza {

	/**
	 * Default constructor
	 * @author hargu
	 */
	public MargheritaPizza() {
		super();
		
		//add default toppings:
		toppingList.add(Toppings.TOMATO);
		toppingList.add(Toppings.CHEESE);
		
		//set default price without toppings:
		this.priceWithoutToppings = 2.50;
	}
	
	/**
	 * get instance as a string
	 * @author hargu
	 */
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Type:\t\t\tMargherita\n";
		pizzaStr += super.toString();
		
		return pizzaStr;
	}


	/**
	 * copy constructor
	 * @param oldPizza - the pizza to copy
	 */
	public MargheritaPizza(MargheritaPizza oldPizza) {
		toppingList = new ArrayList<Toppings>();
		toppingList = oldPizza.toppingList;
		priceWithoutToppings = oldPizza.priceWithoutToppings;
		totalPrice = oldPizza.totalPrice;
		pizzaOrderID = ++MargheritaPizza.orderIDCounter;
		cookingStrategy = oldPizza.cookingStrategy;
		cookingPrice = oldPizza.cookingPrice;
	}
	
	
}
