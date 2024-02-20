import java.util.*;
public class RpnCalculator
{
    public static void RPNCalculator(String expr) 
    {

        Stack<Double> RpnStuff = new Stack<>();
                
        String e[] = expr.split("\\s+|,\\s*");

        for(int i = 0; i < e.length; i++)
        {
          
            
            switch (e[i]) 
            {
                case "+":
               
                RpnStuff.push(RpnStuff.pop() + RpnStuff.pop());
                break;
                case "-":
               
                RpnStuff.push(-RpnStuff.pop() + RpnStuff.pop());
                break;
                
                case "/":
                
                double div = RpnStuff.pop();      
                RpnStuff.push(RpnStuff.pop() / div); 
                break;
                case "*":
                
                RpnStuff.push(RpnStuff.pop() * RpnStuff.pop());
                break;
                
                case "^":
                
                double exp = RpnStuff.pop();                
                RpnStuff.push(Math.pow(RpnStuff.pop(), exp));  
                break;
                
                case "plusminus":
                RpnStuff.push(RpnStuff.pop() * -1);
               
                break;
                
                case "sqrt":
                double sqrt = RpnStuff.pop();
                RpnStuff.push(Math.sqrt(sqrt));
                break;  
                case "recip":
                double recip = 1/RpnStuff.pop();
                RpnStuff.push(recip);
                break;
                                             
                default:
               
                RpnStuff.push(Double.parseDouble(e[i])); 
                break;
            }

          
        }

        
        System.out.println(" The answer is: " + RpnStuff.pop());
    }

     
    public static void main(String[] args) {

        String expr;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the rpn calculator");
        System.out.println("Author: Kola Taiwo");
        System.out.print("Enter your RPN string: ");
        expr = sc.nextLine();
        RPNCalculator(expr);
    }
}