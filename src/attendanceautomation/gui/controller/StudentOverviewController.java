/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.be.User;
import attendanceautomation.gui.controller.StudentMainController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.stage.Stage;
import javax.swing.JMenuItem;

/**
 * FXML Controller class
 *
 * @author narma
 */
public class StudentOverviewController implements Initializable {
    
    private User loggedInUser = new User();

    @FXML
    private SplitMenuButton classesdropdown;
    @FXML
    private SplitMenuButton periodsdropdown;

    private MenuItem weeks = new MenuItem("weeks");
    private MenuItem months = new MenuItem("months");
    private MenuItem semesters = new MenuItem("semesters");

    private MenuItem class1 = new MenuItem("SCO");
    private MenuItem class2 = new MenuItem("SDE");
    private MenuItem class3 = new MenuItem("ITO");
    private MenuItem class4 = new MenuItem("DBOS");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<MenuItem> periods = new ArrayList();
        periods.add(weeks);
        periods.add(months);
        periods.add(semesters);
        ObservableList<MenuItem> obsperiods = FXCollections.observableArrayList();
        obsperiods.setAll(periods);
        periodsdropdown.getItems().setAll(obsperiods);

        List<MenuItem> subjects = new ArrayList();
        subjects.add(class1);
        subjects.add(class2);
        subjects.add(class3);
        subjects.add(class4);
        ObservableList<MenuItem> obssubjects = FXCollections.observableArrayList();
        obssubjects.setAll(subjects);
        classesdropdown.getItems().setAll(obssubjects);

    }

    @FXML
    private void goBack(ActionEvent event) {
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
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void goToLogin(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/attendanceautomation/gui/view/Login.fxml"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StudentMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void previous(ActionEvent event) {
    }

    @FXML
    private void next(ActionEvent event) {
    }
    
    public void setUser(User user){
        this.loggedInUser = user;
    }
}
