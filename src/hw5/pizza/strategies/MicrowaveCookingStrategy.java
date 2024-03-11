package hw5.pizza.strategies;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;

public class MicrowaveCookingStrategy implements ICookingStrategy  {

	@Override
	public boolean cook(AbstractPizza pizza) {
		pizza.setCookingPrice(1.0);
		pizza.setCookingStrategy(this);
		pizza.updatePizzaPrice();
		return true;
	}

}
