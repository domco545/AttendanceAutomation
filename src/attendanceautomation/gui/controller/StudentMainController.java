/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import attendanceautomation.bll.BllFacade;
import attendanceautomation.bll.BllManager;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author XMdag
 */
public class StudentMainController implements Initializable {

    BllFacade bll = new BllManager();
    private User loggedInUser = new User();
    
    @FXML
    private Text lblDate;
    @FXML
    private JFXButton btnConfirm;
    @FXML
    private Label lblName;
    @FXML
    private Label lblEmail;
    @FXML
    private JFXButton editProfileId;
    @FXML
    private JFXButton studentOverviewBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Date d = bll.getDate();
        Format formatter = new SimpleDateFormat("EEE dd MMM yyyy");
        lblDate.setText(formatter.format(d));
    }


    @FXML
    private void actionLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/Login.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @FXML
    private void studentEditProfileButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/studentEditProfile.fxml"));
            Parent root = loader.load();
            
            StudentEditProfileController sepc = loader.getController();
            sepc.setUser(loggedInUser);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToOverview(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/attendanceautomation/gui/view/StudentOverview.fxml"));
            Parent root = loader.load();
            
            StudentOverviewController soc = loader.getController();
            soc.setUser(loggedInUser);
            
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setUser(User user){
        this.loggedInUser = user;
        System.out.println(user.getFullName());
        lblName.setText(loggedInUser.getFullName());
        lblEmail.setText(loggedInUser.getEmail());
    }
}
