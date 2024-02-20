import java.util.Random;

// MakeArray class
public class MakeArray{
    
    // declare two arrays
    
    // arr is used to store the actual array elements
    int []arr = new int[10];
    
    // backup_arr is used to store the backup array elements
    int []backup_arr = new int[10];
    
    // default constructor
    MakeArray(){
        
        // create an object of the Random class
        Random rand = new Random();
        
        for(int i=0;i<10;i++){
            // generate a random number between 10 to 99
            int rand_num = rand.nextInt((99 - 10) + 1) + 10;
            
            // add the random number in arr as well as in backup_arr
            arr[i] = rand_num;
            backup_arr[i] = rand_num;
        }
    }
    
    // sortArray method
    // sorts the original array elements in ascending order using bubble sort
    public void sortArray(){
        for(int i=0;i<arr.length-1;i++)
        {
            // declare array_sorted variable to true
            boolean array_sorted = true;
            for(int j=0;j<arr.length-i-1;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    
                    // array is not sorted yet
                    array_sorted = false;
                }
            }
            
            // break the loop is array is sorted
            if (array_sorted)
            	break;
        }
    }
    
    // resetArray method
    public void resetArray(){
        for(int i=0;i<arr.length;i++){
            // append the backup_arr element in the arr index
            arr[i] = backup_arr[i];
        }
    }
    
    // printArray method
    public void printArray(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}