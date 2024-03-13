package hw5.pizza;
import java.util.List;

import hw5.pizza.strategies.BrickOvenCookingStrategy;
import hw5.pizza.strategies.ConventionalOvenCookingStrategy;
import hw5.pizza.strategies.MicrowaveCookingStrategy;
import hw5.pizza.types.HawaiianPizza;
import hw5.pizza.types.MargheritaPizza;
import hw5.pizza.types.SupremePizza;
import hw5.pizza.types.VegetarianPizza;

import java.util.ArrayList;

public class PizzaOrder {
	   private PizzaCookingFactory pizzaFactory;
	    private ICookingStrategy cookingStrategy;
	    private List<AbstractPizza> pizzaOrderList;
	    
	    public PizzaOrder() {
	        this.pizzaFactory = new PizzaCookingFactory();
	        this.pizzaOrderList = new ArrayList<>();
	    }
	    
	    
	    public AbstractPizza getPizzaByOrderID(int orderID) {
	        for (AbstractPizza pizza : pizzaOrderList) {  // goes through through each pizza order in the pizzaOrderList
	            if (pizza.getPizzaOrderID() == orderID) {  // If the matching order is not found then return null
	                return pizza;
	            }
	        }
	        return null;
	    }
	    
	    public void printListOfToppingsByPizzaOrderID(int orderID) {
	        AbstractPizza pizza = getPizzaByOrderID(orderID);  //gets pizza order with the associated orderID
	        if (pizza != null) { //checks if the pizza order exits 
	            System.out.println("Here are the toppings for this Pizza Order ID! " + orderID + ": " + pizza.getToppingList());
	        } else { //prints the toppings's of the pizza but if it doesn't exist then prints out error message
	            System.out.println("Sorry pizza Order ID " + orderID + " not found.");
	        }
	    }
	    
	    public void printPizzaOrderCart(int orderID) {
	        AbstractPizza pizza = getPizzaByOrderID(orderID); //gets pizza order with the associated orderID
	        if (pizza != null) {//checks if the pizza order exits 
	            System.out.println("The Pizza Order Cart for Order ID " + orderID + ":\n" + pizza);
	        } else {  //if not prints error message
	            System.out.println("Sorry Pizza Order ID " + orderID + " not found.");
	        }
	    }
	    
	    public boolean addPizzaToCart(PizzaType pizzaType) {
	        AbstractPizza pizza = pizzaFactory.createPizza(pizzaType); // This creates a new pizza instance using the pizzaFactory and the specified pizzaType
	        if (pizza != null) {
	            pizzaOrderList.add(pizza); // This adds the created pizza to the pizzaOrderList 
	            return true;
	        }
	        return false;  //if the pizza could not be created or added to the cart
	    }
	    
	    public boolean addNewToppingToPizza(int orderID, Toppings topping) {
	        AbstractPizza pizza = getPizzaByOrderID(orderID); //gets pizza order with the associated orderID
	        if (pizza != null && !pizza.getToppingList().contains(topping)) {
	            pizza.getToppingList().add(topping); //adds toppings's
	            pizza.updatePizzaPrice(); //updates the prices
	            return true;
	        }
	        return false;  // If the toppings's already exists in the toppings's list of the pizza, it returns false. 
	    }
     //^^ all true for remove toppings's expect opposite actions done
	    
	    public boolean removeToppingFromPizza(int orderID, Toppings topping) {
	        AbstractPizza pizza = getPizzaByOrderID(orderID);
	        if (pizza != null && pizza.getToppingList().contains(topping)) {
	            pizza.getToppingList().remove(topping);
	            pizza.updatePizzaPrice();
	            return true;
	        }
	        return false;
	    }
	    
		/**
		 * Checks the cooking strategy of each pizza in pizzaOrderList to see if there exists a pizza 
		 * without an assigned cooking strategy.
		 * 
		 * @return returns true if there is a pizza without a cooking strategy, returns false if all pizzas have a cooking strategy
		 * @author riannaellis
		 */
	    public boolean isThereAnyUncookedPizza() {
	    	for (AbstractPizza pizza : pizzaOrderList) { //Iterates through each pizza in the list
	    		if(pizza.getCookingStrategy() == null) { //Checks to see if there is a pizza that does not have a cooking strategy
	    			return true; //Returns true if a pizza does not have a cooking strategy
	    		}
	    	}
	    	return false; //Returns false if all pizzas have a cooking strategy
	    }
	    
		/**
		 * Checks if there are any uncooked pizzas. If all pizzas are cooked, it calculates the total price of 
		 * all pizzas in the pizzaOrderList. If at least one pizza is uncooked, it throws an exception.
		 * 
		 * @return totalPrice of all pizzas in pizzaOrderList
		 * @throws Exception if there is an uncooked pizza in pizzaOrderList 
		 * @author riannaellis
		 */
	    public double checkout() throws Exception{
	    	boolean uncookedPizzas = isThereAnyUncookedPizza(); //Calls isThereAnyUncookedPizza
	    	double totalPrice = 0; //Initializes the total price
	    	
	    	if (uncookedPizzas == true) { //Throws an exception if there is an uncooked pizza
	    		throw new Exception("At least one pizza is uncooked. Please assign a cooking strategy to each pizza");
	    	}else {
	    		for (AbstractPizza pizza : pizzaOrderList) { //Executes if all pizzas are cooked
	    			totalPrice += pizza.getTotalPrice(); //Adds the price of each pizza to the total price
	    		}
	    	}
	    	return totalPrice; //Returns the total price for all pizzas in the order list
	    }
	    
		/**
		 * Gets the pizza at the given orderID, instantiates the cookingStrategy, and cooks the pizza.
		 * 
		 * @param orderID The order ID of a pizza
		 * @param cookingStrategyType The cooking style type that will be used to cook the pizza
		 * @return true if the pizza is successfully cooked, false if an error occurs
		 * @author riannaellis
		 */
	    public boolean selectCookigStrategyByPizzaOrderID(int orderID, CookingStyleType cookingStrategyType) {
	    	AbstractPizza pizza = getPizzaByOrderID(orderID); //Calls getPizzaByOrderID to find the instance of the pizza with that ID
	    	
	    	if(pizza == null) {
	    		return false; //Returns false if a pizza with that order ID does not exist
	    	}

	    	//Switch case based on the CookingStyleType
	    	switch(cookingStrategyType) {
			case MICROWAVE:
				MicrowaveCookingStrategy microwave = new MicrowaveCookingStrategy(); //Creates a new microwave instance
				pizza.setCookingStrategy(microwave); //Sets the pizza's cooking strategy to microwave
				return microwave.cook(pizza); //Returns true/false if it successfully cooks the pizza
			case CONVENTIONAL_OVEN:
				ConventionalOvenCookingStrategy conventionalOven = new ConventionalOvenCookingStrategy(); //Creates a new conventional oven instance
				pizza.setCookingStrategy(conventionalOven); //Sets the pizza's cooking strategy to conventional oven
				return conventionalOven.cook(pizza); //Returns true/false if it successfully cooks the pizza
			case BRICK_OVEN:
				BrickOvenCookingStrategy brickOven = new BrickOvenCookingStrategy(); //Creates a new brick oven instance
				pizza.setCookingStrategy(brickOven); //Sets the pizza's cooking strategy to brick oven
				return brickOven.cook(pizza); //Returns true/false if it successfully cooks the pizza
			default:
				return false; //Returns false if none of the cases match
		}
		
	    	
	    }

 }

