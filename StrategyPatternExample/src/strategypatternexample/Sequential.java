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
public class Sequential implements SearchStrategy
{

    @Override
    public int search(int[] arrayToSearch, int searchFor)
    {
        System.out.println("Using sequential search");
        
        for (int i = 0; i < arrayToSearch.length; i++)
        {
            if(arrayToSearch[i]==searchFor)
            {
                return i;
            }
        }
        return -1;
    }
    
}
