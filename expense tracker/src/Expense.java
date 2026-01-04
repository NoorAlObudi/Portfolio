import java.util.ArrayList;
import java.util.Scanner;

public class Expense {

    private String title;
    private float finalAmount;

    // lets the user enter one or many expenses, creates Expense objects, and returns them in a list
    public static ArrayList<Expense> addExpenses(Scanner input) {

        System.out.print("How many expenses would you like to add? ");
        int number = input.nextInt();
        input.nextLine();

        ArrayList<Expense> expenses = new ArrayList<>(); // store expenses here

        for (int i = 0; i < number; i++) {   // loop through expenses amount to create them;
            System.out.println("/nExpense " + (i + 1) + ":");

            Expense expense = new Expense();  // create expense object (new expense card to fill out)


            System.out.print("Enter expense title: ");
            expense.title = input.nextLine();


            System.out.print("Enter expense amount: ");
            float amount = input.nextFloat();
            input.nextLine();


            System.out.print("Did you get any discount? Yes or No: ");
            String discount = input.nextLine();

            if (discount.equalsIgnoreCase("Yes")) {
                System.out.print("Enter discount percent: ");
                float percent = input.nextFloat();
                input.nextLine();
                expense.finalAmount = amount * (1 - percent / 100); // calculate discount
            } else if (discount.equalsIgnoreCase("No")) {
                expense.finalAmount = amount; // no discount
            }

            expenses.add(expense); // add the created expense to the array
        }

        return expenses;
    }

    public String getTitle() {
        return title;
    }

    public float getFinalAmount() {
        return finalAmount;
    }
}
