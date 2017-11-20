/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.dal;

import java.util.ArrayList;
import java.util.List;
import jdbcwithguiprison.BE.Prisoner;

/**
 *
 * @author jeppjleemoritzled
 */
public class PrisonerDAO {
    public List<Prisoner> getAllPrisoners() {
        List<Prisoner> allPrisoners =
                new ArrayList();
        
        Prisoner p = new Prisoner();
        
        p.setId(0);
        p.setName("Peter Stegger");
        p.setNationality("Germany");
        p.setRace("Mixed");
        p.setSentenceLength(100);
        p.setSsn("423-434-666");
        
        allPrisoners.add(p);
        return allPrisoners;
    }
}
