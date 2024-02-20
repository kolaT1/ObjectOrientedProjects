public class Item {
private String name;
  
public Item()
   {
       this.name = "";
   }

public Item(String name)
   {
       this.name = name;
      
   }

public String getName() {
       return name;
   }

public void setName(String name) {
       this.name = name;
   }


@Override
public String toString()
   {
       return("Item Name: " + this.name);
   }

}
