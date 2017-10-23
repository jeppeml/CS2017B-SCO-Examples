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
public class SB6190  extends CableModem
{
    
    public SB6190()
    {
        type = "SB6190";
    }

    @Override
    public String getSNMPVersion()
    {
        return "SNMPv3";
    }
    
    @Override
    public void update(String path)
    {
        //Update code here SB6190
    }
    
}
