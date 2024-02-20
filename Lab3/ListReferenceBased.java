public class ListReferenceBased implements ListInterface 
{
    // reference to linked list of items
    private Node head; 

    public ListReferenceBased() 
    {
        head = null;
    }  // end default constructor

    public boolean isEmpty() 
    {
        return head == null;
    }  // end isEmpty

    public int size() 
    {
        int size =0;
        Node newNode =head;
        if(head == null) {
            size =0;
        }
        else if (!(head==null)){
            size=1;
            Node n =head;
            while(!(n.getNext()==null)) {
                size++;
                n=n.getNext();
            }
        }
        return size;
    }

    private Node find(int index) 
    {
        
       Node curr = head;
         for (int skip = 0; skip < index; skip++) 
        {
            curr = curr.getNext();
        } // end for
        return curr;
    } // end find

    public Object get(int index) 
    throws ListIndexOutOfBoundsException 
    {
        if (index >= 0 && index < size()+1) 
        {
            // get reference to node, then data in node
            Node curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        } 
        else 
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item) throws ListIndexOutOfBoundsException 
    {
        if (index >= 0 && index < size()+1) 
        {
            if(index==0) {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node(item, head);
                head= newNode;
            }
            else {
                Node prev = find(index-1);
                Node newNode = new Node(item, prev.getNext());
                prev.setNext(newNode);
            }
        }
        else {
            throw new ListIndexOutOfBoundsException("cannot add to this index");
        }

    }  // end add

    public void remove(int index) 
    throws ListIndexOutOfBoundsException 
    {
        if (index >= 0 && index < size()+1) 
        {
            if (index == 0) 
            {
                // delete the first node from the list
                head = head.getNext();
            } 
            else 
            {
                Node prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.getNext(); 
                prev.setNext(curr.getNext());
            } // end if
            find(index-1).setNext(find(index+1));
        } // end if
        else 
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } 
    }   

    public void removeAll() 
    {
        
        head = null;

    } 

}