/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perpustakaanapp;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author jodi afandi
 */
public class PerpustakaanFormController implements Initializable {
    
    @FXML
    private TextField tfNewBookNumber1;

    @FXML
    private Button btnReload;

    @FXML
    private TableColumn<?, ?> colAddress1;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colName1;

    @FXML
    private TextField tfNewMemberID1;

    @FXML
    private TableView<?> tblAccount;

    @FXML
    private Button btnClear;

    @FXML
    private TextField tfAddress1;

    @FXML
    private TableColumn<?, ?> colBookName;

    @FXML
    private TableColumn<?, ?> colBookNumber;

    @FXML
    private TextField tfNewBookNumber;

    @FXML
    private Button btnAddBook1;

    @FXML
    private Label lblDBStatus;

    @FXML
    private Button btnAddSave1;

    @FXML
    private TableView<?> tblAccount1;

    @FXML
    private DatePicker dpBirthdate;

    @FXML
    private TableColumn<?, ?> colMemberID;

    @FXML
    private TextField tfMemberID1;

    @FXML
    private Button btnClear1;

    @FXML
    private TableColumn<?, ?> colContact1;

    @FXML
    private TableView<?> tblAccMember;

    @FXML
    private TextField tfNewMemberID;

    @FXML
    private ComboBox<String> cbGender;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private Button btnReload1;

    @FXML
    private TableColumn<?, ?> colBookNumber1;

    @FXML
    private TextField tfContact;

    @FXML
    private TextField tfAddress;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfName1;

    @FXML
    private TextField tfNewBookName;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfNewBookName1;

    @FXML
    private TableColumn<?, ?> colBirthdate;

    @FXML
    private Button btnAddBook;

    @FXML
    private Label lblSaveStatus;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colMemberID1;

    @FXML
    private TextField tfMemberID;

    @FXML
    private TableView<?> tblAccHolder1;

    @FXML
    private TableColumn<?, ?> colBookName1;

     private PerpustakaanDataModel ahdm;
    @FXML
    void handleSaveButton(ActionEvent event) {
        
        LocalDate ld = dpBirthdate.getValue();
        String birthdate = String.format("%d-%02d-%02d", ld.getYear(), ld.getMonthValue(), ld.getDayOfMonth());
        Member perpus = new Member(Integer.parseInt(tfMemberID.getText()),
                tfName.getText(),
                tfAddress.getText(),
                cbGender.getSelectionModel().getSelectedItem(),
                birthdate,
                new Book((tfNewBookName.getText()), Double.parseDouble(tfNewBookNumber.getText())));
        try {
            ahdm.addPerpustakaan(perpus);
        } catch (SQLException ex) {
            Logger.getLogger(PerpustakaanFormController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void handleReloadButton(ActionEvent event) {

    }

    @FXML
    void handleClearButton(ActionEvent event) {

    }


    @FXML
    void handleAddBookButton(ActionEvent event) {
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> gender = FXCollections.observableArrayList("Male", "Female");
        cbGender.setItems(gender);
        try {
            ahdm = new PerpustakaanDataModel("SQLITE");
             btnClear.fire();
            btnReload.fire();
        } catch (SQLException ex) {
            Logger.getLogger(PerpustakaanFormController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     } 
    }

