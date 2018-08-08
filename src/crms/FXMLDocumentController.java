package crms;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {

    private int currentPaneID;
    private int togglesize;
    private double mainPane_width;
    private double mainPane_height;
    private Stage currentStage;
    private Scene currentScene;
   

    //main pane
    @FXML
    private JFXButton minimizebtn;
    @FXML
    private JFXButton vehicle_info_btn;
    @FXML
    private JFXButton Homebtn;
    @FXML
    private JFXButton Messagesbtn;
   @FXML
    private BorderPane Homepane;
   @FXML
    private StackPane Defaultpane;
   @FXML
    private BorderPane Messagespane;

    private BorderPane vehicle_info_pane;
    @FXML
    private JFXButton closebtn;
    @FXML
    private JFXButton fullscreenbtn;

    

    public FXMLDocumentController() {
        this.togglesize = 0;
        this.currentPaneID = 0;
        
    }

    public void loadtoStackPane() throws IOException {
        addNodetoStackPane("Home.fxml", Homepane, Defaultpane, 1);
        addNodetoStackPane("Messages.fxml", Messagespane, Defaultpane, 0);
        addNodetoStackPane("vehicle_information.fxml", vehicle_info_pane, Defaultpane, 0);
  
    }

    public void addNodetoStackPane(String FXMLname, BorderPane MenuPane, StackPane MainPane, int menuVisibility) throws IOException {
        MenuPane = FXMLLoader.load(getClass().getResource(FXMLname));
        MenuPane.prefWidthProperty().bind(MainPane.widthProperty());
        MenuPane.prefHeightProperty().bind(MainPane.heightProperty());
        MainPane.getChildren().add((Node) MenuPane);
        if (menuVisibility == 0) {
            MenuPane.setVisible(false);
        } else {
            MenuPane.setVisible(true);
        }
    }
  
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException, Exception {
        
        if (event.getSource() == Homebtn) {
            if (currentPaneID != 0) {

                Defaultpane.getChildren().get(currentPaneID).setVisible(false);
            }
            Defaultpane.getChildren().get(0).setVisible(true);
            currentPaneID = 0;
        }
        if (event.getSource() == Messagesbtn) {
            if (currentPaneID != 1) {
                Defaultpane.getChildren().get(currentPaneID).setVisible(false);
            }
            Defaultpane.getChildren().get(1).setVisible(true);
            currentPaneID = 1;
        }
        if (event.getSource() == vehicle_info_btn) {
            
            if (currentPaneID != 2) {
                Defaultpane.getChildren().get(currentPaneID).setVisible(false);
            }
            Defaultpane.getChildren().get(2).setVisible(true);
            currentPaneID = 2;
            System.out.println(vehicle_info_pane);
            //poupulateListView();
         
        }
        if (event.getSource() == closebtn) {
            currentStage = (Stage) closebtn.getScene().getWindow();
            currentStage.close();
        }
        if (event.getSource() == fullscreenbtn) {
            currentStage = (Stage) fullscreenbtn.getScene().getWindow();
            if (togglesize == 0) {
                currentStage.setMaximized(true);
                togglesize = 1;
            } else {
                currentStage.setMaximized(false);
                togglesize = 0;
            }
        }
        if (event.getSource() == minimizebtn) {
            currentStage = (Stage) minimizebtn.getScene().getWindow();
            currentStage.setIconified(true);
        }
    }
   
    
    @FXML
    public void handleVehiclebtnAction(ActionEvent event)
    {
        
    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

}
