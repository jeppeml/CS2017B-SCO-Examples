/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternexample;

/**
 *
 * @author jeppjleemoritzled
 */
public class Binary implements SearchStrategy
{
    @Override
    public int search(int[] arrayToSearch, int searchFor)
    {
        System.out.println("Using binary search");
        int lo = 0;
        int hi = arrayToSearch.length-1;
        while(lo<=hi)
        {
            int cur = lo+(hi-lo)/2;
            if(searchFor<arrayToSearch[cur])
                hi=cur-1;
            else if(searchFor>arrayToSearch[cur])
                lo=cur+1;
            else
                return cur;
        }
        return -1;
    }
    
}
