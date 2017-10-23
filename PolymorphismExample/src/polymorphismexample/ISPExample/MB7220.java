/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polymorphismexample.ISPExample;

/**
 *
 * @author jeppjleemoritzled
 */
public class MB7220 extends CableModem
{
    
    public MB7220()
    {
        type = "MB7220";
    }

    @Override
    public String getSNMPVersion()
    {
        return "SNMPv2";
    }

    @Override
    public void update(String path)
    {
        // special handshake connection 
        // do other special stuff for MB7220
        //Update code here MB7220
    }

    
    
}
