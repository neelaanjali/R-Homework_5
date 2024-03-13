package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;

/**
* @author riannaellis
*/

import hw5.pizza.ICookingStrategy;

public class BrickOvenCookingStrategy implements ICookingStrategy {

	/**
	 * Cooks a pizza using the brick oven cooking strategy; it sets the cooking price to $10, 
	 * sets the strategy to BrickOvenCookingStrategy, and updates the pizza price.
	 * 
	 * @param pizza The pizza that will be cooked.
	 * @return returns true once the fields are updated.
	 */
	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(10.0); //Sets the cooking price to $10
		pizza.setCookingStrategy(this); //Sets the cooking strategy to BrickOvenCookingStrategy
		pizza.updatePizzaPrice(); //Updates the pizza price
		return true;
	}
	
	@Override
	public String toString() { return "Brick Oven"; }

}
