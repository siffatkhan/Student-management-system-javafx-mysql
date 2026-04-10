package projectregistrationform;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Siffat ullah
 */
public class FXMLDocumentController implements Initializable
{
    @FXML
    private Button Student_BTN;
    @FXML
    private Button Subject_BTN;
    @FXML
    private Button Grade_BTN;
    @FXML
    private Button Employee_BTN;
    @FXML
    private BorderPane bp;
    @FXML
    private Text RegistrationForm;
    @FXML
    private Text PromptMessage;
    @FXML
    private Text StudentName;
    @FXML
    private Text FirstNameText;
    @FXML
    private Text LastNameText;
    @FXML
    private Text ADD;
    @FXML
    private TextField FirstName;
    @FXML
    private TextField LastName;
    @FXML
    private TextField AddressTextArea;
    @FXML
    private TextField EmailTextArea;
    @FXML
    private RadioButton Male;
    @FXML
    private RadioButton Female;
    @FXML
    private RadioButton Other;
    @FXML
    private ChoiceBox<String> CampusChoiceBox;
    @FXML
    private Label ov_name;
    @FXML
    private Label ov_gender;
    @FXML
    private Label ov_email;
    @FXML
    private Label ov_Address;
    @FXML
    public Label ov_Subject_Subject1;
    @FXML
    public Label ov_Subject_Subject2;
    
    @FXML
    public Label ov_Grade_Subject1;
    @FXML
    public Label ov_Grade_Subject2;
    @FXML
    public Label ov_Grade_Subject1_Mark;
    @FXML
    public Label ov_Grade_Subject2_Mark;
    
    @FXML
    private AnchorPane Center;
    @FXML
    private Button AddButton;
    @FXML
    private Pane CenterPane;
    @FXML
    private TextField TeacherNameTF;
    @FXML
    private TextField TeacherName2TF;
    @FXML
    private TextField SubjectNameTF;
    @FXML
    private TextField AuthorNameTF;
    @FXML
    private TextField AuthorName2TF;
    @FXML
    private Text SubjectName;
    @FXML
    private Text AuthorName;
    @FXML
    private FontAwesomeIcon TeacherNameicon;
    @FXML
    private FontAwesomeIcon SubjectNameIcon;
    @FXML
    private FontAwesomeIcon AuthorNameIcon;
    @FXML
    private FontAwesomeIcon Addicon;
    
    public void setScene(ActionEvent event) throws IOException
    {
        if (event.getSource() == Subject_BTN) 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("2. Subject.fxml"));
            Parent root = loader.load();

            if (bp != null)
                bp.setCenter(root);
            else
                System.out.println("BorderPane is Null");
            
            SubjectController subjectController = loader.getController();
            subjectController.setMainController(this);

        }
        
        else if (event.getSource() == Student_BTN) 
        {
            if (bp != null)
                bp.setCenter(Center);
            else
                System.out.println("BorderPane is Null");
            
        }
        
        else if (event.getSource() == Grade_BTN) 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("3. Grade.fxml"));
            Parent root = loader.load();

            if (bp != null)
                bp.setCenter(root);
            else
                System.out.println("BorderPane is Null");
            GradeController gradeController = loader.getController();
            gradeController.setMainController(this);
            
        }
        
        else if (event.getSource() == Employee_BTN) 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("4. Employee.fxml"));
            Parent root = loader.load();

            if (bp != null)
                bp.setCenter(root);
            else
                System.out.println("BorderPane is Null");
        }
        
        else
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("5. DataBase.fxml"));
            Parent root = loader.load();

            if (bp != null)
                bp.setCenter(root);
            else
                System.out.println("BorderPane is Null");
        }
    }
    //End of Set Scene or Changing Scene Method
    
    //Data from Student form to Overview
    public void addData(ActionEvent Event)
    {
        try {
            ov_name.setText(FirstName.getText() + " " + LastName.getText());
            if (Male.isSelected())
                ov_gender.setText("Male");
            else if (Female.isSelected())
                ov_gender.setText("Female");
            else if (Other.isSelected())
                ov_gender.setText("Other");
            ov_Address.setText(AddressTextArea.getText());
            ov_email.setText(EmailTextArea.getText());
            
            
            String name = FirstName.getText() + " " + LastName.getText();
            String address = AddressTextArea.getText();
            String Gender = ov_gender.getText();
            String Query = "insert into student values(\"" + name + "\", " + "\"" + address + "\", " + "\"" + Gender + "\")";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase", "root", "1998234");
            Statement statement = connection.createStatement();
            statement.executeUpdate(Query);
            
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        CampusChoiceBox.getItems().add("Peshawar");
        CampusChoiceBox.getItems().add("Quetta");
        CampusChoiceBox.getItems().add("Islamabad");
        CampusChoiceBox.getItems().add("Lahore");
        CampusChoiceBox.getItems().add("Karachi");
    }

}