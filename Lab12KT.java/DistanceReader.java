import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DistanceReader {
	public static void main(String[] args) {
		
		// reading file name
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter file name: ");
		String fname = sc.nextLine();
		
		// opening file to read
		Scanner file = null;
		try {
			file = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		
		// reading the header names
		String names_arr[] = file.nextLine().split(", ");
		
		int n = names_arr.length;
		
		// creating array to store the numbers
		int distances[][] = new int[n][n];
		
		// reading the numbers
		int i = 0;
		while (file.hasNextLine()) {
			String arr[] = file.nextLine().split("[\\s,]+");

			for (int j = 0; j < n; j++) {
				distances[i][j] = Integer.parseInt(arr[j]);
			}
			i++;
		}
		
		// printing the table
		System.out.print("\t\t");
		for (i = 0; i < n; i++) {
			System.out.print(names_arr[i]+"    ");
		}
		System.out.println();

		for (i = 0; i < n; i++) {
			System.out.printf("%-16s",names_arr[i]);

			for (int j = 0; j < n; j++) {
				int l = names_arr[j].length();
				
				System.out.printf("%" + l + "d    ", distances[i][j]);
			}
			System.out.println();
		}
	}
}
