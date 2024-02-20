import java.util.Scanner;
import java.util.Random;

public class Driver
{
    public static void main(String[] args) {
        main s = new main();
        Scanner sc = new Scanner(System.in);
        String input;
        while(true) {
            System.out.println("Welcome to the Sorting and searching system");
            System.out.println("Author: kola taiwo");
            System.out.println("Select an Option:");
            System.out.println("1. Create an array of random elements from 100 to 999");
            System.out.println("2.Search for an element using linear search ");
            System.out.println("3. Search for an element using binary search");
            System.out.println("4. Sort the array using selection sort");
            System.out.println("5. sort the array using Insertion sort");
            System.out.println("6. Sort the array using Bubble sort");
            System.out.println("7. Sort the array using Bubble sort with short-circuit");
            System.out.println("8. sort the array using merge sort");
            System.out.println("9. Sort the array using lucky sort");
            System.out.println("10. reset the array");
            System.out.println("11. print the array");
            System.out.println("Quit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                {
                    Random random = new Random();

                    int[] numbers = new int[20];
                    for(int i = 0; i < 20; i++ ){

                        numbers[i] = random.nextInt(900) + 100;
                    }
                    
                }
                break;
            

            case 2:
            {
           s.linear();
        }
        System.out.println();
            
            break;


           
            case 3:
            {
            	   int l = 0, r = arr.length - 1;
                   while (l <= r) {
                       int m = l + (r - l) / 2;

                       if (arr[m] == x) {
                           return m;
                       } else if (arr[m] < x) {
                           l = m + 1;
                       } else {
                           r = m - 1;
                       }
                   }
                   return -1;
               }

            break;
            
            case 4:

            break;
            case 5:

            break;
            case 6:

            break;
            case 7:
            break;

            case 8:
            break;

            case 9:
            break;

            case 10:
            break;

            case 11:
            break;

        }
    }
}
}
