/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methodoverload;

/**
 *
 * @author jeppjleemoritzled
 */
public class Employee
{
    public Employee(String name, String SSN)
    {
        this.name=name;
        this.SSN = SSN;
    }

    public Employee(String name, String address, String SSN, String jobdescription, String bDate)
    {
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.jobdescription = jobdescription;
        this.bDate = bDate;
    }
    
    
    String name;
    String address;
    String SSN;
    String jobdescription;
    String bDate;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSSN()
    {
        return SSN;
    }

    public void setSSN(String SSN)
    {
        this.SSN = SSN;
    }

    public String getJobdescription()
    {
        return jobdescription;
    }

    public void setJobdescription(String jobdescription)
    {
        this.jobdescription = jobdescription;
    }

    public String getbDate()
    {
        return bDate;
    }

    public void setbDate(String bDate)
    {
        this.bDate = bDate;
    }
    
    
}
