import java.util.Scanner;

public class ListArrayBasedPlus extends ListArrayBased {

    public void add(int index, Object item) throws ListIndexOutOfBoundsException {
        if (numItems == items.length) {
            Object[] newitems = new Object[numItems * 2];
            for (int i = 0; i < numItems; i++) {
                newitems[i] = items[i];
            }
            items = newitems;
        } 
        try {
            super.add(index, item);
            System.out.println("Item " + item + " inserted in position" + index + " in the list.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("position specified is out of range.");
        }

    } 

    public void reverse() {
        int j = numItems-1;
        for (int i = 0; i < numItems/2; i++) {
            Object temp = items[i];
            items[i] = items[j];
            items[j] = temp;
            j--;
        }
    }

    public  String toString() {
        String s = "";
        for (int i = 0; i < numItems; i++) {
            s += items[i] + " ";
        }
        return s;
    }

      public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ListArrayBasedPlus list = new ListArrayBasedPlus();
        showMenu();
        int option = 1;
        while (option > 0) {
            System.out.println("Make your menu selection now: ");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("You are now inserting an item to the list:");
                    System.out.println("Enter item: ");
                    Object input = scan.next();
                    System.out.println("Enter position to insert item: ");
                    int position = scan.nextInt();
                    list.add(position, input);
                    break;
                case 2:
                    System.out.println("Enter position to remove item: ");
                    position = scan.nextInt();
                    try {
                        list.remove(position);
                        System.out.println("Item removed from position " + position + ".");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Position specified is out of range.");
                    }
                    break;
                case 3:
                    System.out.println("Enter position of item: ");
                    position = scan.nextInt();
                    try {
                        Object obj = list.get(position);
                        System.out.println("Item at position " + position + " is "+obj);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Position specified is out of range.");
                    }
                    break;
                case 4:
                    list.removeAll();
                    System.out.println("Removed all items from list.");
                    break; 
                case 5:
                    if (list.isEmpty()) {
                        System.out.println("List is empty.");
                    } else {
                        System.out.println("List of " + list.size() + " has the following items: " + list);
                    }
                    break;
                case 6:
                    list.reverse();
                    System.out.println("Reversed the list");
                    break;
            }
        }
    }

    private static void showMenu() {
        System.out.println("Select from the following menu:");
        System.out.println("0. Exit program");
        System.out.println("1. Insert item to list");
        System.out.println("2. Remove item from list");
        System.out.println("3. Get item from list");
        System.out.println("4. Clear list");
        System.out.println("5. Print size and content of list");
        System.out.println("6. Reverse list");
    }

}
