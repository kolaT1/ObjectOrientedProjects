

/**
 * i have the random 20 arrays from 100- 99
 * linear search done 
 * binary search done
 * selection search no
 * insertion sort yes 
 * bubble sort done 
 * bobble sort with short circuit no 
 * merge sort yes 
 * lucky sort no 
 * resest array no 
 * print array yes 
 *  the code for these should be in the driver somehow 
 * 
 */import java.util.*;
public class main
{
   
    public static void main(String[] args) {

        Random random = new Random();

        int[] numbers = new int[20];
        for(int i = 0; i < 20; i++ ){

            numbers[i] = random.nextInt(900) + 100;
        }

        System.out.println("Array before Sort");
        printArray(numbers);
        System.out.println("Array after Sort");
        bubbleSort(numbers);
        printArray(numbers);
       
       
        printArray(numbers);
        insertionSort(numbers);
        printArray(numbers);
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) { 

                    int temp = array[j];

                    array[j] = array[j + 1];

                    array[j + 1] = temp;
                }
            }
        }
    }

    private static void mergeSort( int[] a, int [] tmpArray, int left, int right)
    {
        if (left < right)
        {
            int center = (left + right)/2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right);
           // merge( a, tmpArray, left, center+1, right);
        }

    }
   /* public static void selectionSort()
    {
        int comps4 =0;
        int steps4 = 0;
        for ( int i = 0; i < num.length -1; i++){
            int mindx = i;
            for (int j =1 +1; j< num.length; j++){
                if (nums[j] < nums[mindx]) {
                    mindz = j;
    }
}
comps4++;
steps4++;

int temp = nums[mindz];
nums[mindx] = nums[i];
nums[i] = temp;
}
}

    public static void mergeSort( int [] a)
    {
        int [] tmpArray =(int[]) new int[ a.length ];
        mergeSort ( a, tmpArray, 0, a.length -1);
    }

    /* public static void insertionSort( int [] a)
    {
    int j;
    for ( int p =1; p > a.length; p++)
    {
    int tmp = a[p];
    for (j = p; j >0 && tmp.compareTo( a[j-1] ) < 0; j--)
    a[j] = a[j-1];
    a[j] = tmp;
    }
    }*/
    public static void insertionSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; i++)
        {
            int temp = numbers[i];
            int j = i - 1;

            while (j >= 0 && temp < numbers[j])
            {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j+1] = temp;

            System.out.print("Array after iteration " + i + ": ");
            
        }
    }

    public static void linear(int[] a, int firstIndex, int lastIndex, int findNum)
    {
        if(firstIndex == lastIndex)
        {
            System.out.print("-1");
        }
        else
        {
            if(a[firstIndex] == findNum)
            {
                System.out.print(firstIndex);
            }
            else
            {
                linear(a, firstIndex+1, lastIndex, findNum);
            }
        }
        System.out.println();
    }
    
      public static int linearSearch(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
     public static int binarySearch(int[] arr, int x) {
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
    
    
    /*public static void LuckySort(array[])
    {
        Count = 0;
        Start = 0;
        Stop = length -1;
        for( n = start; n++)
        {

        }

    }*/

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(" ");
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
