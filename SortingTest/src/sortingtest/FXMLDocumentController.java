/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingtest;

import java.net.URL;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 *
 * @author jeppjleemoritzled
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private ListView<Integer> listInput;
    @FXML
    private ListView<Integer> listOutput;
    private Integer[] input = {4, 7, 2, 9, 20, 51, 1, 0, 8};

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    private void createGiantIntList()
    {
        input = new Integer[100_000];
        Random r = new Random();
        for (int i = 0; i < 100_000; i++) {
            input[i]=r.nextInt(200_000);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createGiantIntList();
        listInput.setItems(
                FXCollections.observableArrayList(input));
    }

    @FXML
    private void clickDoSort(ActionEvent event) {
        bubbleSort(input);
        listOutput.setItems(
                FXCollections.observableArrayList(input));
        /*long startTime = System.nanoTime();
        listInput.getItems().sort(new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        long timeElapsed = System.nanoTime()-startTime;
        System.out.println("Built-in Seconds passed: " + timeElapsed/1_000_000f);
   */
    }
    
    public void bubbleSort(Integer[] inputArr)
    {
        long startTime = System.nanoTime();
        
        for (int i = 1; i < inputArr.length; i++) {
            for (int j = 0; j < inputArr.length-i; j++) {
                if(inputArr[j]>inputArr[j+1])
                {
                    Integer tmp = inputArr[j];
                    inputArr[j] = inputArr[j+1];
                    inputArr[j+1] = tmp;
                }
            }
        }
        
        long timeElapsed = System.nanoTime()-startTime;
        System.out.println("Seconds passed: " + timeElapsed/1_000_000_000f);
    }

}
