/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ashraf
 */
public class Vehicle_informationController implements Initializable {

    @FXML
    private BorderPane vehicle_info_pane;
    @FXML
    private JFXTextField searchBar;
    @FXML
    private JFXListView<Label> vehicleList;
    @FXML
    private JFXButton addVehiclebtn;
    @FXML
    private JFXButton editVehiclebtn;
    @FXML
    private JFXButton deleteVehiclebtn;
    @FXML
    private ImageView vehicleImage;
    @FXML
    private Label Vehicle_Name;
    @FXML
    private Label Status;
    @FXML
    private Label Vehicle_type;
    @FXML
    private Label Company;
    @FXML
    private Label Vehicle_ID;
    @FXML
    private Label Vehicle_SL_no;
    @FXML
    private Label Maintainance_Date;
    @FXML
    private Label Purchase_Date;
    @FXML
    private Label Rent_Price;
    @FXML
    private Label Last_Rented;
//    @FXML
//    private DatePicker aud_Purchase_Date;
//    @FXML
//    private JFXComboBox<?> aud_Manu_Company;
//    @FXML
//    private JFXComboBox<?> aud_Vehicle_Type;
//    @FXML
//    private JFXComboBox<?> aud_Status;
//    @FXML
//    private JFXTextField aud_Rent_Price;
//    @FXML
//    private JFXTextField aud_Vehicle_name;
//    @FXML
//    private DatePicker aud_Upcoming_Maintainance_Date;
//    @FXML
//    private DatePicker aud_Last_Maintainance_Date;
//    @FXML
//    private DatePicker aud_Last_Rented;
//    @FXML
//    private JFXTextField aud_Vehicle_SL_no;
//    @FXML
//    private ImageView aud_Car_Image;
//    @FXML
//    private JFXButton aud_Save;
//    @FXML
//    private Button aud_Browse_Image;
//    @FXML
//    private JFXButton aud_Cancel;
//    @FXML
      private BorderPane aud_pane;
//    @FXML
//    private Label aud_title;
    
    private Connection conn;
    private ResultSet rs = null;
    private PreparedStatement pst = null;
    private String sql = null;
    final ObservableList vehicle_list_cell = FXCollections.observableArrayList();
    private Blob blob;
    private InputStream in;
    private BufferedImage bi;
    private final Stage aud_stage;
    private Scene aud_scene;
    private int x;
    public Vehicle_informationController() {
        this.aud_stage = new Stage();
        
    }
    /**
     * Initializes the controller class.
     *
     */
    private void Intialize_Stage()
    {
        aud_stage.initStyle(StageStyle.UNDECORATED);
    }
    public void PopulateListView() {
        try {
            
            conn = DBConnection.ConnectToDB();
            sql = "select vehicle_name,image from vehicles";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Label listcells = new Label(rs.getString(1));
                blob = rs.getBlob(2);
                in = blob.getBinaryStream();
                bi = ImageIO.read(in);
                Image image = SwingFXUtils.toFXImage(bi, null);
                ImageView imv = new ImageView(image);
                imv.setFitHeight(40);
                imv.setFitWidth(40);
                imv.setPreserveRatio(false);
                listcells.setGraphic(imv);
                vehicle_list_cell.add(listcells);
               
            }
            vehicleList.setItems(vehicle_list_cell);

        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(Vehicle_informationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void ListViewHandler() {
        try {
            Label lbl;
            int i;
            i = vehicleList.getSelectionModel().getSelectedIndex();
            sql = "select * from vehicles where id = "+i+1;
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while(rs.next())
            {
                Vehicle_ID.setText(Integer.toString(rs.getInt(1)));
                Vehicle_Name.setText(rs.getString(2));
                Vehicle_type.setText(rs.getString(3));
                Vehicle_SL_no.setText(rs.getString(4));
                Company.setText(rs.getString(9));
                Purchase_Date.setText(rs.getString(10));
                Status.setText(rs.getString(5));
                Rent_Price.setText(rs.getString(6));
                Last_Rented.setText(rs.getString(7));
                Maintainance_Date.setText(rs.getString(11));
                blob = rs.getBlob(8);
                in = blob.getBinaryStream();
                bi = ImageIO.read(in);
                Image image = SwingFXUtils.toFXImage(bi, null);
                vehicleImage.setImage(image);
            }

        } catch (SQLException ex) {
            System.out.println("wow");
        } catch (IOException ex) {
            Logger.getLogger(Vehicle_informationController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    @FXML
    void aud_btn_handler(ActionEvent event) throws IOException {
        if(event.getSource() == addVehiclebtn)
        {
            
            aud_pane = FXMLLoader.load(getClass().getResource("Add_update_delete_vehicle.fxml"));
            aud_scene = new Scene(aud_pane);
            aud_stage.setScene(aud_scene);
            aud_stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        PopulateListView();
        Intialize_Stage();
        System.out.println("crms.Vehicle_informationController.initialize()");
    }

}
