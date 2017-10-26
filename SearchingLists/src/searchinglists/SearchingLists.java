/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchinglists;

import java.util.ArrayList;

/**
 *
 * @author jeppjleemoritzled
 */
public class SearchingLists
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {   
        
        int[] myInts = new int[40_000_000];
        
        for (int i = 0; i < myInts.length; i++)
        {
            myInts[i]=i;
        }
        
        int numberToFind = 39999999;
        
        long startTime = System.currentTimeMillis();
        int index= findBinaryIndex(myInts, numberToFind);
        
        System.out.println("Found: " + index);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime-startTime) + " ms");
    
    }
    
    // Linear search
    private static int findIndex(int[] numbers, int numberToFind) throws InterruptedException
    {
        for (int i = 0; i < numbers.length; i++)
        {
            Thread.sleep(10);
            if(numbers[i]==numberToFind)
            {
                return i;
            }
        }
        return -1;
    }
    
    // Binary search
    private static int findBinaryIndex(int[] numbers, int numberToFind) throws InterruptedException
    {
        int lo = 0;
        int hi = numbers.length-1;
        while(lo<=hi)
        {
            Thread.sleep(10);
            int cur = lo+(hi-lo)/2;
            if(numberToFind<numbers[cur])
                hi=cur-1;
            else if(numberToFind>numbers[cur])
                lo=cur+1;
            else
                return cur;
        }
        return -1;
    }
    
}
