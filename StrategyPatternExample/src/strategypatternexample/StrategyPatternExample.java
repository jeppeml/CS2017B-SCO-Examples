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
public class StrategyPatternExample
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Finder finder = new Finder();
        SearchStrategy ss = new Sequential();
        finder.setSearchStrategy(ss);
        
        int[] myInts = new int[40_000_000];
        
        for (int i = 0; i < myInts.length; i++)
        {
            myInts[i]=i;
        }
        
        int numberToFind = 39_999_999;
        
        int indexOfElement = finder.doSearch(myInts, numberToFind);
        
        if(indexOfElement==-1)
            System.out.println("Not found");
        else
            System.out.println("Found: " + indexOfElement);
        
        // TODO code application logic here
    }
    
}
