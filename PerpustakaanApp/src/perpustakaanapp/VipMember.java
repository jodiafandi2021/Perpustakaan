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
public class VipMember extends Perpustakaan {
    StringProperty contact;

    public VipMember(Integer memberID, String name, String address, String contact, ArrayList<Book> books) {
        super(memberID, name, address, books);
        this.contact=new SimpleStringProperty(contact);
    }

    public VipMember(Integer memberID, String name, String address, String contact, Book book) {
        super(memberID, name, address, book);
        this.contact.get();
    }

    public String getContact() {
        return contact.get();
    }

    public void setContact(String contact) {
        this.contact.set(contact);
    }
    public StringProperty contactProperty() {
        return contact;
    }

}
