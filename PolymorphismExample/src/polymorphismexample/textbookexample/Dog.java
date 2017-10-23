/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismexample.textbookexample;

import polymorphismexample.textbookexample.Animal;

/**
 *
 * @author jeppjleemoritzled
 */
public class Dog extends Animal
{

    @Override
    public void makeSound()
    {
        System.out.println("Woof!");
    }

    @Override
    public void walk()
    {
        System.out.println("Dog walking lazily");
    }
    
}
