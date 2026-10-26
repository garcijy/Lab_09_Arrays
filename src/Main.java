import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //Part 1

        //step 1: declare an int array that holds 100 values
        int[] dataPoints = new int[100];

        //step 2: fill every spot in the array with a random number from 1 to 100
        for (int i = 0; i < dataPoints.length; i++)
        {
            dataPoints[i] = rand.nextInt(100);
        }

        //step 3: display all the values on one line, separated by '|'
        System.out.println("The values in dataPoints are:");
        for (int i = 0; i < dataPoints.length; i++)
        {
            System.out.print(dataPoints[i]);
            if (i < dataPoints.length - 1)
            {
                System.out.print(" | ");        // no bar after last value
            }

        }
        System.out.println();


        // step 4: add up all the values then find the average
        int sum = 0;
        for (int i = 0; i < dataPoints.length; i++)
            {
            sum += dataPoints[i];
            }


        // (double) keeps the decimals, otherwise int / int drops them
        double average = (double) sum / dataPoints.length;
        System.out.println("\nThe sum of the random array dataPoints is: " + sum);
        System.out.printf("The average of the random array dataPoints is %.2f%n", average);

        //Part 2

        //step 5: get a value from 1 to 100 from the user
        int userValue = SafeInput.getRangedInt(input, "Enter a value to search for", 1, 100);

        //step 6: count how many times the users value is in the array
        int count = 0;
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userValue)
                {
                count++;
                }
        }
        System.out.println("The value " + userValue + " was found " + count + " time(s) in dataPoints.");


        //step 7: ask again, then find the first spot where the value shows up
        userValue = SafeInput.getRangedInt(input, "Enter another value to search for", 1, 100);

        int foundIndex = -1;        //-1 means not found yet
        for (int i = 0; i < dataPoints.length; i++)
        {
            if (dataPoints[i] == userValue)
            {
                foundIndex = i;
                break;          //stop the loop as soon as we find it
            }
        }

        if (foundIndex != -1)
        {
            System.out.println("The value " + userValue + " was found at the array index " + foundIndex + ".");
        }
        else
        {
            System.out.println("The value " + userValue + " was not found in dataPoints.");
        }


        //step 8: find the smallest and largest values
        int min = dataPoints[0];        //start by assuming the first value is both
        int max = dataPoints[0];
        for (int i =1; i < dataPoints.length; i++)
        {
            if (dataPoints[i] < min)
            {
                min = dataPoints[i];        //found a new smallest value
            }
            if (dataPoints[i] > max)
            {
                max = dataPoints[i];        //founf a new largest value
            }
        }
        System.out.println("\nThe minimum value in dataPoints is: " + min);
        System.out.println("\nThe maximum value in dataPoints is: " + max);




    }
}