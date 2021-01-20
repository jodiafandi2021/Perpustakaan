/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author jodi afandi
 */
public class Book {
    private StringProperty bookName;
    private DoubleProperty bookNumber;

    public Book(String bookName, double bookNumber) {
        this.bookName = new SimpleStringProperty(bookName);
        this.bookNumber = new SimpleDoubleProperty(bookNumber);
    }

    public String getBookName() {
        return bookName.get();
    }

    public void setBookName(String bookName) {
        this.bookName.set(bookName);
    }

    public Double getBookNumber() {
        return bookNumber.get();
    }

    public void setBookNumber(double bookNumber) {
        this.bookNumber.set(bookNumber);
    }
    public void deposite(double amt){
        this.bookNumber.set(this.bookNumber.get()+amt);
    }
    public void withdraw(double amt){
        this.bookNumber.set(this.bookNumber.get()-amt);
    }
    public StringProperty bookNameProperty(){
        return bookName;
    }
    public DoubleProperty balanceProperty(){
        return bookNumber;
    }
     
}
