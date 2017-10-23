/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodoverload;

import java.util.ArrayList;

/**
 *
 * @author jeppjleemoritzled
 */
public class Warehouse
{
    ArrayList<String> items = new ArrayList();
    
    public Warehouse()
    {
        items.add("Bomb");
        items.add("AK47");
        items.add("M4");
        items.add("M16");
        items.add("Trout");
        items.add("Coconut");
    }
    public ArrayList<String> getItems(String startsWith)
    {
        ArrayList<String> filteredItems = new ArrayList();
        for (String item : items)
        {
            if(item.startsWith(startsWith))
            {
                filteredItems.add(item);
            }
        }
        return filteredItems;
    } 
    
    
    public ArrayList<String> getItems(int amount)
    {
        ArrayList<String> four = new ArrayList();
        for (int i = 0; i < amount; i++)
        {
            four.add(items.get(i));
        }
        return four;
        
    } 
    
    public ArrayList<String> getItems()
    {
        return items;
    }
}
