/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittestingexample;

import static org.hamcrest.CoreMatchers.*;
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
    public void cat() {
        double yellowExpectedPrice = 10_000f/(65_000f/44_000f);
        Car c = new Car();
        c.setColor("yellow");
        c.setMilage(65_000);
        assertEquals("Car price wrong",yellowExpectedPrice,c.getPrice(),0.5);
        
        Car c2 = new Car();
        c2.setColor("Yellow");
        c2.setMilage(65_000);
        assertThat(c2.getPrice(), is(not(10_000)));
        assertThat(c2.getPrice(), is(yellowExpectedPrice));
    }

    /**
     * Test of getMilage method, of class Car.
     */
    @Test
    public void hat() {
        System.out.println("getMilage");
       
        Car instance = new Car();
        instance.setMilage(65_000);
        double expResult = 65_000;
        double result = instance.getMilage();
        assertEquals(expResult, result, 0.5);
        assertThat(result, is(expResult));
        
    }


    /**
     * Test of getColor method, of class Car.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Car car = new Car();
        car.setColor("yellow");
        String result = car.getColor();
        assertEquals("yellow", result);
    }

    
}
