package GUI;

import Admin.Affiliation;
import Database.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private Button btnHome;

    @FXML
    private Button btnMyInfo;

    @FXML
    private Button btnGenerate;

    @FXML
    private Button btnMyStats;

    @FXML
    private Button btnNotifications;

    @FXML
    private Button btnSignOut;

    @FXML
    private Pane HomePane;

    @FXML
    private Pane NotificationsPane;

    @FXML
    private Pane GeneratePane;

    @FXML
    private Pane MyStatsPane;

    @FXML
    private Pane MyInfoPane;

    @FXML
    private Pane SignOutPane;

    @FXML
    private Label first_label;

    @FXML
    private Label email_label;

    @FXML
    private Label national_label;

    @FXML
    private Label date_label;

    @FXML
    private Label steg1;

    @FXML
    private Label steg2;

    @FXML
    private Label steg3;

    @FXML
    private Label steg4;

    @FXML
    private Label sonede1;

    @FXML
    private Label sonede2;

    @FXML
    private Label sonede3;

    @FXML
    private Label sonede4;

    @FXML
    private Label topnet1;

    @FXML
    private Label topnet2;

    @FXML
    private Label topnet3;

    @FXML
    private Label topnet4;

    @FXML
    private LineChart<String, Number> chart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void sonedeGenerateButtonOnAction(ActionEvent event) throws SQLException {
        Session.id = 100;
        String query = "select * from bill where user_id='" + Session.id + "' and reference='" + 100 + "'";
        Connector generate = new Connector();
        ResultSet result = generate.read(query);
        result.next();
        float unit = result.getFloat("unit_cost");
        float tax = result.getFloat("tax");
        float consumption = result.getFloat("consumption");
        float pay = unit * consumption * (1 + tax);

        sonede1.setText("Type : " + result.getString("bill_type"));
        sonede2.setText("consumption in L : " + result.getString("consumption"));
        sonede3.setText("To pay in DT: " + pay);
        sonede4.setText("Bill Ref : " + result.getString("bill_id"));
        generate.end();
    }

    public void stegGenerateButtonOnAction(ActionEvent event) throws SQLException {
        Session.id = 100;
        String query = "select * from bill where user_id='" + Session.id + "' and reference='" + 200 + "'";
        Connector generate = new Connector();
        ResultSet result = generate.read(query);
        result.next();
        float unit = result.getFloat("unit_cost");
        float tax = result.getFloat("tax");
        float consumption = result.getFloat("consumption");
        float pay = unit * consumption * (1 + tax);

        steg1.setText("Type : " + result.getString("bill_type"));
        steg2.setText("consumption in KW : " + result.getString("consumption"));
        steg3.setText("To pay in DT: " + pay);
        steg4.setText("Bill Ref : " + result.getString("bill_id"));
        generate.end();
    }

    public void topnetGenerateButtonOnAction(ActionEvent event) throws SQLException {
        Session.id = 100;
        String query = "select * from bill where user_id='" + Session.id + "' and reference='" + 300 + "'";
        Connector generate = new Connector();
        ResultSet result = generate.read(query);
        result.next();
        float unit = result.getFloat("unit_cost");
        float tax = result.getFloat("tax");
        float consumption = result.getFloat("consumption");
        float pay = unit * consumption * (1 + tax);

        topnet1.setText("Type : " + result.getString("bill_type"));
        topnet2.setText("consumption in GB: " + result.getString("consumption"));
        topnet3.setText("To pay in DT: " + pay);
        topnet4.setText("Bill Ref : " + result.getString("bill_id"));
        generate.end();
    }

    public void statGenerateButtonOnAction(ActionEvent event) throws SQLException {
        chart.getData().clear();
        XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String, Number>("January", 100));
        series.getData().add(new XYChart.Data<String, Number>("February", 333));
        series.getData().add(new XYChart.Data<String, Number>("March", 420));
        series.getData().add(new XYChart.Data<String, Number>("April", 97));
        chart.getData().add(series);
    }


    public void handleClicks(javafx.event.ActionEvent actionEvent) throws SQLException {
        if (actionEvent.getSource() == btnHome) {
            HomePane.toFront();
        }
        if (actionEvent.getSource() == btnMyInfo) {
            Session.id = 100;
            String query = "select * from user where user_id='" + Session.id + "'";
            Connector display = new Connector();
            ResultSet result = display.read(query);
            result.next();
            first_label.setAlignment(Pos.CENTER);
            email_label.setAlignment(Pos.CENTER);
            national_label.setAlignment(Pos.CENTER);
            date_label.setAlignment(Pos.CENTER);
            first_label.setText("UserName : " + result.getString("first_name"));
            email_label.setText("Email : " + result.getString("email"));
            national_label.setText("NID : " + result.getString("national_id"));
            date_label.setText("Creation Date : " + result.getString("creation_date"));
            display.end();
            MyInfoPane.toFront();
        }
        if (actionEvent.getSource() == btnGenerate) {
            GeneratePane.toFront();
        }
        if (actionEvent.getSource() == btnMyStats) {
            MyStatsPane.toFront();
        }
        if (actionEvent.getSource() == btnNotifications) {
            NotificationsPane.toFront();
        }
        if (actionEvent.getSource() == btnSignOut) {
            Session.id = 0;
            Session.email = null;
            Stage stage = (Stage) btnSignOut.getScene().getWindow();
            stage.close();
        }
    }


}
