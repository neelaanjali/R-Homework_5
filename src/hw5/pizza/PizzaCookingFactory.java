package hw5.pizza;

import hw5.pizza.types.HawaiianPizza;
import hw5.pizza.types.MargheritaPizza;
import hw5.pizza.types.SupremePizza;
import hw5.pizza.types.VegetarianPizza;


/**
 * @author hargu
 */
public class PizzaCookingFactory {

	/**
	 *  This method will return a new, blank pizza with an initialized toppingList and a unique orderID.
	 *  If the method fails for some reason, it will return null
	 * @param pizzaType
	 * @return A new pizza of type pizzaType
	 * @author hargu
	 */
	public AbstractPizza createPizza(PizzaType pizzaType){
		
		switch(pizzaType) {
			case MARGHERITA:
				return new MargheritaPizza();
			case HAWAIIAN:
				return new HawaiianPizza();
			case SUPREME:
				return new SupremePizza();
			case VEGETARIAN:
				return new VegetarianPizza();
			default:
				return null;
		}
		
	}

}
