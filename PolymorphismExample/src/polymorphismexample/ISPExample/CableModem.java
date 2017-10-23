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
public abstract class CableModem
{
    String type;
    
    public String getMAC()
    {
        return "BE:EF:00:12:17";
    }
    
    public String getType()
    {
        return type;
    }
    
    public abstract String getSNMPVersion();
    
    
    public abstract void update(String path);
    
}
