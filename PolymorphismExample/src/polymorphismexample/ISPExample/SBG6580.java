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
public class SBG6580 extends CableModem
{
    public SBG6580()
    {
        type="SBG6580";
    }

    @Override
    public String getSNMPVersion()
    {
        return "SNMPv1";
    }
    
    @Override
    public void update(String path)
    {
        //Update code here for SBG6580
    }
    
}
