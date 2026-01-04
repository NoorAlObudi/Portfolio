import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {

        // declare variables
        Scanner input = new Scanner(System.in);
        double monthlyAllowance = 0;
        double totalSpending = 0;
        boolean isRunning = true;
        int choice;

        // store all expenses
        ArrayList<Expense> expenses = new ArrayList<>();

        // display menu
        while (isRunning) {
            System.out.println("---------------------------------------");
            System.out.println("Monthly Expense Tracker");
            System.out.println("---------------------------------------");
            System.out.println("1. Add monthly allowance");
            System.out.println("2. Add expenses");
            System.out.println("3. View total spending");
            System.out.println("4. View allowance left");
            System.out.println("5. View highest expense");
            System.out.println("6. Exit");
            System.out.println("---------------------------------------");

            System.out.print("Enter your choice (1-6): ");
            choice = input.nextInt();
            input.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    System.out.print("Enter your monthly allowance: ");
                    monthlyAllowance = input.nextDouble();
                    input.nextLine(); // clear newline
                    System.out.println("Monthly allowance set to: £" + monthlyAllowance);
                    break;

                case 2:
                    // add expenses using Expense class
                    ArrayList<Expense> newExpenses = Expense.addExpenses(input);
                    expenses.addAll(newExpenses);
                    System.out.println(newExpenses.size() + " expense(s) added.");
                    break;

                case 3:
                    // calculate total spending
                    totalSpending = 0;
                    for (Expense e : expenses) {
                        totalSpending += e.getFinalAmount();
                    }
                    System.out.println("Total spending: £" + totalSpending);
                    break;

                case 4:
                    // show allowance left
                    totalSpending = 0;
                    for (Expense e : expenses) {
                        totalSpending += e.getFinalAmount();
                    }
                    double allowanceLeft = monthlyAllowance - totalSpending;
                    System.out.println("Allowance left: £" + allowanceLeft);
                    break;

                case 5:
                    // find highest expense
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        Expense highest = expenses.get(0);
                        for (Expense e : expenses) {
                            if (e.getFinalAmount() > highest.getFinalAmount()) {
                                highest = e;
                            }
                        }
                        System.out.println("Highest expense: " + highest.getTitle() +
                                " (£" + highest.getFinalAmount() + ")");
                    }
                    break;

                case 6:
                    isRunning = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }

        input.close();
    }
}