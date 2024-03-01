package hw5.pizza;

import java.util.List;

/**
 * @author hargu
 */
public abstract class AbstractPizza {
	
	protected List<Toppings> toppingList;
	protected double priceWithoutToppings;
	protected double totalPrice;
	protected int pizzaOrderID;
	protected static int orderIDCoutner;
	protected double cookingPrice;
	
	/**
	 * TODO: ICookingStrategy needs to be implemented, then this attribute will be added.
	 */
	//protected ICookingStrategy cookingStrategy;
		
}
