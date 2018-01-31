/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customcontrols;

import javafx.scene.control.TextField;

/**
 *
 * @author jeppjleemoritzled
 */
public class EmailTester extends TextField{
private static final String emailRegex = 
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`"
            + "{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\"
            + "x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\"
            + "x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z"
            + "0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]"
            + "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9]"
            + "[0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\"
            + "x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\"
            + "x0c\\x0e-\\x7f])+)\\])";

    public EmailTester() {
        super();
        setTextColorListener();
    }

    public EmailTester(String text) {
        super(text);
        setTextColorListener();
    }
    
    private void setTextColorListener() {
        textProperty().addListener(e->{
            if(getText().matches(emailRegex))
                setStyle("-fx-text-fill: green");
            else
                setStyle("-fx-text-fill: red");
        });
    }
    
    
    
}
