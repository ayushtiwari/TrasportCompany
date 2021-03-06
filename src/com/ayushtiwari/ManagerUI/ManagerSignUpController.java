//This class is meant for Manager SignUp
//The details of manager username,name,password,email have been validated
//Accordingly,a manager will be created and our software is based on a single manager
package com.ayushtiwari.ManagerUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class ManagerSignUpController implements Initializable {

    @FXML
    private JFXTextField name;
    @FXML
    private JFXTextField email;
    @FXML
    private JFXTextField userName;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXPasswordField repassword;
    @FXML
    private JFXButton signUp;
    @FXML
    private Label passwordSameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //Adding Validators
        RequiredFieldValidator nameValidator = new RequiredFieldValidator();
        name.getValidators().add(nameValidator);
        nameValidator.setMessage("Required");

        name.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    name.validate();
                }
            }
        });

        RequiredFieldValidator emailValidator = new RequiredFieldValidator();
        email.getValidators().add(emailValidator);
        emailValidator.setMessage("Required");

        email.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    email.validate();
                }
            }
        });

        RequiredFieldValidator userNameValidator = new RequiredFieldValidator();
        userName.getValidators().add(userNameValidator);
        userNameValidator.setMessage("Required");

        userName.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    userName.validate();
                }
            }
        });

        RequiredFieldValidator passwordValidator = new RequiredFieldValidator();
        password.getValidators().add(emailValidator);
        passwordValidator.setMessage("Required");

        password.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    password.validate();
                }
            }
        });

        RequiredFieldValidator repasswordValidator = new RequiredFieldValidator();
        repassword.getValidators().add(emailValidator);
        repasswordValidator.setMessage("Required");

        repassword.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    repassword.validate();
                }
            }
        });

    }

    @FXML
    public void onSignUp(ActionEvent event) throws Exception {

        String managerName = name.getText();
        String managerEmail = email.getText();
        String managerUserName = userName.getText();
        String managerPassword = password.getText();
        String managerRepassword = repassword.getText();

        if (managerName.trim().length() == 0 || managerEmail.trim().length() == 0 || managerUserName.length() == 0 ||

                managerPassword.trim().length() == 0 || managerRepassword.length() == 0) {

            if (managerName.trim().length() == 0) {
                name.validate();
            }
            if (managerEmail.trim().length() == 0) {
                email.validate();
            }
            if (managerPassword.length() == 0) {
                password.validate();
            }
            if (managerUserName.length() == 0) {
                userName.validate();
            }
            if (managerRepassword.length() == 0) {
                repassword.validate();
            }
        } else if (!managerPassword.equals(managerRepassword)) {
            passwordSameLabel.setText("Password Confirmation Failed");
        } else if (managerPassword.equals(managerRepassword)) {

            passwordSameLabel.setText(" ");


            //Enter data
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/ayushtiwari/Documents/TransportCompany/TransportDatabase.db");
                Statement statement = conn.createStatement();

                statement.execute("INSERT INTO Manager VALUES('" + managerName + "','" + managerUserName + "','" + managerPassword + "','" + managerEmail + "')");

                statement.close();
                conn.close();


                Parent dashboard = FXMLLoader.load(getClass().getResource("managerDashboard.fxml"));
                Scene dashboardScene = new Scene(dashboard);
                Stage dashboardWindow = new Stage();
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.hide();
                dashboardWindow.setScene(dashboardScene);
                dashboardWindow.setTitle("Dashboard");
                dashboardWindow.setMaxHeight(728);
                dashboardWindow.setMaxWidth(1366);
                dashboardWindow.show();


            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Something went wrong. Please try again.");
                System.out.println("Something went wrong: " + e.getMessage());

            }
//
        }
    }

}
