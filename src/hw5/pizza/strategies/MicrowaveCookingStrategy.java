package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

/**
* @author riannaellis
*/

public class MicrowaveCookingStrategy implements ICookingStrategy  {

	/**
	 * Cooks a pizza using the microwave cooking strategy; it sets the cooking price to $1, 
	 * sets the strategy MicrowaveCookingStrategy, and updates the pizza price.
	 * 
	 * @param pizza The pizza that will be cooked.
	 * @return returns true once the fields are updated.
	 */
	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(1.0); //Sets the cooking price to $1.00
		pizza.setCookingStrategy(this); //Sets the cooking strategy to MicrowaveCookingStrategy
		pizza.updatePizzaPrice(); //Updates the pizza price
		
		return true;
	}
	
	@Override
	public String toString() { return "Microwave"; }

}
