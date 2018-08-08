package crms;

import com.mysql.jdbc.Connection;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CRMS extends Application {

    private static Connection conn;

    @Override
    public void start(Stage stage) throws Exception {
        try {
            stage.initStyle(StageStyle.UNDECORATED);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            FXMLDocumentController controller = loader.getController();
            controller.loadtoStackPane();
            DBConnection.ConnectToDB();
            

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {

        launch(args);
    }

}
