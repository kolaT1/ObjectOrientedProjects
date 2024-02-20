import java.util.ArrayList;
import java.util.List;

public class CollectionCompareToObjects {

 public static void main(String[] args) {

  List<Item> before = new ArrayList<Item>();
  List<Item> after = new ArrayList<Item>();

  before.add(new Item(1L));
  before.add(new Item(2L)); // delete
  before.add(new Item(3L));

  after.add(new Item(1L));
  after.add(new Item(3L));
  after.add(new Item(4L)); // added

  List<Item> removed = new ArrayList<Item>(before);
  removed.removeAll(after);

  System.out.println("removed objects are:");
  for(Item item : removed){
   System.out.println(item.getId());
  }

  List<Item> same = new ArrayList<Item>(before);
  same.retainAll(after);

  System.out.println("same objects are:");
  for(Item item : same){
   System.out.println(item.getId());
  }

  List<Item> added = new ArrayList<Item>(after);
  added.removeAll(before);

  System.out.println("add objects are:");
  for(Item item : added){
   System.out.println(item.getId());
  }

 }

}
