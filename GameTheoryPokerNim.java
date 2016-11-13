import java.io.*;
import java.util.*;

// This is same theory as normal nim except with bluffing ... see https://www.hackerrank.com/challenges/poker-nim-1
public class GameTheoryPokerNim {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        
        int cases = sca.nextInt();
        
        while (cases > 0)
        {
            int piles = sca.nextInt();
            sca.nextInt();
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
