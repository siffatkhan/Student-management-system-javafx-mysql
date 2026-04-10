package projectregistrationform;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 *
 * @author Siffat ullah
 */
public class EmployeeController implements Initializable
{
    @FXML
    private TextField EmployeeNameTF, EmployeeName2TF, DesignationTF, SalaryTF;
    @FXML
    private DatePicker DOBDatePicker;

    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        //toDo
    }
    
    public void addDataEmployee(ActionEvent event)
    {
        try {
            String Employee = EmployeeNameTF.getText() + " " + EmployeeName2TF.getText();
            String Designation = DesignationTF.getText();
            LocalDate selectedDate = DOBDatePicker.getValue();
            String dob = selectedDate.toString();
            String Salary = SalaryTF.getText();
            String Query = "INSERT INTO employee (Employee_Name, Designation, Date_Of_Birth, Salary) VALUES (?, ?, ?, ?)";
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydatabase", "root", "1998234");
            PreparedStatement statement = connection.prepareStatement(Query);
            statement.setString(1, Employee);
            statement.setString(2, Designation);
            statement.setString(3, dob);
            statement.setString(4, Salary);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
