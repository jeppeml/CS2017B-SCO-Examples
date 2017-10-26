/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchinglists;

/**
 *
 * @author jeppjleemoritzled
 */
public class Person
{
    
    private String navn;

    private String adresse;

    public Person(String navn, String adresse)
    {
        this.navn = navn;
        this.adresse = adresse;
    }

    
    /**
     * Get the value of adresse
     *
     * @return the value of adresse
     */
    public String getAdresse()
    {
        return adresse;
    }

    /**
     * Set the value of adresse
     *
     * @param adresse new value of adresse
     */
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    /**
     * Get the value of navn
     *
     * @return the value of navn
     */
    public String getNavn()
    {
        return navn;
    }

    /**
     * Set the value of navn
     *
     * @param navn new value of navn
     */
    public void setNavn(String navn)
    {
        this.navn = navn;
    }

}
