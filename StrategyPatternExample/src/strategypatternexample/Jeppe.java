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
public class Jeppe implements SearchStrategy
{

    @Override
    public int search(int[] arrayToSearch, int searchFor)
    {
        System.out.println("Doing the Jeppe search");
        return -1;
    }
    
}
