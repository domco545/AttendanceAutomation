/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

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
 * @author narma
 */
public class TeacherMainController implements Initializable {

    @FXML
    private JFXButton classOverId;
    @FXML
    private JFXButton logoutId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/Login.fxml"));
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(TeacherMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void OverviewButton(ActionEvent event) {
        {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/TeacherClassOverview.fxml"));
                
                Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(TeacherMainController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}}