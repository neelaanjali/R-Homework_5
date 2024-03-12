package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

public class ConventionalOvenCookingStrategy implements ICookingStrategy  {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(8.0); //Sets the cooking price to $8.00
		pizza.setCookingStrategy(this); //Sets the cooking strategy to ConventionalOvenCookingStrategy
		pizza.updatePizzaPrice(); //Updates the pizza price
		
		return true;
	}

}
