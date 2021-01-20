/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jodi afandi
 */
public class Member extends Perpustakaan{
        
        StringProperty gender;
        StringProperty birthdate;

    public Member(Integer memberID, String name,
            String address, String gender, String birthdate, ArrayList<Book> books) {
        super(memberID, name, address, books);
        this.gender = new SimpleStringProperty(gender);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    public Member(Integer memberID, String name, String address,
            String gender, String birthdate, Book book) {
        super(memberID, name, address, book);
        this.gender = new SimpleStringProperty(gender);
        this.birthdate = new SimpleStringProperty(birthdate);
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public String getBirthdate() {
        return birthdate.get();
    }

    public void setBirthdate(String birthdate) {
        this.birthdate.set(birthdate);
    }
    public StringProperty genderProperty() {
        return gender;
    }
    public StringProperty birthdateProperty() {
        return birthdate;
    }

}
