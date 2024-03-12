package hw5.pizza.types;

import java.util.ArrayList;

import hw5.pizza.AbstractPizza;
import hw5.pizza.Toppings;

/**
 * Concrete class which extends AbsractPizza
 * @author hargu
 */
public class HawaiianPizza extends AbstractPizza {

	/**
	 * Default constructor
	 * @author hargu
	 */
	public HawaiianPizza() {
		super();
		
		//add default toppings:
		toppingList.add(Toppings.CANADIAN_BACON);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.PINEAPPLE);
		
		//set default price without toppings:
		this.priceWithoutToppings = 3.00;
	}
	
	/**
	 * get instance as a string
	 * @author hargu
	 */
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Type:\t\t\tHawaiian\n";
		pizzaStr += super.toString();
		
		return pizzaStr;
	}
	
	/**
	 * Copy constructor
	 * @param oldPizza - the pizza to be copied
	 * @author hargu
	 */
	public HawaiianPizza(HawaiianPizza oldPizza) {
		toppingList = new ArrayList<Toppings>();
		toppingList = oldPizza.toppingList;
		priceWithoutToppings = oldPizza.priceWithoutToppings;
		totalPrice = oldPizza.totalPrice;
		pizzaOrderID = ++MargheritaPizza.orderIDCounter;
		cookingStrategy = oldPizza.cookingStrategy;
		cookingPrice = oldPizza.cookingPrice;
	}
	
	
}
