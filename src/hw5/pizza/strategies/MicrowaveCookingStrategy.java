package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

public class MicrowaveCookingStrategy implements ICookingStrategy  {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(1.0); //Sets the cooking price to $1.00
		pizza.setCookingStrategy(this); //Sets the cooking strategy to MicrowaveCookingStrategy
		pizza.updatePizzaPrice(); //Updates the pizza price
		
		return true;
	}

}
