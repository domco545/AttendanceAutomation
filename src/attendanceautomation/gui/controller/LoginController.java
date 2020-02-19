/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package attendanceautomation.gui.controller;

import attendanceautomation.bll.BllFacade;
import attendanceautomation.bll.BllManager;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * FXML Controller class
 *
 * @author saraf
 */
public class LoginController implements Initializable {

    BllFacade bll = new BllManager();
    int loggedId;

    @FXML
    private JFXTextField txtName;
    @FXML
    private JFXTextField txtPass;
    @FXML
    private JFXRadioButton radioRemember;
    @FXML
    private JFXButton btnLogin;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void actionLogin(ActionEvent event) {
        String name = txtName.getText();
        String pass = txtPass.getText();

        if (validate(name, pass)) {
            authenticate(name, pass);
        }
        System.out.println("logged as " +loggedId);
    }

    private boolean validate(String name, String pass) {
        if (name.isEmpty() || pass.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Login");
            alert.setHeaderText("Password and Name needs to be filled");

            alert.showAndWait();
            return false;
        }
        return true;
    }

    private void authenticate(String name, String pass) {
        String hashed = hashPass(pass);
        loggedId = bll.authenticate(name, hashed);

        if (loggedId == -1) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Login");
            alert.setHeaderText("Wrong name or password");

            alert.showAndWait();
        }
    }

    private String hashPass(String pass) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(pass.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
