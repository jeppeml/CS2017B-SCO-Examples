/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestingexample;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class CarTest {
    
    public CarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPrice method, of class Car.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Car instance = new Car("yellow");
        instance.setMilage(1500);
        double expResult = 293333;
        double result = instance.getPrice();
        assertEquals(expResult, result, 1);
        
    }

    /**
     * Test of getMaxPrice method, of class Car.
     */
    @Test
    public void testGetMaxPrice() {
        System.out.println("getMaxPrice");
        Car instance = null;
        double expResult = 0.0;
        double result = instance.getMaxPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMilage method, of class Car.
     */
    @Test
    public void testGetMilage() {
        System.out.println("getMilage");
        Car instance = null;
        double expResult = 0.0;
        double result = instance.getMilage();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMilage method, of class Car.
     */
    @Test
    public void testSetMilage() {
        System.out.println("setMilage");
        double milage = 0.0;
        Car instance = null;
        instance.setMilage(milage);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColor method, of class Car.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Car instance = null;
        String expResult = "";
        String result = instance.getColor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColor method, of class Car.
     */
    @Test
    public void testSetColor() {
        System.out.println("setColor");
        String color = "";
        Car instance = null;
        instance.setColor(color);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
