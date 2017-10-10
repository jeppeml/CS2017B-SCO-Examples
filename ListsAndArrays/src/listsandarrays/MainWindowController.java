/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listsandarrays;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author jeppjleemoritzled
 */
public class MainWindowController implements Initializable
{
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        String output= "";
        
        ArrayList<String> ar; // this means that ar=null
        ar = new ArrayList(); // now ar points to arraylist
        
        ArrayList<String> ar2 = new ArrayList(); // one line init
        
        String myString = "Hi";
        
        ar.add(myString);
        // ar.remove(myString); <==> ar.remove(0);
        
        
        // int[] myNumbers = new int[1500];
        ArrayList<Integer> myList = new ArrayList();
        
        for (int i = 0; i < 1500; i++)
        {
            Integer currentInteger = (int)(Math.random()*100);
            myList.add(currentInteger);
            output = output + currentInteger + "\n";
            
        }
        
        // for each integer in the ArrayList
        for (Integer jesper : myList)
        {
            jesper=jesper+700;
            System.out.println("" + jesper);
        }
        
        
        
        
        
        /*
        
        int[][] myNumbers = new int[1500][1500];
        
        for (int i = 0; i < myNumbers.length; i++)
        {
            for (int j = 0; j < myNumbers[0].length; j++)
            {
                myNumbers[i][j]= (int)(Math.random()*100);
                
            }
            
        }*/
        int[] myNumbers = new int[1500];
        for(int i=0;i<myNumbers.length;i++)
        {
            myNumbers[i]= (int)(Math.random()*100);
            output = output + myNumbers[i] + "\n";
        }
        output = output + "Index 4 is " + myNumbers[4] + "\n";
        
        /*
        int firstNumber = (int)(Math.random()*100);
        int secondNumber = (int)(Math.random()*100);
        int thridNumber = (int)(Math.random()*100);
        int fourthNumber = (int)(Math.random()*100);
        
        output = output + firstNumber + "\n";
        output = output + secondNumber + "\n";
        output = output + thridNumber + "\n";
        output = output + fourthNumber + "\n";
        
        output = output + "\nFourth number is " + fourthNumber + "\n";
        
        */
        
        /*
        for(int i=0;i<10;i++)
        {
            int myLargeNumber = (int)(Math.random()*100);
            output = output + myLargeNumber + "\n";
        }*/
        
        
        
        label.setText(output);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
