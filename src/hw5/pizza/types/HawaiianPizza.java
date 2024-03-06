package hw5.pizza.types;

import java.util.ArrayList;

import hw5.pizza.AbstractPizza;
import hw5.pizza.Toppings;

public class HawaiianPizza extends AbstractPizza {

	//default constructor
	public HawaiianPizza() {
		super();
		
		//add default toppings:
		toppingList.add(Toppings.CANADIAN_BACON);
		toppingList.add(Toppings.CHEESE);
		toppingList.add(Toppings.PINEAPPLE);
		
		//set default price without toppings:
		this.priceWithoutToppings = 3.00;
	}
	
	@Override
	public String toString() {
		String pizzaStr;
		
		pizzaStr = "Type:\t\t\tHawaiian\n";
		pizzaStr += super.toString();
		
		return pizzaStr;
	}
	
	//copy constructor
	public HawaiianPizza(HawaiianPizza oldPizza) {
		toppingList = new ArrayList<Toppings>();
		toppingList = oldPizza.toppingList;
		priceWithoutToppings = oldPizza.priceWithoutToppings;
		totalPrice = oldPizza.totalPrice;
		pizzaOrderID = ++MargheritaPizza.orderIDCounter;
		cookingStrategy = oldPizza.cookingStrategy;
		cookingPrice = oldPizza.cookingPrice;
	}
	
	//Abstract method implementations:
	//The details of these two methods are described in detail in the AbstractPizza class
	@Override 
	protected double addToppingsToPrice(double priceWithoutToppings) {
		//first get total price of all toppings:
		double toppingsPrice = 0.0;
		for (Toppings topping : toppingList) {
			toppingsPrice += topping.getToppingPrice();
		}
		
		this.priceWithoutToppings = priceWithoutToppings;
		this.totalPrice = this.priceWithoutToppings + toppingsPrice;
		return this.totalPrice;
	}
	
	@Override
	public double updatePizzaPrice() {
		return addToppingsToPrice(priceWithoutToppings);
	}
		
}
