/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jodi afandi
 */
public abstract class Perpustakaan {
    private IntegerProperty memberID;
    private StringProperty name;
    private StringProperty address;
    private ArrayList<Book> books;

    public Perpustakaan(Integer memberID, String name, String address, 
            ArrayList<Book> books) {
        this.memberID = new SimpleIntegerProperty(memberID);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.books = books;
    }
     public Perpustakaan(Integer memberID, String name, String address, 
             Book book) {
        books = new ArrayList<>();
        this.memberID = new SimpleIntegerProperty(memberID);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.books.add(book);
    }

    public Integer getMemberID() {
        return memberID.get();
    }

    public void setMemberID(Integer memberID) {
        this.memberID.set(memberID);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }
    public StringProperty nameProperty(){
        return name;
    }
    public StringProperty addressProperty(){
        return name;
    }
    public IntegerProperty memberIDProperty(){
        return memberID;
    }
     
}
