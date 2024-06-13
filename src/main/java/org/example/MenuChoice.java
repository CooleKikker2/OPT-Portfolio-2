package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuChoice {
    public static void showChoices(ArrayList<String> choices)
    {
        int index = 1;
        for(String choice : choices)
        {
            System.out.printf("%d: %s\n", index, choice);
            index++;
        }
    }

    public String waitForStringAnswer(Scanner scanner) {
        return scanner.nextLine();
    }

    public static int waitForIntAnswer(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Please enter a valid integer:");
            scanner.next(); // Clear invalid input
        }
        int result = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        return result;
    }
}
