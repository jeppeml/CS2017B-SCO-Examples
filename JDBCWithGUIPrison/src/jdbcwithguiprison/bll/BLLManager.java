/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.bll;

import java.util.List;
import jdbcwithguiprison.BE.Prisoner;
import jdbcwithguiprison.dal.PrisonerDAO;

/**
 *
 * @author jeppjleemoritzled
 */
public class BLLManager {
    PrisonerDAO pdao = new PrisonerDAO();
    
    public List<Prisoner> getAllPrisoners() {
        return pdao.getAllPrisoners();
    }
}
