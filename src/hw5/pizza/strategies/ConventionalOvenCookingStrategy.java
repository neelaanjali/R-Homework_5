package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

/**
* @author riannaellis
*/

public class ConventionalOvenCookingStrategy implements ICookingStrategy  {

	/**
	 * Cooks a pizza using the conventional oven cooking strategy; it sets the cooking price to $8, 
	 * sets the strategy to ConventionalOvenCookingStrategy, and updates the pizza price.
	 * 
	 * @param pizza The pizza that will be cooked.
	 * @return returns true once the fields are updated.
	 */
	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(8.0); //Sets the cooking price to $8.00
		pizza.setCookingStrategy(this); //Sets the cooking strategy to ConventionalOvenCookingStrategy
		pizza.setTotalPrice(pizza.getTotalPrice() + pizza.getCookingPrice()); //Updates the pizza price
		
		return true;
	}
	
	@Override
	public String toString() { return "Conventional Oven"; }

}
