import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/maxsubarray ... just get maximum continuous and non continuous sum of array in fastest time.
public class DynamicMaximumSubArray {

    public static void main(String[] args) { 
        Scanner sk = new Scanner(System.in);
        int examples = sk.nextInt();
        
        for (int j = 0; j < examples; j++)
        {
            int sizeArr = sk.nextInt();
            double[] arrCon = new double[sizeArr];
            
            for (int i=0; i < sizeArr; i++)
            {
                arrCon[i] = sk.nextDouble();
           //     System.out.println(arrCon[i]);
            }
            
            double [][] conSub = new double[sizeArr][2];
            for (int i=0; i < sizeArr; i++)
            {
                conSub[i][0] = -Double.MAX_VALUE;
                conSub[i][1] = -Double.MAX_VALUE;
            }
            
            
            double nonContiguous = -Double.MAX_VALUE;
         //   System.out.println(nonContiguous);
            double contSum = -Double.MAX_VALUE;
            // dynamic programming sum ups 
            for (int i=0; i < sizeArr; i++)
            {
                if (arrCon[i] > 0) { if (nonContiguous < 0) nonContiguous = arrCon[i]; else nonContiguous += arrCon[i];}
                else if (nonContiguous < 0) { nonContiguous = Math.max(nonContiguous, arrCon[i]);  //System.out.println(nonContiguous);
                                               } 
                
                // for contiguous only... sum including prev or non including prev for both currents..
                double prevSumDropped = -Double.MAX_VALUE;
                double prevSumCont = -Double.MAX_VALUE;
                if (i>0)
                {
                    prevSumDropped = conSub[i-1][0];
                    prevSumCont = conSub[i-1][1];
                }
                
                conSub[i][0] = Math.max(prevSumDropped,prevSumCont);
                conSub[i][1] = Math.max(arrCon[i],arrCon[i] + prevSumCont);
            }
            for (int i=sizeArr-1; i < sizeArr; i++)
            {
                contSum = Math.max(contSum, conSub[i][1]);
                contSum = Math.max(contSum, conSub[i][0]);
            }
            
            System.out.println(String.format("%.0f %.0f", contSum, nonContiguous));
        }
        
    }
}
