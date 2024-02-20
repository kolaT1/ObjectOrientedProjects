import java.util.Scanner;
public class MaxHeap {
    private int[] Heap;
    private int size;
    private int maxsize;
    static Scanner sc = new Scanner(System.in);
    public MaxHeap(int maxsize){
        this.maxsize=maxsize;
        this.size=0;
        Heap=new int[this.maxsize+1];

    }
    public void swap(int fpos,int spos){
        int temp=Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    } 
    private int parent(int pos) {
        return (pos - 1) / 2;
    }
    private int leftChild(int pos) {
        return (2 * pos) + 1; 
    }  
    private int rightChild(int pos){ 
        return (2 * pos) + 2; 
    }  
    private boolean isLeaf(int pos)
    {
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    private void maxHeapify(int pos)
    {
        if (isLeaf(pos))
         return;
        if (Heap[pos] < Heap[leftChild(pos)]|| Heap[pos] < Heap[rightChild(pos)]) {

            if (Heap[leftChild(pos)]> Heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
            else {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    public void buildMaxHeap(){
        for(int i=size/2;i>=1;i--){
            maxHeapify(i);
        }
    }

    public void insert(int data){
        Heap[++size]=data;
    }

    public void removeTop(){
        if(size==0){
            System.out.println("Heap is empty");
            return;
        }
        Heap[1]=Heap[size];
        size--;
        maxHeapify(1);
    }
    public void findElement(int key){
        for(int i=1;i<=size;i++){
            if(Heap[i]==key) {
                System.out.println(key +" found ");
                return;
            }

            else if (Heap[i]!= key) {
                System.out.println(key+ " not found");
            }
        }
    }
    public void RemoveElement(int key)
    {
        for(int i=1;i<=size;i++){
            if(Heap[i]==key) {
                System.out.println(key +" has been removed ");
                Heap[i]=Heap[size];
                size--;
               return;
            }
            else if (Heap[i]!= key) {
                System.out.println(key+ " not in the heap");
            }
        }
    }

    public void display(){
        if(size==0){
            System.out.println("Heap is empty");
            return;
        }
        System.out.println("Heap is : ");
        for(int i=1;i<=size;i++){
            System.out.print(Heap[i]+" ");
        }
    }

    public static void main(String args[]){

        Scanner scan = new Scanner(System.in);
        MaxHeap heap1=new MaxHeap(15);
        int choice;
        System.out.println("\nWelcome to the Max Heap Program");
        System.out.println("Author: kola taiwo");
        System.out.println("Select an Option: ");
        while(true){   
            System.out.println("\n1. Add an element");
            System.out.println("2.Remove the top (root)");
            System.out.println("3.Remove from heap");
            System.out.println("4.Find an element");
            System.out.println("5.Print the heap");
            System.out.println("6.Quit");
            System.out.println("Enter your choice: ");
            choice= scan.nextInt();
            switch (choice){
                case 1:
                System.out.println("Enter an element to be added: ");
                int ele=scan.nextInt();
                heap1.insert(ele);
                break;
                case 2:
                heap1.buildMaxHeap();
                heap1.removeTop();
                System.out.println("top removed");
                break;
                case 3:

                System.out.println("Enter an element to remove");
                int key2= scan.nextInt();
                heap1.RemoveElement(key2);
                break;
                case 4:
                System.out.println("Enter an element to be found: ");
                int key=scan.nextInt();
                heap1.findElement(key);

                break;
                case 5:
                heap1.buildMaxHeap();
                heap1.display();
                break;
                case 6:
                System.exit(0);
                break;

                default:

            }

        }
    }
}