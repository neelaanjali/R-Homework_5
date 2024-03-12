package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

public class BrickOvenCookingStrategy implements ICookingStrategy {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(10.0); //Sets the cooking price to $10
		pizza.setCookingStrategy(this); //Sets the cooking strategy to BrickOvenCookingStrategy
		pizza.updatePizzaPrice(); //Updates the pizza price
		return true;
	}

}
