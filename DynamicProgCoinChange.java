import java.io.*;
import java.util.*;

// common more difficult dyn programming.. https://www.hackerrank.com/challenges/coin-change
public class DynamicProgCoinChange {

    public static void main(String[] args) {
       
        Scanner in = new Scanner(System.in);
        
        int m = in.nextInt();
        int s = in.nextInt();
    
        int[] S = new int[s];
        for(int i=0;i<s;i++){
            S[i]=in.nextInt(); 
        }
        
    Arrays.sort(S);
    long table[]  = new long[m+1];
    // Base case (If given value is 0)
    table[0] = 1;
 
    // residuals at certain table 
    int tableRes[]  = new int[m+1];
    
    // Pick all coins one by one and update the table[] values
    // after the index greater than or equal to the value of the
    // picked coin
    
        for(int j=0; j<s; j++)
        {
            for(int i=0; i<=m; i++)
            if (i - S[j] >= 0)
            {
                if (tableRes[i-S[j]] <= j)
                 {
                    table[i] += table[i-S[j]];
                    tableRes[i] = j;
                 //   System.out.println("numproc " + i + " backup "+ S[j] + " prevbound " + S[tableRes[i-S[j]]]);
                }
            }
        }
 
    System.out.println(table[m]);
        
        
        
    }
}
