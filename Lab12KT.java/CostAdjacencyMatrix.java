import java.util.Scanner;
import java.io.File;  

class CostAdjacencyMatrix {
    public static void main(String[] args) {
        System.out.println("Welcome to the Adjacency Matrix Map Program");
        System.out.println("Author: Kola Taiwo ");
        System.out.println("Select an Option:");
        Scanner sc = new Scanner(System.in);   
        String input;
        String choice = "0";
        int read = 0;      
        String[] vertex = null;
        String[] rows= null;         
        int maxColumnWidth = 0; 
        printMenu();

        while(true) {            

            choice = sc.nextLine();
            switch(choice) {
                case "1" :
                try {

                    String filename;
                    System.out.println("Enter the name of the file: ");
                    filename = sc.nextLine();
                    File infile = new File(filename);
                    Scanner filereader = new Scanner(infile);     
                    String firstline = filereader.nextLine();    
                    vertex = firstline.split(", ", -1);        
                    for(String str : vertex) {
                        if(str.length() > maxColumnWidth)
                            maxColumnWidth = str.length();
                    }
                    rows = new String[vertex.length];            
                    int i = 0;
                    while(filereader.hasNextLine()) {
                        rows[i] = filereader.nextLine();
                        i++;
                    }
                    read = 0;      
                    System.out.println("File Entered successfully.");
                    filereader.close();
                } catch (Exception ex) {

                    System.out.println("ERROR: File Not Found.");
                    System.out.println(ex.getMessage());

                }
                break;

                case "2" :     

                if(read == 0) {

                    System.out.printf("%10s", "");
                    for(int i = 0; i < vertex.length; i++) {
                        System.out.printf("%10s", vertex[i]);
                    }
                    System.out.println("\n");
                    for(int i = 0; i < vertex.length; i++) {
                        String[] cost = rows[i].split(", ", -1);
                        System.out.printf("%10s", vertex[i]);
                        for(int j = 0; j < vertex.length; j++) {
                            System.out.printf("%10s", cost[j]);
                        }       
                        System.out.println();             
                    }

                }
                else {

                    System.out.println("Matrix Not [populated.");
                }
                break;

                case "3":
                System.out.print("Are you sure you want quit [Y/N]? ");
                input = sc.nextLine().trim().toUpperCase();
                if(input.charAt(0) == 'Y')
                {
                    System.out.println("Goodbye");
                    System.exit(0);
                }
                break;

                default:
                System.out.println("Invalid Choice");
                break;
            }

            printMenu();
        }
    }

    public  static void printMenu()
    {
        System.out.println("1. Populate the matrix");
        System.out.println("2. Print the matrix");
        System.out.println("3. Quit");
    }
}
