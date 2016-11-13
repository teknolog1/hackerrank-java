import java.io.*;
import java.util.*;
// Generic game of nim where you XOR things.. someone's old thesis http://web.mit.edu/sp.268/www/nim.pdf
public class GameTheoryNormalNim {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        
        int cases = sca.nextInt();
        
        while (cases > 0)
        {
            int piles = sca.nextInt();
            
            int[] pileVals = new int[piles];
            
            
            int resu = 0;
            
            for (int j = 0; j < piles; j++)
            {
                resu ^= sca.nextInt();
            }
            
            if (resu == 0)
                System.out.println("Second");
            else
                System.out.println("First");
            cases--;
        }
        
        
    }
}
