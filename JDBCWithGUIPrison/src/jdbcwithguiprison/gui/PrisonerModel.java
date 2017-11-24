/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.gui;

import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jdbcwithguiprison.BE.Prisoner;
import jdbcwithguiprison.bll.BLLManager;

/**
 *
 * @author jeppjleemoritzled
 */
public class PrisonerModel {
    private BLLManager bllManager = new BLLManager();
    
    private ObservableList<Prisoner> pList
            = FXCollections.observableArrayList();

    public ObservableList<Prisoner> getPrisonersList() {
        return pList;
    }

    public void loadAll() {
        pList.clear();
        pList.addAll(bllManager.getAllPrisoners());
    }

    public void remove(Prisoner selectedPrisoner) {
        
        bllManager.remove(selectedPrisoner);
        pList.remove(selectedPrisoner);
    }

    public void add(Prisoner prisoner) {
        bllManager.add(prisoner);
        pList.add(prisoner);
    }

    public void update(Prisoner prisoner) {
        bllManager.update(prisoner);
    }
}
