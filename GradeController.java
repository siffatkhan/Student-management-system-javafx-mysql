package projectregistrationform;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;

/**
 *
 * @author Siffat ullah
 */
public class GradeController implements Initializable
{
    private FXMLDocumentController MainController = new FXMLDocumentController();
    
    @FXML
    private TextField SubjectNameTF;
    @FXML
    private TextField MarksObtainedTF;
    
    
    public void setMainController(FXMLDocumentController Controller)
    {
        this.MainController = Controller;
    }
    
    public void addDataGrade(ActionEvent event)
    {
        try {
            if (MainController.ov_Grade_Subject1.getText().isEmpty())
            {
                MainController.ov_Grade_Subject1.setText(SubjectNameTF.getText());
                MainController.ov_Grade_Subject1_Mark.setText(MarksObtainedTF.getText());
            }
            else
            {
                MainController.ov_Grade_Subject2.setText(SubjectNameTF.getText());
                MainController.ov_Grade_Subject2_Mark.setText(MarksObtainedTF.getText());
            }
            
            String Subject = SubjectNameTF.getText();
            String  Marks  = MarksObtainedTF.getText();
            String Query = "insert into grade values(\"" + Subject + "\", " + "\"" + Marks + "\")";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase", "root", "1998234");
            Statement  statement  = connection.createStatement();
            statement.executeUpdate(Query);
            
        } catch (SQLException ex) {
            Logger.getLogger(GradeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
            
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        //To-DO
    }
    
}