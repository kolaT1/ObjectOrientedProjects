import java.util.Scanner;

public class ItemMenu {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ItemList itemList = new ItemList();

        int choice;

        do
        {
            printMenu();
            choice = Integer.parseInt(sc.nextLine().trim());

            switch(choice)
            {
                case 1:
                {
                    itemList.addItem();
                    break;
                }

                case 2:
                {
                    itemList.removeItem();
                    break;
                }

                case 3:
                {
                    itemList.getItem();
                    break;
                }

                case 4:
                {
                    itemList.clearList();
                    break;
                }

                case 5:
                {
                    itemList.printItemList();
                    break;
                }
                case 6:
                {
                    // itemList.deleteSmallAndLarge();
                    break;
                }
                case 7:
                {
                    itemList.reverseList();
                    break;
                }

                case 0:
                {
                    System.exit(0);
                }

                default:
                System.out.println("\nIncorrect menu option!\n");
            }

        }while(choice != 0);
    }

    private static void printMenu()
    {
        System.out.print(
            "Select from the following menu:\n"
            +"0. Exit.\n"
            + "1. Insert item into the list..\n"
            + "2. Remove item from the list.\n"
            + "3. Get item from the list..\n"
            + "4. Clear the list.\n"
            + "5. Display size and content of the list.\n"
            + "6. Delete the smallest and largest item in the list.\n"
            + "7. Reverse the list.\n"
            + "Make your menu selection now: ");
    }
}