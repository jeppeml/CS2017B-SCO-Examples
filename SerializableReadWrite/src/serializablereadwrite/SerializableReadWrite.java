/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializablereadwrite;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author jeppjleemoritzled
 */
public class SerializableReadWrite extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("App.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        IceCream ice = new IceCream(
                "Lumpy", "Nuggy", "Chocolate-bacon");
        
        IceCream ice2 = new IceCream(
                "Runny", "Nuggy", "Chocolate-garlic");
        
        IceCream ice3 = new IceCream(
                "Smooth", "Prello", "Strawberry");
        
        List<IceCream> iceList = new ArrayList();
        iceList.add(ice);
        iceList.add(ice2);
        iceList.add(ice3);
        
        System.out.println("Ice created: ");
        System.out.println(ice);
        
        ObjectOutputStream oos =
            new ObjectOutputStream(
                new FileOutputStream("myIce.ser")
            );
        oos.writeObject(iceList);
        
        ObjectInputStream ois = 
                new ObjectInputStream(
                    new FileInputStream("myIce.ser")
                );
        
        List<IceCream> readIce = (List<IceCream>)ois.readObject();
        
        for (IceCream iceCream : readIce) {
            System.out.println("Ice read from file:");
            System.out.println(iceCream);
        }
        
        
        
        launch(args);
    }
    
}
