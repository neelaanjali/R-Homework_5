package hw5.pizza;

/**
 * Interface with a method to cook a pizza
 * @author riannaellis
 */

/**
 * Cooks a pizza using a cooking strategy
 * 
 * @param pizza The pizza that will be cooked
 * @return returns true if the pizza is cooked, returns false if there is an error
 * @author riannaellis
 */
public interface ICookingStrategy {

	public boolean cook(AbstractPizza pizza);
}
