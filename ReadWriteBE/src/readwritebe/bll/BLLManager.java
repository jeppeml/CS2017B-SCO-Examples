/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe.bll;

import java.io.IOException;
import javafx.collections.ObservableList;
import readwritebe.be.Prisoner;
import readwritebe.dal.DALManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class BLLManager {

    DALManager dalManager = new DALManager();
    
    public ObservableList<Prisoner> getAllPrisoners() throws IOException {
        return dalManager.getAllPrisoners();
    }

    public void saveAllPrisoners(ObservableList<Prisoner> items) throws IOException {
        dalManager.setAllPrisoners(items);
    }
    
}
