/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saraf
 */
public class StudentEditProfileController implements Initializable {

    private User loggedInUser = new User();
    
    @FXML
    private JFXButton backButtonId;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void backButton(ActionEvent event) {
        {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/StudentMain.fxml"));
                Parent root = loader.load();
                
                StudentMainController smc = loader.getController();
                smc.setUser(loggedInUser);
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(StudentEditProfileController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
                
    }
    
    public void setUser(User user){
        this.loggedInUser = user;
    }
}
