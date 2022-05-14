package GUI;

import Admin.Affiliation;
import Admin.Service;
import App.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.ResourceBundle;

public class StartController implements Initializable {

    @FXML
    private BorderPane loginPane;

    @FXML
    private ImageView home_view;

    @FXML
    private Button close_button;

    @FXML
    private TextField email_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button login_button;

    @FXML
    private ImageView logo_view;

    @FXML
    private Label login_message;


    @FXML
    private BorderPane registerPane;

    @FXML
    private ImageView background_view;

    @FXML
    private ImageView background_view_welcome;


    @FXML
    private TextField register_email_field;

    @FXML
    private TextField first_field;

    @FXML
    private TextField last_field;

    @FXML
    private TextField phone_field;

    @FXML
    private TextField national_field;

    @FXML
    private PasswordField register_password_field;

    @FXML
    private PasswordField register_repassword_field;

    @FXML
    private Button register_button;

    @FXML
    private Label register_message;

    @FXML
    private BorderPane welcomePane;

    @FXML
    private BorderPane servicePane;

    @FXML
    private Button accept_button;

    @FXML
    private Label welcome_label;

    @FXML
    private BorderPane topnetPane;

    @FXML
    private BorderPane stegPane;

    @FXML
    private BorderPane sonedePane;

    @FXML
    private TextField sonede_reference_field;

    @FXML
    private TextField sonede_phone_field;

    @FXML
    private TextField steg_reference_field;

    @FXML
    private TextField steg_phone_field;

    @FXML
    private TextField topnet_reference_field;

    @FXML
    private TextField topnet_phone_field;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File home = new File("public/Images/homedark.png");
        File logo = new File("public/Images/logo.png");
        File background = new File("public/Images/background.png");
        Image home_png = new Image(home.toURI().toString());
        Image logo_png = new Image(logo.toURI().toString());
        Image background_png = new Image(background.toURI().toString());
        home_view.setImage(home_png);
        logo_view.setImage(logo_png);
        background_view.setImage(background_png);
        home_view.setCache(true);
        logo_view.setCache(true);
        background_view.setCache(true);
    }


    public void loginButtonOnAction(ActionEvent event) throws SQLException {
        if (email_field.getText().isBlank() == true || password_field.getText().isBlank() == true) {
            login_message.setText("Failed to log in. All fields required");
            return;
        }
        String email = email_field.getText().toString();
        String password = password_field.getText().toString();
        User user = new User(email, password);
        Session.email = email;
        if (!(user.Authorized())) {
            login_message.setText("Failed to log in. User not found");
            return;
        }
        System.out.println(Session.id);

        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
        Stage mainWindow = new Stage();
        mainWindow.setTitle("CleverBill");
        Parent mainApp  = null;
        try {
            mainApp = FXMLLoader.load(getClass().getResource("sample.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mainWindow.initStyle(StageStyle.UNDECORATED);
        mainWindow.setScene(new Scene(mainApp, 1600,964));
        mainWindow.show();
    }


    public void registerSwitchButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        registerPane.toFront();
    }

    public void loginSwitchButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        loginPane.toFront();
    }

    public void registerButtonOnAction(ActionEvent event) throws SQLException {
        if (register_email_field.getText().isBlank() == true
                || register_password_field.getText().isBlank() == true
                || register_repassword_field.getText().isBlank() == true
                || first_field.getText().isBlank() == true
                || last_field.getText().isBlank() == true
                || phone_field.getText().isBlank() == true
                || national_field.getText().isBlank() == true) {
            register_message.setText("Failed to register. All fields required");
            return;
        }
        String password = register_password_field.getText();
        String rePassword = register_repassword_field.getText();
        if (!(password.equals(rePassword))) {
            register_message.setText("Failed to register. Passwords must match");
            return;
        }
        String first_name = first_field.getText().toString();
        String last_name = last_field.getText().toString();
        String email = register_email_field.getText().toString();
        Random rand = new Random();
        int user_id = 100;
        int national_id = Integer.parseInt(national_field.getText().toString());
        int phone_number = Integer.parseInt(phone_field.getText().toString());
        java.sql.Date creation_date = new java.sql.Date((new Date()).getTime());
        User user = new User(user_id, national_id, first_name, last_name, password, email, creation_date, phone_number);
        user.AddUser();
        Session.email = email;
        Session.id = user_id;
        welcome_label.setAlignment(Pos.CENTER);
        welcome_label.setText("Welcome " + first_name + "!");
        welcomePane.toFront();
    }


    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) close_button.getScene().getWindow();
        stage.close();
    }

    public void setUpButtonOnAction(ActionEvent event) {
        servicePane.toFront();
    }

    public void stegButtonOnAction(ActionEvent event) {
        stegPane.toFront();
    }

    public void topnetButtonOnAction(ActionEvent event) {
        topnetPane.toFront();
    }

    public void sonedeButtonOnAction(ActionEvent event) {
        sonedePane.toFront();
    }


    public void sonedeSynchronizeButtonOnAction(ActionEvent event) throws SQLException {
        int reference = Integer.parseInt(sonede_reference_field.getText().toString());
        int phone = Integer.parseInt(sonede_reference_field.getText().toString());
        Affiliation sonede = new Affiliation(phone, reference, 100, Affiliation.AffiliationType.SONEDE);
        sonede.addAffiliation();
        System.out.println(Session.id + " SYNCHRONIZED");
        servicePane.toFront();
    }

    public void stegSynchronizeButtonOnAction(ActionEvent event) throws SQLException {
        int reference = Integer.parseInt(steg_reference_field.getText().toString());
        int phone = Integer.parseInt(steg_reference_field.getText().toString());
        Affiliation steg = new Affiliation(phone, reference, 200, Affiliation.AffiliationType.STEG);
        steg.addAffiliation();
        System.out.println(Session.id + " SYNCHRONIZED");
        servicePane.toFront();
    }

    public void topentSynchronizeButtonOnAction(ActionEvent event) throws SQLException {
        int reference = Integer.parseInt(steg_reference_field.getText().toString());
        int phone = Integer.parseInt(steg_reference_field.getText().toString());
        Affiliation topnet = new Affiliation(phone, reference, 300, Affiliation.AffiliationType.TOPNET);
        topnet.addAffiliation();
        System.out.println(Session.id + " SYNCHRONIZED");
        servicePane.toFront();
    }

}

