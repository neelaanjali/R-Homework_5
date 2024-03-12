import java.util.List;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;
import hw5.pizza.PizzaCookingFactory;
import hw5.pizza.PizzaType;
import hw5.pizza.Toppings;

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
	    
	    public boolean isThereAnyUncookedPizza() {
	    	for (AbstractPizza pizza : pizzaOrderList) {
	    		if(pizza.getCookingStrategy() == null) {
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    public double checkout() throws Exception{
	    	boolean uncookedPizzas = isThereAnyUncookedPizza();
	    	double totalPrice = 0;
	    	if (uncookedPizzas == true) {
	    		throw new Exception("At least one pizza is uncooked. Please assign a cooking strategy to each pizza");
	    	}else {
	    		for (AbstractPizza pizza : pizzaOrderList) {
	    			totalPrice += pizza.getTotalPrice();
	    		}
	    	}
	    	return totalPrice;
	    }

 }

