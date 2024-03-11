import java.util.List;

import hw5.pizza.AbstractPizza;
import hw5.pizza.ICookingStrategy;
import hw5.pizza.PizzaCookingFactory;

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
	        for (AbstractPizza pizza : pizzaOrderList) {
	            if (pizza.getPizzaOrderID() == orderID) {
	                return pizza;
	            }
	        }
	        return null;
	    }
	    
	    public void printListOfToppingsByPizzaOrderID(int orderID) {
	        AbstractPizza pizza = getPizzaByOrderID(orderID);
	        if (pizza != null) {
	            System.out.println("Here are the toppings for this Pizza Order ID! " + orderID + ": " + pizza.getToppingList());
	        } else {
	            System.out.println("Sorry pizza Order ID " + orderID + " not found.");
	        }
	    }

 }

