import java.util.Scanner;

public class Lab05PriorityQueueGJS
{

	
	public static void main(String[] args)
	{
		PriorityQueueGJS<String> pq = new PriorityQueueGJS<String>();
		String choice = "0"; 
		String val;
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Welcome to the Priority Queue Menu System");
		System.out.println("Author: Leonard Pinth Garnell");
		System.out.println("Select an Option:\n");
		
		PrintMenu();
		 
		while(true)
		{
		System.out.print("Enter your choice : ");
		choice = scn.nextLine();
		choice = choice.trim();
		
			switch (choice)
			{
			case "1":
				System.out.print("Enter a string to add: ");
				val = scn.nextLine();
				pq.push(val);
				System.out.println("'" + val + "' added to the priority queue\n");
				break;
			case "2":
				if(pq.isEmpty())
					System.out.println("Nothing to see here: the priority queue is empty\n");
				else
					System.out.println("At the front of the priority queue: " + pq.peek() + "\n");
				break;
			case "3":
				if(pq.isEmpty())
					System.out.println("Nothing to pop: the priority queue is empty\n");
				else
				{
					pq.pop();
					System.out.println("Element popped from the priority queue\n");
				}
				break;		
			case "4":
				val = "The priority queue is " + (!pq.isEmpty() ? "not " : "") + "empty\n";
				System.out.println(val);
				break;
			case "5":
				System.out.println("Priority Queue size: " + pq.size() + "\n");
				break;	
			case "6":
				if(pq.isEmpty())
				{
					System.out.println("Nothing to print: the priority queue is empty\n");
				}
				else
				{
					pq.print();
					System.out.println("\n");
				}
				break;	
			case "7":
				System.out.print("Are you sure you want quit [Y/N]? ");
				choice = scn.nextLine().trim().toUpperCase();
				if(choice.charAt(0) == 'Y')
				{
					System.out.println("Goodbye");
					scn.close();
					System.exit(0);
				}
				break;			
			default:
				System.out.println("Invalid Choice");
				break;				
			}
			PrintMenu();
		}

	} // end of psvm
	
	public static void PrintMenu()
	{
		System.out.println("1. Push an element on the priority queue");
		System.out.println("2. Peek at an element on the priority queue");
		System.out.println("3. Pop an element from the priority queue");
		System.out.println("4. Check if the priority queue is empty");
		System.out.println("5. Get the size of the priority queue");
		System.out.println("6. Print the contents of the priority queue");
		System.out.println("7. Quit\n");
	}
	
}	// end of class