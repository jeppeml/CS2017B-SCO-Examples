/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication84;

import java.util.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class JavaApplication84 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Horse");
        list.add("Pig");
        list.add("Dog");
        list.add("Cat");
        list.add("Sea Lion");
        System.out.println("Unsorted Animals:");
        for (String string : list) {
            System.out.println(string);
        }
        
        Collections.sort(list);
        
        
        System.out.println("Sorted Animals:");
        for (String string : list) {
            System.out.println(string);
        }
        
        String str1 = "monkey";
        String str2 = "monkey";
        
        int result = str2.compareTo(str1);
        
        System.out.println("Result: " + result);
        
        Pokemon pikachu = new Pokemon();
        pikachu.setId(25);
        pikachu.setName("Pikachu");
        pikachu.setType("Electric");
        
        Pokemon squirtle = new Pokemon();
        squirtle.setId(7);
        squirtle.setName("Squirtle");
        squirtle.setType("Water");
        
        Pokemon charmander = new Pokemon();
        charmander.setId(4);
        charmander.setName("Charmander");
        charmander.setType("Fire");
        
        ArrayList<Pokemon> pokeList = new ArrayList<>();
        pokeList.add(squirtle);
        pokeList.add(charmander);
        pokeList.add(pikachu);
        
        System.out.println("Unsorted list: ");
        for (Pokemon pokemon : pokeList) {
            System.out.println("Id: " + pokemon.getId());
            System.out.println("Name: " + pokemon.getName());
            System.out.println("Type: " + pokemon.getType());
            System.out.println("");
        }
        
        Collections.sort(pokeList, new Comparator<Pokemon>() {
            @Override
            public int compare(Pokemon o1, Pokemon o2) {
                return o1.getId()-o2.getId();
            }
        }
        
        );
        System.out.println("Sorted list: ");
        for (Pokemon pokemon : pokeList) {
            System.out.println("Id: " + pokemon.getId());
            System.out.println("Name: " + pokemon.getName());
            System.out.println("Type: " + pokemon.getType());
            System.out.println("");
        }
        
        HashMap<Integer, Pokemon> pokeHash = new HashMap();
        pokeHash.put(pikachu.getId(), pikachu);
        pokeHash.put(squirtle.getId(), squirtle);
        pokeHash.put(charmander.getId(), charmander);
        
        System.out.println("Found: " + pokeHash.get(4).getName());
        
    }
    static class NameComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return p1.getName().compareTo(p2.getName());
    }
    }
    
}
