/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

/**
 *
 * @author jeppjleemoritzled
 */
public class EmailTextField extends TextField{

    public EmailTextField() {
        super();
        setupCheckEmailListener();
    }

    public EmailTextField(String text) {
        super(text);
        setupCheckEmailListener();
    }
    
    private void setupCheckEmailListener()
    {
//        this.textProperty().addListener(
//                new ChangeListener<String>() {
//            @Override
//            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
//                System.out.println("Text changed"); }
//        }
//        );
        
        this.textProperty().addListener(e->{
            if(getText().contains("@"))
                setStyle("-fx-text-fill: green");
            else
                setStyle("-fx-text-fill: red");
        });
    }
    
}
