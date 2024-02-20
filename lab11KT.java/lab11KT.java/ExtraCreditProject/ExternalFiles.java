import java.io.*;
import java.util.*;

class  ExternalFiles{
    public static void main(String args[])
    {
        String choice = "0";
        String input;
        Scanner sc= new Scanner(System.in);
        Stack<String> stack= new Stack<String>();
        System.out.println("Welcome to the External Files Lab");
        System.out.println("Author: kola taiwo");
        System.out.println("Select an option from the list:");
        PrintMenu();

        while(true)
        {
            choice = sc.nextLine().trim();
            switch (choice)
            {
                case "1":
                try  
                {  
                    System.out.print("\nEnter the file name: ");  
                    String fileName = sc.nextLine();             
                    File file = new File(fileName);
                    if (file.createNewFile())
                        System.out.println(fileName+" is added.");
                    else 
                        System.out.println("\n"+fileName+" is not added, already exists.");
                }  
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  
                break;
                case "2":
                try
                {
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();               
                    File file = new File(fileName);
                    if(file.exists())
                    {
                        PrintWriter writer = new PrintWriter(fileName);
                        writer.print("");
                        writer.close();
                        System.out.println(fileName+" file exists and data is cleared.");
                    }
                    else
                        System.out.println(fileName + "file does not exist.");
                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  
                break;

                case "3":

                try
                {
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();               
                    File file = new File(fileName);

                    if(file.exists())
                    {
                        FileWriter myFileWrite = new FileWriter(fileName, true);
                        BufferedWriter writer = new BufferedWriter(myFileWrite);        
                        int count = 0;
                        while(true)
                        {
                            System.out.println("Enter a line to append ('enter' to stop): ");  
                            String line = sc.nextLine();  

                            if(line.equals(""))
                            {
                                System.out.println("\n[enter key is pressed]");
                                System.out.println("\n"+count+" new line(s) appended");
                                writer.close();
                                break;
                            }
                            writer.write(line+'\n');
                            count++;
                        }
                    }
                    else
                        System.out.println("\n"+fileName+" file does not exist.");
                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());       
                }  
                break;

                case "4":

                try
                {
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();              
                    File file = new File(fileName);

                    if(file.exists())
                    {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));  
                        String line;
                        while ((line = reader.readLine()) != null)
                            System.out.println(line);
                        reader.close();
                    }
                    else
                        System.out.println(fileName+" file does not exist.");
                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  

                break;
                case "5":

                try
                {
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();               

                    File file = new File(fileName);

                    if(file.exists())
                    {
                        BufferedReader reader = new BufferedReader(new FileReader(fileName));
                        String line;
                        int f = 1;
                        while ((line = reader.readLine()) != null) 
                        {

                            if(line.contains("//"))
                                continue;

                            if(f == 1)
                                System.out.println("The contents are: ");
                            System.out.println(line);
                        }
                        reader.close();
                    }
                    else
                        System.out.println(fileName+" file does not exist.");
                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  
                break;

                case "6":
                try
                {
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();   
                    Scanner file = new Scanner(new File(fileName));
                    String strings = file.nextLine();
                    String[] array = strings.split(" ");

                    for(int i = array.length-1; i >= 0; i--){
                        stack.push(array[i]);
                    }

                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  
                break;

                case "7":
                try{
                    System.out.println("Enter the file name: ");  
                    String fileName = sc.nextLine();                                

                    Scanner file = new Scanner(new File(fileName));
                    String strings = file.nextLine();

                    String[] array = strings.split(" ");

                    for (int i = stack.size()- 1; i >= 2; i--){
                        System.out.print(stack.pop() + "->");
                    }
                    System.out.println(stack.pop());
                }
                catch(Exception ex)  
                {  
                    System.out.println("Something went wrong");
                    System.out.println(ex.getMessage());         
                }  
                break;

                case "Q":
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
            PrintMenu();
        }
    }

    public static void PrintMenu()
    {
        System.out.println("1. Create a new external file."); 
        System.out.println("2. Open an existing external file and clear the data."); 
        System.out.println("3. Append an item to an existing file"); 
        System.out.println("4 Print contents of file.");
        System.out.println("5. Print the contents (minus comments) of an external file.");
        System.out.println("6. Insert the contents to a stack");
        System.out.println("7. pop/print the stack");
        System.out.println("Q. Quit.");

    }
}
