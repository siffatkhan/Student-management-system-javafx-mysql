package projectregistrationform;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.sql.*;

/**
 *
 * @author Siffatullah
 */
public class FXMLDocumentLoader extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent parent = FXMLLoader.load(getClass().getResource("1. Student.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Project One");
        stage.show();
    }
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}