// Juleeyah Wright
// Summer 2019
// I say I never have the time to budget. It may be that I`m lazy, but ironically I coded up this budget
// calculator to track my spendings. Hold your applause as I bow. Thank you  _   _  _____
//                                                                        / ||  || 
//                                                                        --| -- |
//                                                                          ------
//                                                                         /__    \

import java.io.*;
import java.util.*;

public class BudgetCalc
{
    private HashSet<String> budget;
    private int thisMonthsTotal = 0;
    private String[] danero;

    public String getBudget(String filename) throws IOException
    {
       Scanner input = new Scanner(new File(filename)); 
       budget = new HashSet<String>();
       int total = input.nextInt();

        while (input.hasNext())
        {
            String next = input.nextLine();
            if (next.contains("$"))
            {
                danero = next.split(" ");
                budget.add(danero[0]);
                thisMonthsTotal += Integer.parseInt(danero[0].substring(1));
            }
        }

        input.close();

        System.out.println("\n**************************************\n           BUDGET CALCULATOR\n**************************************\n");
        return "You will spend $" + thisMonthsTotal + " this month + have " + (total - thisMonthsTotal) + " left :)\n***************************************************";
    }

    public static void main(String[] args) throws IOException
    {
        BudgetCalc budget = new BudgetCalc();

        System.out.println(budget.getBudget("MonthlyBudget.txt"));
    }
}

