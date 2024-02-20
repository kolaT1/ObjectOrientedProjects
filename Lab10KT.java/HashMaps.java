public class HashMaps
{
    public static void main(String... args)
    {
        String key;
        String value; 
        String choice="0";
        String input;
        HashMap<String, String> hm = new HashMap<>();
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to the Hash Map program");
        System.out.println("Author : Kola taiwo");
        System.out.println("Select an option");
        printMenu();
        while(true)
        {

            choice = sc.nextLine();
            switch(choice)
            {
                case "1":
                System.out.print("Enter a key : "); 
                key = sc.nextLine();
                System.out.print("Enter a value : "); 
                value = sc.nextLine();        

                hm.put(key,value);
                System.out.println("key/value "+key+"/"+value+" entered in the Hash Map.");
                break;
                case "2":
                System.out.print("Enter a key : "); 
                key = sc.nextLine();                
                if(hm.containsKey(key))
                {
                    System.out.print("Enter a value : "); 
                    value = sc.nextLine();
                    hm.put(key,value);
                    System.out.println("key/value "+key+"/"+value+"  entered in the Hash Map.");
                }
                else
                    System.out.println("Key "+key+" is not found in the Hash Map.");
                break;
                case "3":
                System.out.print("Enter a key : "); 
                key = sc.nextLine();  
                input = sc.nextLine().trim().toUpperCase();
                if(hm.containsKey(key))
                {
                    value = hm.get(key);
                    System.out.print("Are you sure you want to delete "+key+"/"+value+" [Y/N]");
                    char sure = sc.next().charAt(0);
                    if(input.charAt(0) == 'Y')
                    {
                        System.out.println( key+"/"+value+" is deleted from hash map.");
                        hm.remove(key);
                        break;
                    }
                    else if(input.charAt(0) != 'Y')
                    {
                        System.out.println("1");
                        break;
                    }
                }
                else
                {
                    System.out.println("Key" + key+ " not found in the Hash Map.");
                    break; 
                }
                break;
                case "4":

                System.out.print("Enter a value : "); 
                value = sc.nextLine();                
                if(hm.containsValue(value))
                {
                    System.out.println(value+" is a valid hashmap value.");
                }
                else
                {
                    System.out.println(value+" is NOT a valid hashmap value.");
                }
                break; 
                case "5":
                System.out.print("HashMap : ");
                for (Map.Entry<String, String> set : hm.entrySet()) 
                {
                    System.out.println(set.getKey() + "/" + set.getValue()+"\t");
                }

                break;
                case "6":
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

    public static  void printMenu()
    {
        System.out.println("1. Add a key/value pair."); 
        System.out.println("2. Change a key/value pair."); 
        System.out.println("3. Delete a key/value pair."); 
        System.out.println("4. Find a value in hashmap.");
        System.out.println("5. Print the HashMap"); 
        System.out.println("6. Quit.");            
        System.out.println("Enter your choice: "); 
    }
}