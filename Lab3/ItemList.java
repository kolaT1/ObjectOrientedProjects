import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class ItemList {
    private ArrayList<Item> itemList;

    public ItemList()
    {
        this.itemList = new ArrayList<>();
    }

    public void addItem()
    {
        System.out.println("You are now adding a new item to your ItemList.\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name of the item");
        String name = sc.nextLine().trim();

        // search for the day and the task name
        boolean found = false;
        for(Item i : itemList)
        {
            if(name.equalsIgnoreCase(i.getName()))
            {
                found = true;
                break;
            }
        }
        if(found)
            System.out.println("A similar item found\n");
        else
        {

            itemList.add(new Item(name));
            System.out.println(name + " is successfully added.\n");
        }
    }

  
    public void removeItem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter item name: ");
        String name = sc.nextLine().trim();

        // search for the task name
        ArrayList<Item> item = new ArrayList<>();

        for(int i = 0; i < itemList.size(); i++)
        {
            if(name.equalsIgnoreCase(itemList.get(i).getName()))
            {
                item.add(itemList.get(i));
            }
        }

        if(item.isEmpty())
            System.out.println("\nNo such task found on any day!\n");
        else
        {
            int count = item.size();
            for(Item i : item)
            {
                itemList.remove(item);
            }
            System.out.println("\nTotal " + count + " such items were found and deleted successfully!\n");
        }
    }

    public void printItemList()
    {
        if(itemList.isEmpty())
            System.out.println("\nSorry, the list is empty. Please add some items to the list!\n");
        else
        {
            for(Item item : itemList)
            {
                System.out.println(item.toString());
            }
            System.out.println();
        }
    }

    public void getItem()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter item name: ");
        String name = sc.nextLine().trim();

        ArrayList<Item> item = new ArrayList<>();

        for(int i = 0; i < itemList.size(); i++)
        {
            if(name.equalsIgnoreCase(itemList.get(i).getName()))
            {
                item.add(itemList.get(i));
            }
        }

        if(item.isEmpty())
            System.out.println("\nNo such item found on any day!\n");
        else {

            System.out.println(item);
        }
    }

    public void clearList() {

    }

    public void deleteSandL() {

    }
    public void reverseList() {
    }
    public class FindSmallAndLarge
    {
        private void findSmallAndLarge(ArrayList<Item> items, int[] index) {
            if (items.size() > 0) {
                String small = items.get(0).getName();
                String large = items.get(0).getName();

                for (int i = 1; i < items.size(); i++) {
                    String temp = items.get(i).getName();
                    if (temp.compareTo(small) < 0) {
                        small = temp;
                        index[0] = i;
                    }

                    if (temp.compareTo(large) > 0) {
                        large = temp;
                        index[1] = i;
                    }

                }
            }
        }

        public void deleteSmallAndLarge() {
            int[] array = { -1, -1 };
            findSmallAndLarge(itemList, array);
            String small = itemList.get(array[0]).getName();
            String large = itemList.get(array[1]).getName();
            if (array[0] < array[1]) {
                itemList.remove(array[0]);
                itemList.remove(array[1] - 1);
            } else if (array[0] > array[1]) {
                itemList.remove(array[0]);
                itemList.remove(array[1]);
            } else {
                itemList.remove(array[0]);
            }
            System.out.println("smallest item " + small + " and largest item " + large + "deleted.");
        }

        public void reverseList() {
            Collections.reverse(itemList);
            System.out.println("List has been reversed.");
            System.out.print(" Here is the content: ");
            if (itemList.isEmpty())
                System.out.println("The list is empty");
            else {
                for (Item item : itemList) {
                    System.out.print(item.getName() + " ");
                }
                System.out.println();
            }

        }
    }

}

