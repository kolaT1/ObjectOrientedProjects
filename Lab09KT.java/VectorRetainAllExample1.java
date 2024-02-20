import java.util.Vector;  
public class VectorRetainAllExample1 {    
    public static void main(String arg[]) {  
      //Create an empty Vec1  
        Vector<Integer> vec1 = new Vector<>();  
        //Add elements in the Vector1  
        vec1.add(1);  
        vec1.add(2);  
        vec1.add(3);  
        vec1.add(4);  
        vec1.add(2);   
        //Create an empty Vec2  
        Vector<Integer> vec2 = new Vector<>();  
        //Add elements in the Vector2  
        vec2.add(2);  
        vec2.add(3);   
        //Displaying the Vector elements        
        System.out.println("Values in vector :" +vec1);  
        //use retainAll() method  
        vec1.retainAll(vec2);  
        System.out.println("Values in vector :" +vec1);  
      }  
}  