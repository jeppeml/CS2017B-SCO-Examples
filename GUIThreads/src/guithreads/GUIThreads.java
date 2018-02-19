/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guithreads;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jeppjleemoritzled
 */
public class GUIThreads extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        System.out.println(Thread.currentThread().getName());
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("Stop: " + Thread.currentThread().getName());
        
        super.stop(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void init() throws Exception {
        System.out.println("init: " + Thread.currentThread().getName());
        
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        launch(args);
    }
    
}
