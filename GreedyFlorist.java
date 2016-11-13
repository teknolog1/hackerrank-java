import java.io.*;
import java.util.*;
// see https://www.hackerrank.com/challenges/greedy-florist for problem description
public class GreedyFlorist {

    public static void main(String[] args) {
        // simply order greedely..
        Scanner sca = new Scanner(System.in);
        
        int numFlowers = sca.nextInt();
        int buyFlowers = numFlowers;
        int numPersons = sca.nextInt();
        int[] arrFlow = new int[numFlowers];
        
        for (int j = 0; j < numFlowers; j++)
        {
            arrFlow[j] = sca.nextInt();
        }
        Arrays.sort(arrFlow);
        int multi = 1;
        int acc = 0;
        
        
        // coefficients in a heap...
        int[] arrFlow2 = new int[numFlowers];

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        for (int j = 0; j < numPersons; j++)
        {
            pq1.add(1);
        }
        
        
        
        for (int l = numFlowers -1; l >= 0; l--)
        {
            int multiPers = pq1.remove();
            acc += (multiPers * arrFlow[l]);
            pq1.add((multiPers+1));
        }
        
      /*  for (int l = numFlowers -1; l > ((numFlowers -1) - (numPersons-1)); l--)
        {
            acc += arrFlow[l]; 
        }
        for (int l = ((numFlowers -1) - (numPersons-1)); l >= 0; l--)
        {
            acc += (multi * arrFlow[l]); multi++;
        }*/
        
        System.out.println(acc);
    }
}
