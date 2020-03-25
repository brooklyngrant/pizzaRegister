import java.text.NumberFormat;
import java.util.Scanner;

/**
 * This is a program to create a screen which will allow the user to order up to two pizzas. They 
 * can pick things such as their number of pizzas, pizza size, number of toppings, shape, and crust.
 * @author Brooklyn Grant
 *
 */

public class PizzaRegister {

	public static void main(String[] args) {
		// Declare Varibles
		
		Scanner scan = new Scanner(System.in);
		NumberFormat numfmt = NumberFormat.getCurrencyInstance();
		String custName;
		int pizzaAmount;
		double total = 0;
		String pizzaOrder1 = "";
		String pizzaOrder2 = "";
		
		//welcome and enter name
		
		System.out.print("Welcome to Pizza! Before we start, please enter your name: ");
		custName = scan.nextLine();
		
		//amount of pizzas
		
		System.out.print("Okay " + custName + " how many pizzas do you want? ");
		pizzaAmount = scan.nextInt();
		while (pizzaAmount > 2 || pizzaAmount <= 0) {			//if user enters too high or low of an amount
			System.out.print("Please try again! The max is 2 and the mimimum is 0. ");	
			pizzaAmount = scan.nextInt();
		}
		
		// for loop for however many pizzas the user wants
		
		for (int i = 0; i < pizzaAmount; i++) {
			
			//declare varibles for each pizza
			String size = " ";
			int topAmount = -1;
			String shape = " ";
			String crust = " ";
			
			//pizza number
			System.out.println("Pizza #" + (i + 1));
			
			//large, med, small option
			System.out.print("Do you want a large, medium, or small? ");
			size = scan.nextLine();
			while (!(size.equals("large") || size.equals("medium") || size.equals("small"))) {
				System.out.print("Please type in either large, medium, or small. ");
				size = scan.nextLine();
				if (size.equals("large")) {
					total += 15.95;
				} else if (size.equals("medium")) {
					total += 12.95;
				} else if (size.equals("small")) {
					total += 10.95;
				}
			}
			
			//topping amount
			
			System.out.print("It costs $1.25 for each topping, how many do you want? ");
			
			while (!(topAmount >= 0)) { //if topping is less than 0
				topAmount = scan.nextInt();
			}
			total += (topAmount * 1.25);
			
			// shape of pizza
			while (!(shape.equals("round") || shape.equals("square"))) {
				System.out.print("Do you want it to be round or square? ");
				shape = scan.nextLine();
			}
			
			//Crust size
			
			while (!(crust.equals("thick") || crust.equals("thin"))) {
				System.out.print("Do you want it to be thick or thin? ");
				crust = scan.nextLine();
			}
			
			//pizza order gets put into a string
			
			if (i == 0) {
				pizzaOrder1 += "For pizza " + (i + 1) + ", you ordered a " + topAmount + "-topped, " + size + ", " + shape + ", " + crust + "-crusted pizza. ";
		
			} else if (i == 1) {
				pizzaOrder2 += "For pizza " + (i + 1) + ", you ordered a " + topAmount + "-topped, " + size + ", " + crust + "-crusted pizza. ";
		
			}
			
		}
		
		System.out.println(" ");
		System.out.println("Thank you " + custName + " for ordering at Pizza!");
		System.out.println(pizzaOrder1 + pizzaOrder2);
		System.out.println("Your total is " + numfmt.format(total));
		
		
		scan.close();
	}

}
