/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guithreads;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author jeppjleemoritzled
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    private static int count = 0;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        
        
        Thread t = new Thread(new MyRunnable());
        t.start();
        
        Thread t2 =  new Thread(new MyInternalRunner());
        t2.start();
        
        // Anonymous inner class
        Thread t3 =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Anon innner class says hello");
            }
        });
        t3.start();
        
        Thread t4 =  new Thread(()->{
            System.out.println("Hello from lambda");
        });
        t4.start();
    }
                
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    // Java internal class
    private class MyInternalRunner implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(4000);
            }
            catch (InterruptedException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Running in inner class");
        }
    
    }
    
}
