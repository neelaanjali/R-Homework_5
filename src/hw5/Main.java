package hw5;

import hw5.pizza.PizzaOrder;
import hw5.pizza.PizzaType;
import hw5.pizza.Toppings;
import hw5.pizza.strategies.BrickOvenCookingStrategy;
import hw5.pizza.AbstractPizza;
import hw5.pizza.CookingStyleType;
import hw5.pizza.types.HawaiianPizza;

public class Main {

	/**
	 * @author riannaellis
	 */
	
	public static void main(String[] args) {

	    PizzaOrder order = new PizzaOrder(); //Instantiate a new pizzaOrder
	   
	    order.addPizzaToCart(PizzaType.HAWAIIAN); //Add a new HAWAIIAN pizza to the cart
	    order.selectCookingStrategyByPizzaOrderID(1, CookingStyleType.MICROWAVE); //Set the cooking strategy
	    
	    order.addPizzaToCart(PizzaType.MARGHERITA); //Add a new MARGERITA pizza to the cart
	    order.selectCookingStrategyByPizzaOrderID(2, CookingStyleType.CONVENTIONAL_OVEN); //Set the cooking strategy
	    
	    order.addPizzaToCart(PizzaType.SUPREME); //Add a new SUPREME pizza to the cart
	    order.selectCookingStrategyByPizzaOrderID(3, CookingStyleType.BRICK_OVEN); //Set the cooking strategy
	    
	    order.addPizzaToCart(PizzaType.VEGETARIAN); //Add a new VEGETARIAN pizza to the cart
	    order.selectCookingStrategyByPizzaOrderID(4, CookingStyleType.MICROWAVE); //Set the cooking strategy
	    
	    order.addNewToppingToPizza(1, Toppings.ITALIAN_SAUSAGE); //Add a topping to the Hawaiian pizza
	    order.printListOfToppingsByPizzaOrderID(1); //Print the list of toppings
	    order.printPizzaOrderCart(1); //Print the cart to see the updated price
	    
	    order.removeToppingFromPizza(1, Toppings.ITALIAN_SAUSAGE); //Remove the topping from the Hawaiin pizza
	    order.printListOfToppingsByPizzaOrderID(1); //Print the list of toppings
	    order.printPizzaOrderCart(1); //Print the cart to see the updated price
	    
	    
	    int counter = 1;
	    while(counter <= 4) {
	    	order.printPizzaOrderCart(counter);
	    	order.printListOfToppingsByPizzaOrderID(counter);
	    	counter++;
	    }
	    
	    try {
			System.out.println("Total Price: $" + order.checkout()); //Tries to check out
		} catch (Exception e) {
			e.printStackTrace(); //Catches the exception if there is an uncooked pizza
		}
	    
	    
	 
	    

	    // Adds pizzas to the cart, selects cooking strategies for the pizzas in the cart, 
	    //prints pizza order cart. Calls checkout to calculate the bill, 
	    //throws exception if triggered.

	}

}
