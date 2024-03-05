package hw5.pizza.types;

import java.util.ArrayList;

import hw5.pizza.AbstractPizza;
import hw5.pizza.Toppings;

public class MargheritaPizza extends AbstractPizza {

	//default constructor
	public MargheritaPizza() {
		super();
	}
	
	
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Type:\tMargherita\n";
		pizzaStr += super.toString();
		
		return pizzaStr;
	}


	//copy constructor
	public MargheritaPizza(MargheritaPizza oldPizza) {
		toppingList = new ArrayList<Toppings>();
		toppingList = oldPizza.toppingList;
		priceWithoutToppings = oldPizza.priceWithoutToppings;
		totalPrice = oldPizza.totalPrice;
		pizzaOrderID = ++MargheritaPizza.orderIDCounter;
		cookingStrategy = oldPizza.cookingStrategy;
		cookingPrice = oldPizza.cookingPrice;
	}
	
	
}
