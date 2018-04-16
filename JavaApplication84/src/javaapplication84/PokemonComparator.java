/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication84;

import java.util.Comparator;

/**
 *
 * @author jeppjleemoritzled
 */
public class PokemonComparator implements Comparator<Pokemon>{

    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return p1.getType().compareTo(p2.getType());
    }

  
}
