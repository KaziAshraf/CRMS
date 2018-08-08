/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author ashraf
 */
public class Add_update_delete_vehicleController implements Initializable {

    @FXML
    private BorderPane aud_pane;
    @FXML
    private Label aud_title;
    @FXML
    private JFXTextField aud_Vehicle_name;
    @FXML
    private JFXComboBox<?> aud_Vehicle_Type;
    @FXML
    private JFXTextField aud_Vehicle_SL_no;
    @FXML
    private JFXComboBox<?> aud_Manu_Company;
    @FXML
    private JFXComboBox<?> aud_Status;
    @FXML
    private JFXTextField aud_Rent_Price;
    @FXML
    private JFXButton aud_Save;
    @FXML
    private JFXButton aud_Cancel;
    @FXML
    private DatePicker aud_Purchase_Date;
    @FXML
    private DatePicker aud_Last_Maintainance_Date;
    @FXML
    private DatePicker aud_Last_Rented;
    @FXML
    private DatePicker aud_Upcoming_Maintainance_Date;
    @FXML
    private ImageView aud_Car_Image;
    @FXML
    private TextField aud_Image_Path;
    @FXML
    private Button aud_Browse_Image;
    private String sql;
    private PreparedStatement pst;
    private ResultSet rs;
    private Connection conn;

    /**
     * Initializes the controller class.
     *
     * @param event
     */
    @FXML
    public void aud_handlebuttonAction(ActionEvent event) {
        if (event.getSource() == aud_Save) {
            try {
                sql = "INSERT INTO `db_CRMS`.`vehicles` (`vehicle_name`,`vehicle_type`,`vehicle_sl_no`,`status`,`rent_price`,`last_rented`,`image`,`Manufacturing_Company`,`Purchase_Date`,`Latest_Maitainance_Date`)"
                        + "VALUES(?,?,?,?,?,?,?,?,?,?)";
                pst = conn.prepareStatement(sql);
                pst.setString(1, aud_Vehicle_name.getText());
               // pst.setString(2, aud_Vehicle_Type.ge);
            } catch (SQLException ex) {
                Logger.getLogger(Add_update_delete_vehicleController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            conn = DBConnection.ConnectToDB();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Add_update_delete_vehicleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
