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
public class Finder
{
    
    private SearchStrategy searchStrategy;

    public int doSearch(int[] arrayToSearch, 
            int searchFor)
    {
        return searchStrategy.search(arrayToSearch, searchFor);
    }
    
    /**
     * Get the value of searchStrategy
     *
     * @return the value of searchStrategy
     */
    public SearchStrategy getSearchStrategy()
    {
        return searchStrategy;
    }

    /**
     * Set the value of searchStrategy
     *
     * @param searchStrategy new value of searchStrategy
     */
    public void setSearchStrategy(SearchStrategy searchStrategy)
    {
        this.searchStrategy = searchStrategy;
    }

}
