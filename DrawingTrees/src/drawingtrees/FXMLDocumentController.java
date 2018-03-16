/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawingtrees;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author jeppjleemoritzled
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane paneCanvas;
    @FXML
    private Canvas canvas;
    GraphicsContext gc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        gc.setStroke(Color.BROWN);
        gc.setLineWidth(2);
        drawTree(400,550,150,90);
    }    

    private void drawTree(double x, double y, double length, int angle) {
        if(length>1)
        {
            // Draws a line
            double x1 = x + length * Math.cos((angle*Math.PI)/180);
            double y1 = y - length * Math.sin((angle*Math.PI)/180);
            
            gc.strokeLine(x,y,x1,y1);
            // END draws a line
            if(length<2)
                gc.setStroke(Color.DARKGREEN);
            else
                gc.setStroke(Color.BROWN);
            
            drawTree(x1,y1,length*0.56,angle+30);
            drawTree(x1,y1,length*0.65,angle-30);
            drawTree(x1,y1,length*0.37,angle+10);
            
        }
    }
    
}
