import java.util.*;
public class SetsAndBags {
    private static Scanner sc;

    public static ArrayList<Integer> divisors (int n) {
        ArrayList<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 1; i <= n / 2; i++)
            if (n % i == 0) 
                divisors.add (i);
        divisors.add (n);
        return divisors;
    }

    public static ArrayList<Integer> factors (int n) {
        ArrayList<Integer> factors = new ArrayList<>();

        while (n % 2 == 0) {
            factors.add (2);
            n = n / 2;
        }

        for (int i = 3; i <= n; i += 2) {
            if (n == 1) 
                break;              
            while (n % i == 0) {

                factors.add (i);
                n = n / i;
            }
        }
        return factors;
    }

    public static int gcd (int m, int n) {
        ArrayList<Integer> mdiv = divisors (m);
        ArrayList<Integer> ndiv = divisors (n);
        mdiv.retainAll(ndiv);              
        return Collections.max (mdiv);     
    }

    public static int lcm (int m, int n) {
        ArrayList<Integer> mfac = factors (m);
        ArrayList<Integer> nfac = factors (n);
        mfac.addAll(nfac);
        int product = 1;
        for (Integer i : mfac)
            product *= i;    
        return product / gcd (m, n);            
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n1 = sc.nextInt();
        ArrayList<Integer> pf1 = new ArrayList<Integer>();

        for (int i=1;i<=n1;i++){

            if (n1%i==0)
            {
                pf1.add(i);

            }

        }  
        System.out.println("The factors of " + n1 + " are "+ pf1);
        System.out.println("\nEnter a number: ");
        int n2 = sc.nextInt();

        ArrayList<Integer> pf = new ArrayList<Integer>();
        pf.add(1);
        for(int i = 2; i< n2; i++) {
            while(n2%i == 0) {
                pf.add(i);
                n2 = n2/i;
            }

        }
        if(n2 >2) {
            pf.add(n2);
        }
        System.out.println("Prime factorization of " + n2 + " is : " + pf);

        System.out.println("\nEnter first number: ");
        int m = sc.nextInt();
        System.out.println("Enter second number: ");
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(m);
        list.add(n);
        System.out.println("The GCD is " + gcd(m,n));
        System.out.println("The LCM is " + lcm(m,n));

    }

}