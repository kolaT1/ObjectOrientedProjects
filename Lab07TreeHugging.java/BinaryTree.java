import java.util.Scanner;
public class BinaryTree{
    static Node root;

    
    public static void main(String[] args) {

        char choice = 'a';
        Scanner sc = new Scanner(System.in);
        BinaryTree btt = new BinaryTree();
           /* btt.add(19);
            btt.add(20);
            btt.add(1);
            btt.add(15);
            btt.add(16);
            btt.add(21);
            btt.add(17);
            btt.add(18);
            //btt.add(51);
            //btt.add(52);*/
        while(true){
            System.out.println("\nSelect an option from the menu:\n");
            System.out.println("1.Add an item to the tree");
            System.out.println("2.Find an item on the tree");
            System.out.println("3.Remove an item from the tree");
            System.out.println("4.Count the nodes on the tree");
            System.out.println("5.Compute the tree height");
            System.out.println("6.Find the largest element on the tree");
            System.out.println("7.Find the sum of elements");
            System.out.println("8.Find the average of elements");
            System.out.println("9.Find if one element is ancestor of another");
            System.out.println("A. print the tree(Pre-Order)");
            System.out.println("B. print the tree(Post-Order)");
            System.out.println("C. print the tree(In-Order)");
            System.out.println("Q.Quit\n");
            choice = sc.next().charAt(0);
          

            switch(choice){
                case'1':
                System.out.print("Enter a value: ");
                int value = sc.nextInt();

                btt.add(value);
                System.out.println("Node "+value+" is added successfully.");
                break;
                case'2':

                System.out.print(" Enter node to be searched: ");
                int val = sc.nextInt();
                boolean found = find(root,val);
                if(found)
                {
                    System.out.println( val+ " is on the tree ");
                }
                else 
                {
                    System.out.print(val +" is not on the tree ");
                }

                break;
                case'3':
                System.out.println("Enter an item you would like to remove from the list");
                int rem = sc.nextInt();
                delete(root,rem);
                System.out.println(rem+ " has been deleted from the tree");
   
                break;
                case'4':
                System.out.println("Number of nodes in a tree are "+btt.countNodes(btt.root,0));

                break;
                case'5':
                System.out.println("Height of a tree is "+btt.treeHeight(btt.root));
               

                break;
                case'6':
                System.out.println("Largest element is "+btt.findLargest(btt.root,0));
                
                break;
                case'7':

                System.out.println("Sum of elements is "+btt.sum(btt.root,0));
                
                break;
                case'8':
                int sum = btt.sum(btt.root,0);
                int count =btt.countNodes(btt.root,0);
                System.out.println("Average of elements is "+btt.average(sum,count));
                break;

                case '9':
                System.out.print("Enter the first element: ");
                int first = sc.nextInt();
                System.out.print("Enter  the second element: ");
                int second = sc.nextInt();

                /*if(btt.getAncestors(btt.root,second)==first)
                    System.out.println(first +" is an ancestor of "+second);
                else
                    System.out.println(first +" is  not an ancestor of "+second);*/
                break;
                case 'A':
                btt.PreOrder(btt.root);

                break;
                case'B':
                btt.PostOrder(btt.root);
                break;
                case'C':
                btt.inorder(btt.root);

                break;
            }
            if(choice=='Q')
                break;

        }
    }

    private BinaryTree createTree(int value){
        BinaryTree btt = new BinaryTree();
        btt.add(value);
        return btt;
    }

    public void add(int val){
        root = addRecursive(root, val);
    }

    public Node addRecursive(Node current, int val) {
        if (current == null) {
            return new Node(val);
        }
        if (val < current.val){
            current.left = addRecursive(current.left, val);
        }
        else if (val > current.val) {
            current.right = addRecursive(current.right, val);
        }
        else {
            return current;
        }
        return current;
    }

    public int countNodes(Node node,int size) {
        int count = size;
        if (node != null) {
            count++;
            count = countNodes(node.left,count);
            count = countNodes(node.right,count);
        }
        return count;
    }

    private int treeHeight(Node node)
    {
        if (node == null)
            return -1;
        else
        {
            int leftDepth = treeHeight(node.left);
            int rightDepth = treeHeight(node.right);
            if (leftDepth > rightDepth)
                return (leftDepth+ 1);
            else
                return (rightDepth+ 1);
        }
    }

    private int findLargest(Node node,int value) {
        int largest = value;
        if (node != null) {
            if(node.val>largest)
                largest = node.val;
            largest = findLargest(node.left,largest);
            largest = findLargest(node.right,largest);
        }
        return largest;
    }

    private int sum(Node node,int value) {
        int sum = value;
        if (node != null) {
            sum = sum+node.val;
            sum = sum(node.left,sum);
            sum = sum(node.right,sum);
        }
        return sum;
    }

    private double average(double s,double c) {
        double sum =s;
        double count = c;
        double avg = sum/(count);
        return avg;
    }

   public static boolean find(Node root, int data)
    {
        if(root==null) 
        {
            return false;
        }
        if(root.val==data)
        {
            return true;
        }
        if(data<root.val) 
        {
            return find(root.left,data);
        }
        else 
        return find(root.right,data);
    }

   private static int findSmallest(Node root)
    {
        if (root.left == null)
        {
            return root.val;
        }
        else
        {
            return findSmallest(root.left);
        }
    }
    public static Node delete(Node root, int data)
    {
        if(root==null) 
        {
            return null;
        }
        if(data<root.val){
            root.left = delete(root.left,data);
        }
        else if(data>root.val)
        {
            root.right = delete(root.right,data);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            root.val = findSmallest(root.right);
            root.right = delete(root.right,root.val);
        }
        return root;
    }
    
    public void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.val+ " -> " );
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    public void PostOrder(Node node){
        if (node!=null){
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.val+ " -> " );
        }
    }


    public static void inorder(Node root)
    {
        if(root==null)
            return ;
        inorder(root.left);
        System.out.print(root.val+" -> " );
        inorder(root.right);
    }

}

