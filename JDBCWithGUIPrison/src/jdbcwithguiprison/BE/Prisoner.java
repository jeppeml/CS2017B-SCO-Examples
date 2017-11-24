/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcwithguiprison.BE;

import javafx.beans.property.*;

/**
 *
 * @author jeppjleemoritzled
 */
public class Prisoner {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty ssn = new SimpleStringProperty();
    private final StringProperty race = new SimpleStringProperty();
    private final StringProperty nationality = new SimpleStringProperty();
    private final IntegerProperty sentenceLength = new SimpleIntegerProperty();

    public int getSentenceLength() {
        return sentenceLength.get();
    }

    public void setSentenceLength(int value) {
        sentenceLength.set(value);
    }

    public IntegerProperty sentenceLengthProperty() {
        return sentenceLength;
    }
    

    public String getNationality() {
        return nationality.get();
    }

    public void setNationality(String value) {
        nationality.set(value);
    }

    public StringProperty nationalityProperty() {
        return nationality;
    }

    public String getRace() {
        return race.get();
    }

    public void setRace(String value) {
        race.set(value);
    }

    public StringProperty raceProperty() {
        return race;
    }

    public String getSsn() {
        return ssn.get();
    }

    public void setSsn(String value) {
        ssn.set(value);
    }

    public StringProperty ssnProperty() {
        return ssn;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String value) {
        name.set(value);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getId() {
        return id.get();
    }

    public void setId(int value) {
        id.set(value);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public String toString() {
        return "Prisoner{" + "id=" + id.getValue() + ", name=" + name.getValue() + ", ssn=" + ssn.getValue() + ", race=" + race.getValue() + ", nationality=" + nationality.getValue() + ", sentencelength=" + sentenceLength.getValue() + '}';
    }


}
