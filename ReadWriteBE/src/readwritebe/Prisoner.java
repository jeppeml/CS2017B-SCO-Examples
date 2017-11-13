/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package readwritebe;

/**
 *
 * @author jeppjleemoritzled
 */
public class Prisoner {
    
    private final String ssn;
    private String name;
    private String race;
    private String country;
    private int sentenceLength;

    public Prisoner(String ssn, String name, String race, String country, int sentenceLength) {
        this.ssn = ssn;
        this.name = name;
        this.race = race;
        this.country = country;
        this.sentenceLength = sentenceLength;
    }
    
    public int getSentenceLength() {
        return sentenceLength;
    }

    public void setSentenceLength(int sentenceLength) {
        this.sentenceLength = sentenceLength;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSsn() {
        return ssn;
    }

    @Override
    public String toString() {
        return "Prisoner{" + "ssn=" + ssn + ", name=" + name + ", race=" + race + ", country=" + country + ", sentenceLength=" + sentenceLength + '}';
    }

    
}
