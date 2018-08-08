/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crms;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ashraf
 */
public class MessagesController implements Initializable {

    private int currentMessagePaneID;
    @FXML
    private BorderPane Messagespane;
    @FXML
    private JFXButton Inboxtab;
    @FXML
    private JFXButton SentItemstab;
    @FXML
    private JFXButton DraftsTab;
    @FXML
    private JFXButton ComposeTab;
    @FXML
    private JFXButton DeleteTab;
    @FXML
    private JFXButton DeleteTab1;
    @FXML
    private StackPane DefaultMessagePane;
    @FXML
    private BorderPane InboxPane;
    @FXML
    private BorderPane SentItemsPane;
    @FXML
    private BorderPane ComposePane;
    @FXML
    private BorderPane DraftsPane;
    @FXML
    private BorderPane DeletePane;

    public MessagesController() {
        this.currentMessagePaneID = 0;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleTabAction(ActionEvent event) throws IOException {
        if (event.getSource() == Inboxtab) {
            if (currentMessagePaneID != 0) {
                DefaultMessagePane.getChildren().get(currentMessagePaneID).setVisible(false);
            }
            DefaultMessagePane.getChildren().get(0).setVisible(true);
            currentMessagePaneID = 0;
            System.out.println(DefaultMessagePane.getChildren());
        }
        if (event.getSource() == SentItemstab) {
            if (currentMessagePaneID != 1) {
                DefaultMessagePane.getChildren().get(currentMessagePaneID).setVisible(false);
            }
            DefaultMessagePane.getChildren().get(1).setVisible(true);
            currentMessagePaneID = 1;
        }
        if (event.getSource() == DraftsTab) {
            if (currentMessagePaneID != 2) {
                DefaultMessagePane.getChildren().get(currentMessagePaneID).setVisible(false);
            }
            DefaultMessagePane.getChildren().get(2).setVisible(true);
            currentMessagePaneID = 2;
        }
        if (event.getSource() == ComposeTab) {
            if (currentMessagePaneID != 3) {
                DefaultMessagePane.getChildren().get(currentMessagePaneID).setVisible(false);
            }
            DefaultMessagePane.getChildren().get(3).setVisible(true);
            currentMessagePaneID = 3;
        }
        if (event.getSource() == DeleteTab) {
            if (currentMessagePaneID != 4) {
                DefaultMessagePane.getChildren().get(currentMessagePaneID).setVisible(false);
            }
            DefaultMessagePane.getChildren().get(4).setVisible(true);
            currentMessagePaneID = 4;
        }
    }

}
