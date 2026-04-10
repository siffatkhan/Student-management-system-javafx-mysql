package projectregistrationform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Siffat Ullah
 */
public class SubjectController implements Initializable 
{
    @FXML
    private TextField SubjectNameTF;
    @FXML
    private TextField TeacherNameTF;
    @FXML
    private TextField TeacherName2TF;
    @FXML
    private TextField AuthorNameTF;
    @FXML
    private TextField AuthorName2TF; 
    
    private FXMLDocumentController mainController;
    
    // Setter method to set the mainController instance
    public void setMainController(FXMLDocumentController controller) 
    {
        this.mainController = controller;
    }
    
    public void addDataSubject(ActionEvent event)
    {
        try {
            // Check if mainController is null to avoid NullPointerException
            if (mainController != null)
            {
                if (mainController.ov_Subject_Subject1.getText().isEmpty())
                    mainController.ov_Subject_Subject1.setText(SubjectNameTF.getText());
                else
                    mainController.ov_Subject_Subject2.setText(SubjectNameTF.getText());
            } else {
                System.out.println("Main controller is null.");
            }
            
            String Subject = SubjectNameTF.getText();
            String Author  = AuthorNameTF.getText() + " " + AuthorName2TF.getText();
            String Teacher = TeacherNameTF.getText() + " " + TeacherName2TF.getText();
            String Query = "insert into subject values(\"" + Subject + "\", " + "\"" + Author + "\", " + "\"" + Teacher + "\")";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase", "root", "1998234");
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
        } catch (SQLException ex) {
            Logger.getLogger(SubjectController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        //ToDo
    }
    
}