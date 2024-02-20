import java.util.Random;
import java.util.Scanner;

public class Driver
{
    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);
    static sortAndSearch s = new sortAndSearch();

    public static void main(String[] args) {
        int [] arr = new int[20];
        int [] backuparr = new int[20];
        while(true) {
            System.out.println("\nWelcome to the Sorting and searching system");
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
            System.out.println("12. Quit");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                for(int i=0;i<20;i++){

                    int randNum = rand.nextInt(890) + 100;

                    arr[i] = randNum;
                    backuparr[i] = randNum;
                }

                break;

                case 2:
                System.out.println("Enter a number to search");
                int k = sc.nextInt();
                  s.linearSearch(arr,k);
                 
                break;
                case 3:
                int kb = sc.nextInt();
                if (!s.isSorted(arr))
                {
                        System.out.println("Array must be sorted to search");
                }
                else 
                if(s.isSorted(arr))
                {
                    s.binarySearch(arr,kb);
                    
                }
                System.out.println(kb);
                

             
                break;
                case 4:
                s.selectionSort(arr, arr[arr.length -1]);

                break;
                case 5:
                s.insertionSort(arr); 

                break;

                case 6:

                s.bubbleSort(arr);
                s.printArray(arr);
                break;
                case 7:
                s.BubbleSortShortSC(arr);
                s.printArray(arr);

                break;
                case 8:
               
                break;

                case 9:
                s.LuckySort(arr);
                break;

                case 10:
                s.resetArray(arr,backuparr);
                s.printArray(arr);
                break;

                case 11:
                s.printArray(arr);
                break;
                case 12:
                return;

            }
        }

    }
}