/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import perpustakaanapp.db.DBconect;

/**
 *
 * @author jodi afandi
 */
public class PerpustakaanDataModel {
     private final Connection conn;

    public PerpustakaanDataModel(String driver) throws SQLException {
        this.conn= DBconect.getConnection(driver);
    }
    public void addPerpustakaan(Member perpus) throws SQLException{
        String insertPerpus = "INSERT INTO perpus (member_id, name, address)"
                + " VALUES (?,?,?)";
        String insertMember = "INSERT INTO member (member_id, gender, birthdate)"
                + " VALUES (?,?,?)";
        String insertBook = "INSERT INTO book (book_name, book_number)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtPerpus = conn.prepareStatement(insertPerpus);
        stmtPerpus.setInt(1, perpus.getMemberID());
        stmtPerpus.setString(2, perpus.getName());
        stmtPerpus.setString(3, perpus.getAddress());
        stmtPerpus.execute();
        
        PreparedStatement stmtMember = conn.prepareStatement(insertMember);
        stmtMember.setInt(1, perpus.getMemberID());
        stmtMember.setString(2, perpus.getGender());
        stmtMember.setString(3, perpus.getBirthdate());
        stmtMember.execute();
        
        PreparedStatement stmtBook = conn.prepareStatement(insertBook);
        stmtBook.setString(1, perpus.getBooks().get(0).getBookName());
        stmtBook.setDouble(2, perpus.getBooks().get(0).getBookNumber());
        stmtBook.setInt(3, perpus.getMemberID());
        stmtBook.execute();
    }
    public void addPerpustakaan(VipMember perpus) throws SQLException{
        String insertPerpus = "INSERT INTO perpus (member_id, name, address)"
                + " VALUES (?,?,?)";
        String insertVipMember = "INSERT INTO vip_member (member_id, contact)"
                + " VALUES (?,?)";
        String insertBook = "INSERT INTO account (book_name, book_number)"
                + " VALUES (?,?,?)";
        PreparedStatement stmtPerpus = conn.prepareStatement(insertPerpus);
        stmtPerpus.setInt(1, perpus.getMemberID());
        stmtPerpus.setString(2, perpus.getName());
        stmtPerpus.setString(3, perpus.getAddress());
        stmtPerpus.execute();
        
        PreparedStatement stmtVipMember = conn.prepareStatement(insertVipMember);
        stmtVipMember.setInt(1, perpus.getMemberID());
        stmtVipMember.setString(2, perpus.getContact());
        stmtVipMember.execute();
        
        PreparedStatement stmtBook = conn.prepareStatement(insertBook);
        stmtBook.setString(1, perpus.getBooks().get(0).getBookName());
        stmtBook.setDouble(2, perpus.getBooks().get(0).getBookNumber());
        stmtBook.setInt(3, perpus.getMemberID());
        stmtBook.execute();
    }
    
     public ObservableList<Member> getMember(){
        ObservableList<Member> data = FXCollections.observableArrayList();
        String sql="SELECT `member_id`, `name`,`address`, `gender`, `birthdate` "
                + "FROM `book` NATURAL JOIN `member` "
                + "ORDER BY name";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlBook = "SELECT book_number, book_name "
                    + "FROM book WHERE member_id="+rs.getInt(1);
                ResultSet rsBook = conn.createStatement().executeQuery(sqlBook);
                ArrayList<Book> dataBook = new ArrayList<>();
                while (rsBook.next()){
                    dataBook.add(new Book(rsBook.getString(1),rsBook.getDouble(2)));
                }
                data.add(new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5), dataBook));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PerpustakaanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
    }
     public ObservableList<VipMember> getVipMember(){
        ObservableList<VipMember> data = FXCollections.observableArrayList();
        String sql="SELECT `member_id`, `name`,`address`, `contact` "
                + "FROM `book` NATURAL JOIN `vip_member` "
                + "ORDER BY name";
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                String sqlBook = "SELECT acc_number, balance "
                    + "FROM Book WHERE holder_id="+rs.getInt(1);
                ResultSet rsBook = conn.createStatement().executeQuery(sqlBook);
                ArrayList<Book> dataBook = new ArrayList<>();
                while (rsBook.next()){
                    dataBook.add(new Book(rsBook.getString(1),rsBook.getDouble(2)));
                }
                data.add(new VipMember(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), dataBook));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PerpustakaanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return data;
     }
     
     public ObservableList<Book> getBook(int memberID){
        ObservableList<Book> data = FXCollections.observableArrayList();
        String sql="SELECT `book_name`, `nook_number` "
                + "FROM `Book` "
                + "WHERE member_id="+memberID;
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                data.add(new Book(rs.getString(1),rs.getDouble(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerpustakaanDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
     public int nextPerpustakaanID() throws SQLException{
        String sql="SELECT MAX(member_id) from book";
        ResultSet rs = conn.createStatement().executeQuery(sql);
        while (rs.next()){
                return rs.getInt(1)==0?1000001:rs.getInt(1)+1;
            }
        return 1000001;
    }
    
   public void addBooks(int holderID, Book acc) throws SQLException{
        String insertPerpus = "INSERT INTO book (member_id, book_name, book_number)"
                + " VALUES (?,?,?)";
  
        PreparedStatement stmtHolder = conn.prepareStatement(insertPerpus);
        stmtHolder.setInt(1, holderID);
        stmtHolder.setString(2, acc.getBookName());
        stmtHolder.setDouble(3, acc.getBookNumber());
        stmtHolder.execute();
        
    }
    
     
}
